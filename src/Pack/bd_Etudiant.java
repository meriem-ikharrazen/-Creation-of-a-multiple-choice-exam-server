package Pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class bd_Etudiant
{
	Connection connection;
	public bd_Etudiant() throws SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Chargement du driver est OK");
		} 
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
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
	void afficher() throws Exception
	{
		String requette="select * from bd_etudiant";
		Statement st=connection.createStatement();
		ResultSet rs=st.executeQuery(requette);
		ResultSetMetaData meta=rs.getMetaData();
		while(rs.next())
		{
			for(int i=1;i<=meta.getColumnCount();i++)
				System.out.print(meta.getColumnName(i)+"-"+rs.getObject(i)+"|");	
		System.out.println();
		}
	}
	void inserer(String bd,String cne, String nom, String prenom,String mat, int note) throws SQLException
	{
		String requette="insert into "+ bd+" (cne , nom, prenom, matiere, note) values ('"+cne+"','"+nom+"','"+prenom+"','"+mat+"',"+note+");";
		Statement st=connection.createStatement();
		st.executeUpdate(requette);
	}
	
	public Boolean etud_exist(String nom_base,String cne,String nom,String prenom) throws SQLException
	{
		Boolean res=false;
		String requette="select * from "+nom_base+" where cne='"+cne+"' and nom='"+nom+"' and prenom='"+prenom+"'";
		try
		{
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery(requette);
			res=rs.next()?true:false;
		}
		catch(SQLException e)
		{
			e.getMessage();
		}
		System.out.println(res);
		return res;
	}
	public Boolean etud_exist(String nom_base,String cne,String mat) throws SQLException
	{
		Boolean res=false;
		String requette="select * from "+nom_base+" where cne='"+cne+"'and matiere='"+mat+"'";
		try
		{
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery(requette);
			res=rs.next()?true:false;
		}
		catch(SQLException e)
		{
			e.getMessage();
		}
		System.out.println(res);
		return res;
	}
	void inserer(String bd,String cne, String nom,String prenom) throws SQLException
	{
		String requette="insert into "+ bd+" (cne , nom, prenom) values ('"+cne+"','"+nom+"','"+prenom+"');";
		Statement st=connection.createStatement();
		st.executeUpdate(requette);
	}
	public static void main(String[] args) throws SQLException
	{
		bd_Etudiant bd=new bd_Etudiant();
		bd.etud_exist("bd_etudiant", "R131358259", "Ikharrazen", "Meriem");
	}
}
