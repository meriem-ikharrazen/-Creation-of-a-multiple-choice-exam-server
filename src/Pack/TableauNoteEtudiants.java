package Pack;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.BorderLayout;

public class TableauNoteEtudiants extends JPanel {
	private JTable table;
	bd_Etudiant bd;
	Professeur professeur;
	
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public TableauNoteEtudiants(String nom,String mat, Professeur professeur) throws SQLException {
		this.professeur=professeur;
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(Color.WHITE);
		setBounds(0,0,886,535);
		setLayout(null);
		
		JButton Actualiser = new JButton("Actualiser");
		Actualiser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Actualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UpdateTable(nom,mat);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Actualiser.setBackground(new Color(140, 80, 80));
		Actualiser.setForeground(Color.WHITE);
		Actualiser.setBounds(83, 345, 107, 35);
		Actualiser.setUI(new styleButton());
		add(Actualiser);
		
		JButton retour = new JButton("Retour");
		retour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				revalidate();
				repaint();
				add(new AncienQCM(professeur));
			}
		});
		retour.setBackground(new Color(80, 180, 170));
		retour.setForeground(Color.WHITE);
		retour.setBounds(251, 345, 107, 35);
		retour.setUI(new styleButton());
		add(retour);
		
		JPanel panel_tab = new JPanel();
		panel_tab.setBackground(Color.GRAY);
		panel_tab.setBounds(0, 0, 437, 300);
		add(panel_tab);
		panel_tab.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setBounds(0, 0, 886,400);
		UpdateTable(nom,mat);
		JScrollPane scrollPane = new JScrollPane(table);
		panel_tab.add(scrollPane, BorderLayout.CENTER);

	}
	public void UpdateTable(String nom,String mat) throws SQLException
	{
		bd=new bd_Etudiant();
		String req="select cne , nom , prenom , note from "+nom +" where matiere='"+mat+"'";
		PreparedStatement pr=bd.connection.prepareStatement(req);
		ResultSet res=pr.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(res));
	}
}
