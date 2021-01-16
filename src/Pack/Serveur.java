package Pack;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;




import Pack.GenererQuestions;
import Pack.Serveur;


public class Serveur 
{
	public ServerSocket socServer;
	int port=125;
	InterfaceSeveur interfaceCorrection;
	public ArrayList<GenererQuestions> listEtudiant=new ArrayList<GenererQuestions>();

	public static void main(String[] args) throws IOException {
		new Serveur();
	}


	public Serveur() 
	{
		try {
			socServer=new ServerSocket(port);
			interfaceCorrection=new InterfaceSeveur();
			
			//l'écoute des étudiants
			while(true)
			{
				try 
				{
					Socket socketClient = socServer.accept();
					GenererQuestions gq=new GenererQuestions(socketClient,this);
					gq.start();
					this.listEtudiant.add(gq);
				} 
				catch (IOException e) 
				{
					e.getMessage();
				}
			}
		} 
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		
	}
}
