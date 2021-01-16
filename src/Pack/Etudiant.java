package Pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Pack.InterfaceQuestion;

public class Etudiant extends Thread 
{
	
	String nom,filliere,prenom,cne;
	String mat;
	String ipServeur;
	int port=125;
	Socket socketClient;
	DataInputStream dataIn;
	DataOutputStream dataOut;
	InterfaceQuestion interfaceQuestion;
	int noteFinale;
	int numQuestion=1;
	int nombreQuestion=20;
	bd_question bd;


	public Etudiant(String nom, String prenom, String filliere, String cne,String mat) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.filliere = filliere;
		this.cne = cne;
		this.mat=mat;
	}
	

	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ",prenom=" + prenom + ",cne=" + cne +", filliere=" + filliere + "]";
	}

	public Etudiant() {
		new InterfaceDeConnexion(this,new Professeur("",""));
	}
	@Override
	public void run() {
		super.run();
		try {
			socketClient=new Socket(ipServeur,port);
			
			//envoyer le nom,cne, prenom et la matiere du QCM de l'etudiant au serveur
			dataOut=new DataOutputStream(socketClient.getOutputStream());
			dataOut.writeUTF(cne+"/"+nom+"/"+prenom+"/"+mat);
			
			//1ère itération: 1ère Question et les reste est dans sendAnswer()
			receiveQuestion(numQuestion);
			sendAnswer();
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Problème de connexion: pas de connexion avec le serveur");
			System.exit(0);
		}
	}
	
	
	public void receiveQuestion(int num) throws IOException
	{
		interfaceQuestion.numQuestion.setText("Question "+num);
		String q;
		//recevoir la question et enlever le |
		dataIn=new DataInputStream(socketClient.getInputStream());
		q = dataIn.readUTF();
		String[] str=q.split("_");
		
		//Ecrire tout dans l'interface Question
		interfaceQuestion.question.setText("<html>"+str[0]+"</html>");
		interfaceQuestion.choix1.setText(str[1]);
		interfaceQuestion.choix2.setText(str[2]);
		interfaceQuestion.choix3.setText(str[3]);
		interfaceQuestion.choix4.setText(str[4]);
	}
	public void sendAnswer()
	{
		interfaceQuestion.suivant.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{	//incrémenter le numQuestion chaque fois pour passer à la question suivante
				numQuestion++;
				try {
					if(numQuestion<=nombreQuestion)
					{
						//envoyer la réponse
					dataOut=new DataOutputStream(socketClient.getOutputStream());
					dataOut.writeUTF(interfaceQuestion.getSelectedButtonText(interfaceQuestion.bg));
					receiveQuestion(numQuestion);
					}
					else 
					{
						//envoyer la réponse de la dernière question
						dataOut=new DataOutputStream(socketClient.getOutputStream());
						dataOut.writeUTF(interfaceQuestion.getSelectedButtonText(interfaceQuestion.bg));
						
						interfaceQuestion.panel.remove(interfaceQuestion.choix1);
						interfaceQuestion.panel.remove(interfaceQuestion.choix2);
						interfaceQuestion.panel.remove(interfaceQuestion.choix3);
						interfaceQuestion.panel.remove(interfaceQuestion.choix4);
						interfaceQuestion.panel.remove(interfaceQuestion.suivant);
						interfaceQuestion.numQuestion.setText("");
						interfaceQuestion.panel.revalidate();
						interfaceQuestion.panel.repaint();
						
						//récupérer la note
						dataIn=new DataInputStream(socketClient.getInputStream());
						noteFinale=dataIn.read();
						
						//Ajouter le boutton se déconnecter
						interfaceQuestion.panel.add(interfaceQuestion.panel.add(interfaceQuestion.btnNewButton));
						//Afficher la note
						interfaceQuestion.question.setText("La note du QCM est "+noteFinale+"/20");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
	});
	}
}
