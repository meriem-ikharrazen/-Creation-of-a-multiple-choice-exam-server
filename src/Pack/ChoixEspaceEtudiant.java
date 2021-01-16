package Pack;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class ChoixEspaceEtudiant extends JPanel {

	JPanel panel;
	Resultats resultat;
	Etudiant etudiant;
	FrameQCM fqcm;

	public ChoixEspaceEtudiant(Etudiant etudiant) 
	{
		setLayout(null);
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 379, 496);
		panel.setLayout(null);
		panel.setVisible(true);
		JButton qcmdispo;
		qcmdispo = new JButton("QCM Disponibles");
		qcmdispo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				fqcm=new FrameQCM(etudiant);
				panel.add(fqcm.panel_QCM);
			}
		});
		qcmdispo.setBounds(69, 150, 237, 39);
		panel.add(qcmdispo);
		qcmdispo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		qcmdispo.setUI(new styleButton());
		qcmdispo.setBackground(new Color(51, 102, 102));
		qcmdispo.setForeground(Color.WHITE);
		
		JButton res = new JButton("R\u00E9sultats");
		res.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				try {
					resultat=new Resultats(etudiant);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panel.add(resultat.panel);
			}
		});
		res.setFont(new Font("Tahoma", Font.PLAIN, 14));
		res.setUI(new styleButton());
		res.setForeground(Color.WHITE);
		res.setBackground(new Color(0, 51, 102));
		res.setBounds(69, 229, 237, 39);
		panel.add(res);
		
		JButton dec = new JButton("Se D\u00E9connecter");
		dec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		dec.setUI(new styleButton());
		dec.setForeground(Color.WHITE);
		dec.setBackground(new Color(51, 102, 204));
		dec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dec.setBounds(69, 300, 237, 39);
		panel.add(dec);
	}
}
