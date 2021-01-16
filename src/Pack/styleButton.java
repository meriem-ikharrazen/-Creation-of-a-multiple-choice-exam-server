package Pack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

public class styleButton extends BasicButtonUI
{
	@Override
    public void installUI (JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
    }

    @Override
    public void paint (Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        super.paint(g, c);
    }

    private void paintBackground (Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g.setColor(c.getBackground().darker());
	    g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
	    g.setColor(c.getBackground());
	    g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Button UI Test");
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    JPanel p = new JPanel();
	    p.setBackground(Color.white);
	    f.setContentPane(p);
	    p.setLayout(new FlowLayout(5, 5,5));
	    p.setBorder(new EmptyBorder(10, 10, 10, 10));

	    for (int i = 1; i <= 5; i++) {
	        final JButton button = new JButton("Button #" + i);
	        button.setFont(new Font("Calibri", Font.PLAIN, 14));
	        button.setBackground(new Color(0x2dce98));
	        button.setForeground(Color.white);
	        // customize the button with your own look
	        button.setUI(new styleButton());
	        p.add(button);
	    }

	    f.pack();
	    f.setLocation(500, 500);
	    f.setVisible(true);
	}

}
