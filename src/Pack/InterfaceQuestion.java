package Pack;


import java.awt.Color;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceQuestion extends JPanel 
{
	JPanel panel;
	JLabel numQuestion;
	JLabel question;
	ButtonGroup bg;
	JButton suivant;
	JRadioButton choix1,choix2,choix3,choix4;
	Etudiant etudiant;	
	ChoixEspaceEtudiant cee;
	JButton retour;
	JButton btnNewButton;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public InterfaceQuestion(Etudiant etudiant) {
		this.etudiant=etudiant;
		bg=new ButtonGroup();
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 379, 496);
		panel.setLayout(null);
		
		suivant = new JButton("SUIVANT");
		suivant.setBounds(234, 455, 110, 30);
		panel.add(suivant);
		suivant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		suivant.setUI(new styleButton());
		suivant.setBackground(new Color(255, 0, 0));
		suivant.setForeground(Color.WHITE);
		
		choix4 = new JRadioButton("");
		choix4.setBounds(25, 407, 319, 23);
		panel.add(choix4);
		bg.add(choix4);
		
		choix3 = new JRadioButton("");
		choix3.setBounds(25, 368, 319, 23);
		panel.add(choix3);
		bg.add(choix3);
		
		choix2 = new JRadioButton("");
		choix2.setBounds(25, 328, 319, 23);
		panel.add(choix2);
		bg.add(choix2);
		
		choix1 = new JRadioButton("");
		choix1.setBounds(25, 288, 319, 23);
		panel.add(choix1);
		bg.add(choix1);
			
		question = new JLabel("");
		question.setHorizontalAlignment(SwingConstants.CENTER);
		question.setBounds(24, 61, 320, 198);
		panel.add(question);
		question.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		numQuestion = new JLabel("Question 1");
		numQuestion.setBounds(10, 11, 126, 36);
		panel.add(numQuestion);
		numQuestion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnNewButton = new JButton("Se d\u00E9connecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(234, 0, 145, 23);
		btnNewButton.setUI(new styleButton());
		
		
		panel.setVisible(true);
	}
	public String getSelectedButtonText(ButtonGroup buttonGroup) 
	{ for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) 
	{ AbstractButton button = buttons.nextElement(); 
	if (button.isSelected()) 
	{ return button.getText(); 
	} 
	}
	return null;
	}
	}
