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
		JTextArea credits = new JTextArea();
		
		FileReader FileReader = null;
		
		try {
			FileReader = new FileReader("texts/credits.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		BufferedReader buffReader = new BufferedReader(FileReader);
		
		try {
			credits.read(buffReader, null);
			buffReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		credits.requestFocusInWindow();
		add(new JScrollPane(credits));
	}
}