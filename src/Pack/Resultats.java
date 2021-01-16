package Pack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Resultats extends JPanel 
{

	JPanel panel;
	Etudiant etudaint;
	ChoixEspaceEtudiant cee;
	bd_Etudiant bd;
	JTable table;
	
	public Resultats(Etudiant etudiant) throws SQLException 
	{
		this.etudaint=etudiant;
		setLayout(null);
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 379, 496);
		panel.setLayout(null);
		JButton retour = new JButton();
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				cee=new ChoixEspaceEtudiant(etudiant);
				panel.add(cee.panel);
			}
		});
		retour.setIcon(new ImageIcon(Resultats.class.getResource("/images/return1.png")));
		retour.setBackground(Color.LIGHT_GRAY);
		retour.setBounds(0, 0, 36, 23);
		panel.add(retour);
		
		table = new JTable();
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setBounds(0, 0, 886,400);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 93, 379, 309);
		panel.add(scrollPane);
		JPanel panel_tab = new JPanel();
		scrollPane.setColumnHeaderView(panel_tab);
		panel_tab.setBackground(Color.GRAY);
		panel_tab.setLayout(new BorderLayout(0, 0));
		UpdateTable("bd_note",etudiant.cne);
	}

	public void UpdateTable(String nom,String cne) throws SQLException
	{
		bd=new bd_Etudiant();
		String req="select nom , prenom , matiere, note from "+nom+" where cne='"+cne+"'";
		PreparedStatement pr=bd.connection.prepareStatement(req);
		ResultSet res=pr.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(res));
	}
}
