package Pack;



import javax.swing.JFrame;

import javax.swing.JLabel;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;

public class EspaceEtudiant extends JFrame 
{
	public JTextField nom;
	JPanel panel;
	Etudiant etudiant;
	private JTextField prenom;
	private JTextField cne;
	bd_Etudiant bd;
	ChoixEspaceEtudiant cee;

	/**
	 * Create the frame.
	 */
	public EspaceEtudiant(Etudiant e) {
		this.etudiant=e;
		//etudiant.espaceEtudiant=this;
		panel=new JPanel();
		panel.setBackground(Color.WHITE);
		setTitle("Espace Etudiant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 535);
		setLocationRelativeTo(null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 0, 474, 496);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Espace Etudiant");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 50));
		lblNewLabel.setBounds(37, 422, 390, 63);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setIcon(new ImageIcon(EspaceEtudiant.class.getResource("/images/pho6ef9fa54-0783-11e4-acf0-1c9e1483e45b-805x453.jpg")));
		lblNewLabel_1.setBounds(0, 0, 474, 411);
		panel_1.add(lblNewLabel_1);
		addWindowFocusListener(new WindowAdapter() {
		    public void windowGainedFocus(WindowEvent e) {
		        lblNewLabel_1.requestFocusInWindow();
		    }
		});
		String elements[]={"Sélectionner votre fillière","Génie Informatique"};
		getContentPane().add(panel);
		
		JPanel panel_changeant = new JPanel();
		panel_changeant.setBackground(Color.WHITE);
		panel_changeant.setBounds(470, 0, 392, 496);
		panel.add(panel_changeant);
		panel_changeant.setLayout(null);
		
		JLabel authentification = new JLabel("AUTHENTIFICATION");
		authentification.setBounds(73, 78, 255, 34);
		panel_changeant.add(authentification);
		authentification.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		cne = new JTextField();
		cne.setBounds(73, 137, 259, 39);
		panel_changeant.add(cne);
		cne.setForeground(Color.GRAY);
		cne.setHorizontalAlignment(SwingConstants.CENTER);
		cne.setText("CNE");
		cne.setFont(new Font("Monospaced", Font.PLAIN, 11));
		cne.setColumns(10);
		
		nom = new JTextField();
		nom.setBounds(73, 187, 259, 39);
		panel_changeant.add(nom);
		nom.setForeground(Color.GRAY);
		nom.setFont(new Font("Monospaced", Font.PLAIN, 11));
		nom.setHorizontalAlignment(SwingConstants.CENTER);
		nom.setText("Nom");
		nom.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(nom.getText().equals(""))
				{
					nom.setText("Nom");
					
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(nom.getText().equals("Nom"))
					
				{
					nom.setText("");
					
				}
				
			}
		});
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(73, 237, 259, 39);
		panel_changeant.add(prenom);
		prenom.setForeground(Color.GRAY);
		prenom.setHorizontalAlignment(SwingConstants.CENTER);
		prenom.setFont(new Font("Monospaced", Font.PLAIN, 11));
		prenom.setText("Pr\u00E9nom");
		prenom.setColumns(10);
		
		JButton login = new JButton("LOGIN");
		login.setBounds(121, 360, 172, 34);
		panel_changeant.add(login);
		login.setForeground(Color.WHITE);
		login.setBackground(new Color(0, 102, 204));
		login.setUI(new styleButton());
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 335, 372, 14);
		panel_changeant.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		JComboBox comboBox = new JComboBox(elements);
		comboBox.setBounds(73, 287, 259, 37);
		panel_changeant.add(comboBox);
		comboBox.setForeground(Color.GRAY);
		comboBox.setFont(new Font("Monospaced", Font.PLAIN, 12));
		comboBox.setBackground(Color.WHITE);
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nom.getText().equals("Nom")||prenom.getText().equals("Prénom")||cne.getText().equals("CNE")||comboBox.getSelectedIndex()==0) {
					lblNewLabel_2.setText("Veuillez remplir tous les champs");
				}
				else
				{
					try {
						bd=new bd_Etudiant();
						if(bd.etud_exist("bd_etudiant", cne.getText().toString(), nom.getText().toString(), prenom.getText().toString()))
						{
						etudiant.nom=nom.getText().toString();
						etudiant.prenom=prenom.getText().toString();
						etudiant.cne=cne.getText().toString();
						etudiant.filliere=comboBox.getSelectedItem().toString();
						panel_changeant.removeAll();
						panel_changeant.repaint();
						panel_changeant.revalidate();
						cee=new ChoixEspaceEtudiant(etudiant);
						panel_changeant.add(cee.panel);
						}
						else
							lblNewLabel_2.setText("Vous n'etes pas dans la base de données du G.Info");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		prenom.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(prenom.getText().equals(""))
				{
					prenom.setText("Prénom");
					
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(prenom.getText().equals("Prénom"))
					
				{
					prenom.setText("");
					
				}
				
			}
		});
		cne.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(cne.getText().equals(""))
				{
					cne.setText("CNE");
					
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(cne.getText().equals("CNE"))
					
				{
					cne.setText("");
					
				}
				
			}
		});
		setResizable(false);
		setVisible(true);
	}
}
