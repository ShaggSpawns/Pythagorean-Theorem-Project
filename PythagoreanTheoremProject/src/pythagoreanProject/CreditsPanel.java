package pythagoreanProject;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CreditsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public CreditsPanel() {
		setBorder(BorderFactory.createTitledBorder("References"));
		setLayout(new GridLayout(1,1));
		final JTextArea credits = new JTextArea();
		credits.setBackground(getBackground());
		credits.setEditable(false);
		
		FileReader FileReader = null;
		
		try {
			FileReader = new FileReader("texts/credits.txt");
		} catch (final FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		final BufferedReader buffReader = new BufferedReader(FileReader);
		
		try {
			credits.read(buffReader, null);
			buffReader.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		
		credits.requestFocusInWindow();
		add(new JScrollPane(credits));
	}
}