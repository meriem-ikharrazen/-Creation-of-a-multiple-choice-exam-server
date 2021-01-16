package Pack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField;

public class FrameQCM extends JPanel {

	Etudiant etudiant;
	JPanel panel_QCM;
	ChoixEspaceEtudiant cee;
	/**
	 * 
	 */

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameQCM frame = new FrameQCM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FrameQCM(Etudiant e) {
		this.etudiant=e;
		panel_QCM = new JPanel();
		panel_QCM.setBorder(null);
		panel_QCM.setBackground(Color.WHITE);
		panel_QCM.setBounds(0, 0, 389, 496);
		panel_QCM.setLayout(null);
		
		JButton seDeconnecter = new JButton("Se d\u00E9connecter");
		seDeconnecter.setBounds(261, 0, 128, 23);
		panel_QCM.add(seDeconnecter);
		seDeconnecter.setUI(new styleButton());
		seDeconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		seDeconnecter.setFont(new Font("Tahoma", Font.BOLD, 12));
		seDeconnecter.setBackground(UIManager.getColor("Button.light"));
		
		JButton btnNewButton_2 = new JButton("QCM en SQL");
		btnNewButton_2.setBounds(140, 415, 133, 26);
		panel_QCM.add(btnNewButton_2);
		btnNewButton_2.setUI(new styleButton());
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_QCM.removeAll();
				panel_QCM.repaint();
				panel_QCM.revalidate();
				etudiant.mat="bd";
				etudiant.start();
				etudiant.interfaceQuestion=new InterfaceQuestion(etudiant);
				panel_QCM.add(etudiant.interfaceQuestion.panel);
			}
		});
		btnNewButton_2.setBackground(new Color(0, 102, 204));
		btnNewButton_2.setForeground(Color.WHITE);
		
		JLabel sql = new JLabel("");
		sql.setBounds(148, 292, 113, 112);
		panel_QCM.add(sql);
		sql.setHorizontalAlignment(SwingConstants.CENTER);
		sql.setIcon(new ImageIcon(FrameQCM.class.getResource("/images/sgl.png")));
		
		JButton btnNewButton = new JButton("QCM en Java");
		btnNewButton.setBounds(28, 208, 128, 28);
		panel_QCM.add(btnNewButton);
		btnNewButton.setBackground(new Color(204, 0, 51));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setUI(new styleButton());
		
		JLabel javaQCM = new JLabel("");
		javaQCM.setBounds(28, 59, 128, 128);
		panel_QCM.add(javaQCM);
		javaQCM.setIcon(new ImageIcon(FrameQCM.class.getResource("/images/test.png")));
		
		JLabel html = new JLabel("");
		html.setBounds(211, 59, 143, 138);
		panel_QCM.add(html);
		html.setIcon(new ImageIcon(FrameQCM.class.getResource("/images/html-icon.png")));
		
		JButton btnNewButton_1 = new JButton("QCM en Html");
		btnNewButton_1.setBounds(221, 209, 133, 26);
		panel_QCM.add(btnNewButton_1);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setUI(new styleButton());
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_QCM.removeAll();
				panel_QCM.repaint();
				panel_QCM.revalidate();
				etudiant.mat="html";
				etudiant.start();
				etudiant.interfaceQuestion=new InterfaceQuestion(etudiant);
				panel_QCM.add(etudiant.interfaceQuestion.panel);
			}});
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_QCM.removeAll();
				panel_QCM.repaint();
				panel_QCM.revalidate();
				etudiant.mat="java";
				etudiant.start();
				etudiant.interfaceQuestion=new InterfaceQuestion(etudiant);
				panel_QCM.add(etudiant.interfaceQuestion.panel);
			}
		});
	}
}
