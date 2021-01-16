package Pack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ChoixEspaceProfesseur extends JPanel {

	public Professeur professeur;
	JPanel panel;
	
	/**
	 * Create the panel.
	 */
	public ChoixEspaceProfesseur(Professeur professeur) 
	{
		setBorder(null);
		this.professeur=professeur;
		setBackground(Color.WHITE);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 435, 428);
		add(panel);
		panel.setLayout(null);
		JLabel nvQCM = new JLabel("");
		nvQCM.setHorizontalAlignment(SwingConstants.CENTER);
		nvQCM.setBounds(42, 34, 119, 119);
		panel.add(nvQCM);
		nvQCM.setIcon(new ImageIcon(ChoixEspaceProfesseur.class.getResource("/images/document-add-icon.png")));
		
		JButton btnNewButton = new JButton("Ajouter une question");
		btnNewButton.setBounds(31, 164, 151, 24);
		panel.add(btnNewButton);
		btnNewButton.setBackground(new Color(51, 102, 204));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setUI(new styleButton());
		
		JLabel ancienQCM = new JLabel("");
		ancienQCM.setHorizontalAlignment(SwingConstants.CENTER);
		ancienQCM.setBounds(259, 34, 119, 119);
		panel.add(ancienQCM);
		ancienQCM.setIcon(new ImageIcon(ChoixEspaceProfesseur.class.getResource("/images/Places-folder-documents-icon.png")));
		
		JButton btnNewButton_1 = new JButton("QCM cr\u00E9\u00E9s");
		btnNewButton_1.setBounds(259, 164, 128, 24);
		panel.add(btnNewButton_1);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setUI(new styleButton());
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				AncienQCM aqcm=new AncienQCM(professeur);
				panel.add(aqcm);
			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		
		JButton btnNewButton_2 = new JButton("Se d\u00E9connecter");
		btnNewButton_2.setUI(new styleButton());
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setBounds(0, 0, 128, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(ChoixEspaceProfesseur.class.getResource("/images/Actions-list-add-user-icon.png")));
		lblNewLabel.setBounds(47, 239, 114, 104);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Ajouter un \u00E9tudiant");
		btnNewButton_3.setUI(new styleButton());
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				addStudent as=new addStudent(professeur);
				panel.add(as);
			}
		});
		btnNewButton_3.setBackground(new Color(51, 153, 102));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBounds(31, 354, 151, 23);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(ChoixEspaceProfesseur.class.getResource("/images/Actions-view-list-details-icon.png")));
		lblNewLabel_1.setBounds(269, 239, 109, 91);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_4 = new JButton("Listes des \u00E9tudiants");
		btnNewButton_4.setUI(new styleButton());
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				TableauEtudiantGI tgi;
				try {
					tgi = new TableauEtudiantGI("bd_etudiant", professeur);
					panel.add(tgi);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBackground(new Color(0, 153, 255));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBounds(248, 354, 151, 23);
		panel.add(btnNewButton_4);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				addQuestions aq=new addQuestions(professeur);
				panel.add(aq);
			}
		});
		setVisible(true);
	}
}
