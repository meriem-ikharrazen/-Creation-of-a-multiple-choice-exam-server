package Pack;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class addQuestions extends JPanel {

	String data;
	bd_question bd;
	JButton inserer,retour;
	ButtonGroup bg;
	private JTextField choix1;
	private JTextField choix2;
	private JTextField choix3;
	private JTextField choix4;
	Professeur professeur;
	/**
	 * Create the panel.
	 */
	public addQuestions(Professeur professeur) 
	{
		this.professeur=professeur;
		setBounds(0,0,438,417);
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		
		inserer = new JButton("Ins\u00E9rer");
		inserer.setBounds(83, 371, 107, 35);
		add(inserer);
		inserer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		inserer.setBackground(new Color(204, 0, 102));
		inserer.setForeground(Color.WHITE);
		inserer.setUI(new styleButton());
		
		retour = new JButton("Retour");
		retour.setBounds(251, 371, 107, 35);
		add(retour);
		retour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retour.setBackground(new Color(104, 0, 150));
		retour.setForeground(Color.WHITE);
		retour.setUI(new styleButton());
		
		retour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				revalidate();
				repaint();
				add(new ChoixEspaceProfesseur(professeur).panel);
				
			}
		});
		
		JLabel matiere = new JLabel("Mati\u00E8re :");
		matiere.setFont(new Font("Tahoma", Font.PLAIN, 16));
		matiere.setBounds(26, 27, 71, 27);
		add(matiere);
		
		JLabel questionlabel = new JLabel("Question :");
		questionlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		questionlabel.setBounds(20, 77, 74, 25);
		add(questionlabel);
		
		JLabel choix1label = new JLabel("Choix 1 :");
		choix1label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		choix1label.setHorizontalAlignment(SwingConstants.CENTER);
		choix1label.setBounds(20, 164, 71, 20);
		add(choix1label);
		
		JLabel choix2label = new JLabel("Choix 2 :");
		choix2label.setHorizontalAlignment(SwingConstants.CENTER);
		choix2label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		choix2label.setBounds(20, 200, 71, 20);
		add(choix2label);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(107, 77, 308, 59);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea question = new JTextArea();
		question.setLineWrap(true);
		scrollPane.setViewportView(question);
		
		choix1 = new JTextField();
		choix1.setBounds(107, 159, 308, 25);
		add(choix1);
		choix1.setColumns(10);
		
		choix2 = new JTextField();
		choix2.setBounds(107, 195, 308, 25);
		add(choix2);
		choix2.setColumns(10);
		
		JLabel choix3label = new JLabel("Choix 3 :");
		choix3label.setHorizontalAlignment(SwingConstants.CENTER);
		choix3label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		choix3label.setBounds(20, 238, 71, 20);
		add(choix3label);
		
		choix3 = new JTextField();
		choix3.setColumns(10);
		choix3.setBounds(107, 231, 308, 25);
		add(choix3);
		
		JLabel choix4label = new JLabel("Choix 4 :");
		choix4label.setHorizontalAlignment(SwingConstants.CENTER);
		choix4label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		choix4label.setBounds(20, 276, 71, 20);
		add(choix4label);
		
		choix4 = new JTextField();
		choix4.setColumns(10);
		choix4.setBounds(107, 271, 308, 25);
		add(choix4);
		bg=new ButtonGroup();
		
		JRadioButton choix1Rep = new JRadioButton("Choix1");
		choix1Rep.setBounds(107, 320, 65, 23);
		add(choix1Rep);
		bg.add(choix1Rep);
		
		JLabel reponseLabel = new JLabel("R\u00E9ponse :");
		reponseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reponseLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		reponseLabel.setBounds(20, 319, 74, 20);
		add(reponseLabel);
		
		JRadioButton choix2Rep = new JRadioButton("Choix2");
		choix2Rep.setBounds(183, 320, 65, 23);
		add(choix2Rep);
		bg.add(choix2Rep);
		
		JRadioButton choix3Rep = new JRadioButton("Choix3");
		choix3Rep.setBounds(258, 320, 65, 23);
		add(choix3Rep);
		bg.add(choix3Rep);
		
		JRadioButton choix4Rep = new JRadioButton("Choix4");
		choix4Rep.setBounds(338, 320, 65, 23);
		add(choix4Rep);
		bg.add(choix4Rep);
		
		String elements[]={"bd","java","html"};
		JComboBox comboBox = new JComboBox(elements);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(107, 31, 308, 22);
		add(comboBox);
		inserer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(question.getText().equals("")||choix1.getText().equals("")||choix2.getText().equals("")||choix3.getText().equals("")||choix4.getText().equals("")||(choix1Rep.isSelected()==false&&choix2Rep.isSelected()==false&&choix3Rep.isSelected()==false&&choix4Rep.isSelected()==false))
					JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champs !");
				else
				{
					try {
						bd=new bd_question();
						bd.inserer(comboBox.getSelectedItem().toString(), question.getText().toString(), choix1.getText().toString(), choix2.getText().toString(), choix3.getText().toString(), choix4.getText().toString(), getSelectedButtonText(bg));
						JOptionPane.showMessageDialog(null, "La question est insérée !");
						question.setText("");
						choix1.setText("");
						choix2.setText("");
						choix3.setText("");
						choix4.setText("");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		setVisible(true);

	}
	
	//retourner la réponse de la question
	public String getSelectedButtonText(ButtonGroup buttonGroup) 
	{ for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) 
	{ AbstractButton button = buttons.nextElement(); 
	if (button.isSelected()) 
	{ 
		if(button.getText().equals("Choix1"))
		{
			return choix1.getText().toString();
		}
		else if(button.getText().equals("Choix2"))
		{
			return choix2.getText().toString();
		}
		else if(button.getText().equals("Choix3"))
		{
			return choix3.getText().toString();
		}
		else
			return choix4.getText().toString();
	} 
	}
	return null;
	}
	}
