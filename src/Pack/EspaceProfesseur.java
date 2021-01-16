package Pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class EspaceProfesseur extends JFrame {

	private JPanel contentPane;
	private JTextField nomProf;
	JPanel panel_changeant;
	Professeur professeur;

	
	public EspaceProfesseur(Professeur professeur) {
		this.professeur=professeur;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 535);
		setTitle("Espace Professeur");
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel photo = new JLabel("");
		photo.setHorizontalAlignment(SwingConstants.CENTER);
		photo.setIcon(new ImageIcon(EspaceProfesseur.class.getResource("/images/el.jpg")));
		photo.setBounds(0, 0, 416, 496);
		contentPane.add(photo);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(null);
		panel.setBounds(417, 0, 435, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel titre = new JLabel("Espace professeur");
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setFont(new Font("Monospaced", Font.PLAIN, 35));
		titre.setForeground(Color.WHITE);
		titre.setBounds(10, 11, 415, 58);
		panel.add(titre);
		addWindowFocusListener(new WindowAdapter() {
		    public void windowGainedFocus(WindowEvent e) {
		        photo.requestFocusInWindow();
		    }
		});
		
		
		String elements[]={"Sélectionner votre fillière","Informatique"};
		
		panel_changeant = new JPanel();
		panel_changeant.setBorder(null);
		panel_changeant.setBackground(Color.WHITE);
		panel_changeant.setBounds(417, 79, 435, 417);
		contentPane.add(panel_changeant);
		panel_changeant.setLayout(null);
		
		nomProf = new JTextField();
		nomProf.setBounds(67, 117, 283, 38);
		panel_changeant.add(nomProf);
		nomProf.setForeground(Color.GRAY);
		nomProf.setHorizontalAlignment(SwingConstants.CENTER);
		nomProf.setFont(new Font("Monospaced", Font.ITALIC, 16));
		nomProf.setText("Nom");
		nomProf.setColumns(10);
		
		
		JComboBox comboBox = new JComboBox(elements);
		comboBox.setBounds(67, 183, 283, 38);
		panel_changeant.add(comboBox);
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.GRAY);
		
		
		JLabel erreur = new JLabel("");
		erreur.setBounds(67, 244, 283, 14);
		erreur.setForeground(Color.RED);
		erreur.setHorizontalAlignment(SwingConstants.CENTER);
		erreur.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_changeant.add(erreur);
		
		
		JButton suivant = new JButton("Suivant");
		suivant.setBounds(153, 265, 125, 38);
		panel_changeant.add(suivant);
		suivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nomProf.getText().equals("Nom")||comboBox.getSelectedIndex()==0)
				{
					erreur.setText("Veuillez remplir tout les champs");
				}
				else
				{
					professeur.nom=nomProf.getText().toString();
					professeur.specialite=comboBox.getSelectedItem().toString();
					panel_changeant.remove(suivant);
					panel_changeant.remove(erreur);
					panel_changeant.remove(nomProf);
					panel_changeant.remove(comboBox);
					panel_changeant.revalidate();
					panel_changeant.repaint();
					panel_changeant.add(new ChoixEspaceProfesseur(professeur).panel);
					panel_changeant.setVisible(true);
				}
		}});
		suivant.setFont(new Font("Tahoma", Font.PLAIN, 18));
		suivant.setUI(new styleButton());
		
		nomProf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(nomProf.getText().equals(""))
				{
					nomProf.setText("Nom");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(nomProf.getText().equals("Nom"))
				{
					nomProf.setText("");
				}
				
			}
		});
		panel_changeant.setVisible(true);
		setVisible(true);
		
	}
	
}
