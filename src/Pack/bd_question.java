package Pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JLabel;




public class bd_question
{
	Connection connection;
	public bd_question() throws SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Chargement du driver est OK");
		} 
		catch (ClassNotFoundException e)
		{
			System.out.println("Chargement du Driver est ... NON");
			e.printStackTrace();
		}
		try 
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/qcm","root","");
			System.out.println("Base de données accesible...OK");
		}
		catch(Exception e)
		{
			System.out.println("Base de données accessible ... Non");
		}
	}
	//pour générer une seule question aléatoire
	Question questionsQCM() throws SQLException
	{
		Question question=null;
		String requette="select * from java order by rand() limit 1";
		Statement st=connection.createStatement();
		ResultSet rs=st.executeQuery(requette);
		while(rs.next())
		{
			question=new Question(rs.getInt("id"),rs.getObject("question").toString(),rs.getObject("reponse").toString(),rs.getObject("choix1").toString(),rs.getObject("choix2").toString(),rs.getObject("choix3").toString(),rs.getObject("choix4").toString());
			//System.out.println(question);
		}
		return question;
	}
	
	void inserer(String bd,String question,String choix1, String choix2, String choix3,String choix4, String reponse) 
	{
		try {
			String requette="insert into "+bd+" (question, choix1, choix2, choix3, choix4, reponse) values ('"+question+"','"+choix1+"','"+choix2+"','"+choix3+"','"+choix4+"','"+reponse+"');";
			Statement st=connection.createStatement();
			st.executeUpdate(requette);
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
	//pour généerer à la fois plusieurs questions
	Question[] questionsQCMtab(String nom,int nombre) throws SQLException
	{
		Question[] questions=new Question[nombre];
		int i=0;
		String requette="select * from "+nom+" order by rand() limit "+nombre;
		Statement st=connection.createStatement();
		ResultSet rs=st.executeQuery(requette);
		while(rs.next())
		{
			questions[i]=new Question(rs.getInt("id"),rs.getObject("question").toString(),rs.getObject("reponse").toString(),rs.getObject("choix1").toString(),rs.getObject("choix2").toString(),rs.getObject("choix3").toString(),rs.getObject("choix4").toString());
			//System.out.println(questions[i]);
			i++;
		}
		return questions;
	}
	//pour récupérer une image d'une base de donnée de tyle longblob l'image sera dans la base de donnée de type byte[]
	public byte[] recupImage(String nom,int id) throws SQLException
	{
		byte[] img = null;
		String requette="select image from "+nom+" where id="+id;
		PreparedStatement pr=connection.prepareStatement(requette);
		ResultSet rs=pr.executeQuery();
		if(rs.next())
		{
		img=rs.getBytes("image");
		/*ImageIcon image=new ImageIcon(img);
		java.awt.Image im=image.getImage();
		java.awt.Image myImg=im.getScaledInstance(l.getWidth(), l.getHeight(),java.awt.Image.SCALE_SMOOTH);
		ImageIcon imgg=new ImageIcon(myImg);*/
		}
		return img;
	}
}
