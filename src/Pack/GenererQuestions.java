package Pack;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class GenererQuestions extends Thread
{
	Socket socket;
	Serveur serveur;
	String cne="";
	String nom="";
	String prenom="";
	String mat;
	DataOutputStream dataOut;
	DataInputStream dataIn;
	bd_question bd;
	bd_Etudiant bd_etud;
	int i;
	String data;
	int note;
	String answer;
	int nombreQuestion=20;
	
	public GenererQuestions(Socket socket, Serveur serveur) {
		this.socket = socket;
		this.serveur = serveur;
	}
	
	@Override
	public void run() {
		
		try 
		{
			//Récupérerer les informations de l'étudiant
			dataIn = new DataInputStream(socket.getInputStream());
			String info_etud = dataIn.readUTF();
			String[] info=info_etud.split("/");
			cne=info[0];
			nom=info[1];
			prenom=info[2];
			mat=info[3];
			//Afficher les informations dans l'interface du serveur
			serveur.interfaceCorrection.textArea.append("\n"+nom+" "+prenom+" est connecté");
			//Bloquer les étudiants qui ont dèja passé le test
			bd_etud=new bd_Etudiant();
			if (bd_etud.etud_exist("bd_note",cne,mat))
			{
				JOptionPane pane=new JOptionPane("Vous avez dèjà passé le test !", JOptionPane.INFORMATION_MESSAGE);
				// On crée la boite de dialogue correspondante :
				JDialog dialog = pane.createDialog(null, "Attention..");
				// Que l'on met "toujours dessus" :
				dialog.setAlwaysOnTop(true);
		 
				// On affiche puis on détruit le dialog :
				dialog.setVisible(true);
				dialog.dispose();
				System.exit(0);
			}
			else
			{
			//Les 20 questions sont générées aléatoirement à la fois
			bd=new bd_question();
			Question[] q=bd.questionsQCMtab(mat,nombreQuestion);
			i=0;
			note=0;
			while(i<20)
			{
				sendQuestion(q[i]);
				data=receiveAnswer();
				if(data.equals(q[i].rep)) 
				{
					note=note+1;
				}
				i++;
			}
			//Insérer l'étudiant dans la base 
			bd_etud.inserer("bd_note", cne, nom, prenom, mat, note);
			
			//Envoyer la note du QCM
			dataOut=new DataOutputStream(socket.getOutputStream());
			dataOut.write(note);
			
			}
		} catch (IOException|SQLException e1) {
			e1.getMessage();
		} 
		
	}
	
	//Envoyer la question avec _ et les enlever dans le code Etudiant
	public void sendQuestion(Question q) throws IOException
	{
		dataOut=new DataOutputStream(socket.getOutputStream());
		dataOut.writeUTF(q.question+"_"+q.choix1+"_"+q.choix2+"_"+q.choix3+"_"+q.choix4);
	}
	 //recevoir la réponse
	 public String receiveAnswer() throws IOException
	 {
		 dataIn=new DataInputStream(socket.getInputStream());
		 answer=dataIn.readUTF();
		 return answer;
	 }
}
