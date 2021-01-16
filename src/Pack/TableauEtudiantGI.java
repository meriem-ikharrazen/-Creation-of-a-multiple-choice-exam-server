package Pack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TableauEtudiantGI extends JPanel {
	private JTable table;
	bd_Etudiant bd;
	Professeur professeur;
	
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public TableauEtudiantGI(String nom, Professeur professeur) throws SQLException 
	{
		this.professeur=professeur;
		setBorder(null);
		setBackground(Color.WHITE);
		setBounds(0,0,886,535);
		setLayout(null);
		
		JButton Actualiser = new JButton("Actualiser");
		Actualiser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Actualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UpdateTable(nom);
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
				add(new ChoixEspaceProfesseur(professeur).panel);
			}
		});
		retour.setBackground(new Color(80, 180, 170));
		retour.setForeground(Color.WHITE);
		retour.setBounds(251, 345, 107, 35);
		retour.setUI(new styleButton());
		add(retour);
		
		JPanel panel_tab = new JPanel();
		panel_tab.setBackground(Color.GRAY);
		panel_tab.setBounds(0, 67, 437, 233);
		add(panel_tab);
		panel_tab.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setBounds(0, 0, 886,400);
		UpdateTable(nom);
		JScrollPane scrollPane = new JScrollPane(table);
		panel_tab.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 11, 436, 45);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Liste des \u00E9l\u00E8ves ing\u00E9nieurs en G\u00E9nie Informatique");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(23, 11, 382, 29);
		panel.add(lblNewLabel);

	}
	public void UpdateTable(String nom) throws SQLException
	{
		bd=new bd_Etudiant();
		String req="select *from "+nom +"";
		PreparedStatement pr=bd.connection.prepareStatement(req);
		ResultSet res=pr.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(res));
	}
}
