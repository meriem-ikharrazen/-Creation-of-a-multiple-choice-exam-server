package Pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.CardLayout;

public class InterfaceSeveur extends JFrame {

	JPanel contentPane;
	JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public InterfaceSeveur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Serveur du QCM");
		setBounds(100, 100, 471, 503);
		contentPane = new JPanel();
		setResizable(false);
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Serveur du QCM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(InterfaceSeveur.class.getResource("/images/Home-Server-icon.png")));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea("Les étudiants connectés sont:");
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Arr\u00EAter le serveur");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setUI(new styleButton());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBackground(new Color(51, 102, 153));
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		setVisible(true);
	}
}
