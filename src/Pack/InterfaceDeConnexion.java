package Pack;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class InterfaceDeConnexion extends JFrame {

	private JPanel panel;
	JButton buttonEtudiant ;
	JButton buttonProfesseur;
	Etudiant etudiant;
	Professeur professeur;
	EspaceEtudiant espaceEtudiant;
	EspaceProfesseur espaceProfesseur;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceDeConnexion frame = new InterfaceDeConnexion();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public InterfaceDeConnexion(Etudiant e,Professeur p) {
		this.etudiant=e;
		this.professeur=p;
		setTitle("Panneau de connexion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 516);
		setLocationRelativeTo(null);
		setResizable(false);
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel etudiant = new JLabel("");
		etudiant.setHorizontalAlignment(SwingConstants.CENTER);
		etudiant.setIcon(new ImageIcon(InterfaceDeConnexion.class.getResource("/images/10213-woman-student-light-skin-tone-icon.png")));
		etudiant.setBounds(467, 162, 178, 151);
		panel.add(etudiant);
		
		buttonEtudiant = new JButton("Espace Etudiant");
		buttonEtudiant.setForeground(SystemColor.textHighlightText);
		buttonEtudiant.setBackground(new Color(255, 204, 0));
		buttonEtudiant.setUI(new styleButton());
		buttonEtudiant.setFont(new Font("Monospaced", Font.PLAIN, 14));
		buttonEtudiant.setBounds(467, 324, 180, 40);
		buttonEtudiant.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				espaceEtudiant=new EspaceEtudiant(InterfaceDeConnexion.this.etudiant);
				
			}
		});
		panel.add(buttonEtudiant);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(InterfaceDeConnexion.class.getResource("/images/Teacher-male-icon.png")));
		lblNewLabel.setBounds(153, 155, 178, 158);
		panel.add(lblNewLabel);
		
		buttonProfesseur = new JButton("Espace Professeur");
		buttonProfesseur.setForeground(SystemColor.textHighlightText);
		buttonProfesseur.setBackground(new Color(0, 102, 153));
		buttonProfesseur.setUI(new styleButton());
		buttonProfesseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				espaceProfesseur=new EspaceProfesseur(InterfaceDeConnexion.this.professeur);
			}
		});
		buttonProfesseur.setFont(new Font("Monospaced", Font.PLAIN, 14));
		buttonProfesseur.setBounds(153, 324, 180, 40);
		panel.add(buttonProfesseur);
		
		JLabel arrierePlan = new JLabel("");
		arrierePlan.setIcon(new ImageIcon(InterfaceDeConnexion.class.getResource("/images/arri\u00E8re plan.jpg")));
		arrierePlan.setBounds(0, 0, 829, 487);
		panel.add(arrierePlan);
		setVisible(true);
	}
}
