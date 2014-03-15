package pythagoreanProject;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CreditsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public CreditsPanel() {
		setBorder(BorderFactory.createTitledBorder("References"));
		setLayout(null);
		setBackground(Color.WHITE);
		final JTextArea credits = new JTextArea();
		credits.setBackground(getBackground());
		credits.setEditable(false);
		
		final BufferedReader buffReader = new BufferedReader(ResourceGetter.creditsText());
		
		try {
			credits.read(buffReader, null);
			buffReader.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		credits.setBounds(5, 15, 760, 200);
		credits.requestFocusInWindow();
		add(credits);
		
		Cat c = new Cat();
		c.setBounds(0,0,800,600);
		add(c);
	}
	
	private class Cat extends JComponent {
		private static final long serialVersionUID = 1L;
		
		@Override
		protected void paintComponent(final Graphics g) {
			ResourceGetter.catImg().paintIcon(this, g, 350, 260);
		}
	}
}