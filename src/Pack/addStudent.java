package Pack;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class addStudent extends JPanel {
	private JTextField cne;
	private JTextField nom;
	private JTextField prenom;
	bd_Etudiant bd;
	Professeur professeur;
	/**
	 * Create the panel.
	 */
	public addStudent(Professeur professeur) {
		this.professeur=professeur;
		setBorder(null);
		setBounds(0,0,438,417);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CNE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(39, 93, 59, 26);
		add(lblNewLabel);
		
		cne = new JTextField();
		cne.setBounds(123, 93, 250, 26);
		add(cne);
		cne.setColumns(10);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(123, 150, 250, 26);
		add(nom);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(123, 204, 250, 26);
		add(prenom);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNom.setBounds(39, 148, 59, 26);
		add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrnom.setBounds(39, 202, 59, 26);
		add(lblPrnom);
		
		JButton inserer = new JButton("Insérer");
		inserer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		inserer.setForeground(Color.WHITE);
		inserer.setBackground(new Color(153, 0, 102));
		inserer.setUI(new styleButton());
		inserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(cne.getText().equals("")||nom.getText().equals("")||prenom.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champs !");
				else
				{
				try {
					bd=new bd_Etudiant();
					bd.inserer("bd_etudiant", cne.getText().toString(), nom.getText().toString(), prenom.getText().toString());
					JOptionPane.showMessageDialog(null, "L'étudiant est insérée dans la base de données");
					cne.setText("");
					nom.setText("");
					prenom.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		inserer.setBounds(96, 284, 102, 31);
		add(inserer);
		
		JButton retour = new JButton("Retour");
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				removeAll();
				revalidate();
				repaint();
				add(new ChoixEspaceProfesseur(professeur).panel);
			}
		});
		retour.setBackground(Color.GRAY);
		retour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retour.setForeground(Color.WHITE);
		retour.setUI(new styleButton());
		retour.setBounds(271, 283, 102, 31);
		add(retour);
		setVisible(true);
	}
}
