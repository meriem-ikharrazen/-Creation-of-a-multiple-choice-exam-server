package Pack;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AncienQCM extends JPanel {

	
	JButton java,sql,html;
	Professeur professeur;
	/**
	 * Create the panel.
	 */
	public AncienQCM(Professeur professeur)
	{
		this.professeur=professeur;
		setBounds(0,0,435,417);
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(AncienQCM.class.getResource("/images/sgl.png")));
		lblNewLabel.setBounds(34, 11, 135, 145);
		add(lblNewLabel);
		
		sql = new JButton("QCM en SQL");
		sql.setForeground(Color.WHITE);
		sql.setBackground(new Color(178, 34, 34));
		sql.setBounds(34, 167, 135, 30);
		sql.setUI(new styleButton());
		add(sql);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(AncienQCM.class.getResource("/images/Java-icon.png")));
		lblNewLabel_2.setBounds(250, 11, 135, 145);
		add(lblNewLabel_2);
		
		java = new JButton("QCM en Java");
		java.setUI(new styleButton());
		java.setForeground(Color.WHITE);
		java.setBackground(new Color(255, 51, 70));
		java.setBounds(250, 167, 135, 30);
		add(java);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(AncienQCM.class.getResource("/images/html-icon.png")));
		lblNewLabel_3.setBounds(141, 208, 135, 145);
		add(lblNewLabel_3);
		
		html = new JButton("QCM en Html");
		html.setUI(new styleButton());
		html.setForeground(Color.WHITE);
		html.setBackground(new Color(153, 102, 0));
		html.setBounds(151, 364, 135, 30);
		add(html);
		
		JButton retour = new JButton();
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				revalidate();
				repaint();
				add(new ChoixEspaceProfesseur(professeur).panel);
			}
		});
		retour.setIcon(new ImageIcon(AncienQCM.class.getResource("/images/return1.png")));
		retour.setBackground(Color.LIGHT_GRAY);
		retour.setUI(new styleButton());
		retour.setBounds(0, 0, 36, 23);
		add(retour);
		setVisible(true);
		html.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				revalidate();
				repaint();
				try {
					add(new TableauNoteEtudiants("bd_note","html",professeur));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		java.addActionListener(new ActionListener() {
				
				@Override
			public void actionPerformed(ActionEvent e) {
					removeAll();
					revalidate();
					repaint();
			try {
				add(new TableauNoteEtudiants("bd_note","java",professeur));
			} catch (SQLException e1) {
				e1.printStackTrace();
				}
				}
			});
			sql.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				revalidate();
				repaint();
				try {
					add(new TableauNoteEtudiants("bd_note","bd",professeur));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}

