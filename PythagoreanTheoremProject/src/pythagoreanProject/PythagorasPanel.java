package pythagoreanProject;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Builds the pythagoras panel with a JTextArea with its contents from pythagoras.txt
 * @author Jackson Wilson (c) 2014
 */
public class PythagorasPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Builds the pythagoras panel with a JTextArea with its contents from pythagoras.txt
	 */
	public PythagorasPanel() {
		setBorder(BorderFactory.createTitledBorder("The History of Pythagoras"));
		setLayout(new GridLayout(1,1));
		setBackground(Color.WHITE);
		JTextArea pythagoras = new JTextArea();
		pythagoras.setEditable(false);
		pythagoras.setBackground(getBackground());
		
		final BufferedReader buffReader = new BufferedReader(ResourceGetter.pythagorasText());
		
		try {
			pythagoras.read(buffReader, null);
			buffReader.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		
		pythagoras.requestFocusInWindow();
		add(new JScrollPane(pythagoras));
	}
}