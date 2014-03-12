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

public class PythagorasPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PythagorasPanel() {
		setBorder(BorderFactory.createTitledBorder("The History of Pythagoras"));
		setLayout(new GridLayout(1,1));
		//setBackground(Color.lightGray);
		JTextArea pythagoras = new JTextArea();
		pythagoras.setEditable(false);
		pythagoras.setBackground(getBackground());
		
		FileReader FileReader = null;
		
		try {
			FileReader = new FileReader("texts/pythagoras.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		BufferedReader buffReader = new BufferedReader(FileReader);
		
		try {
			pythagoras.read(buffReader, null);
			buffReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		pythagoras.requestFocusInWindow();
		add(new JScrollPane(pythagoras));
	}
}