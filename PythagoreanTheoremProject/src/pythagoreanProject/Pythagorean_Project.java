package pythagoreanProject;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

/**
 * Creates a 800 x 600 JFrame with three tabs (Pythagorean Theorem Project, About Pythagoras, and Credits)
 * @author Jackson Wilson (c) 2014
 */
public class Pythagorean_Project {
	/**
	 * Main method for this application
	 * @param args
	 */
	public static void main(final String[] args) {
		final JFrame frame = new JFrame("Pythagorean Theorem Project");
		frame.setMinimumSize(new Dimension(800, 600));
		
		final JTabbedPane tPane = new JTabbedPane();
		final TheoremPanel theoremTab = new TheoremPanel();
		final PythagorasPanel pythagorasTab = new PythagorasPanel();
		final CreditsPanel creditTab = new CreditsPanel();
		
		tPane.setFocusable(false);
		tPane.addTab("Pythagorean Theorem Proof #13",theoremTab);
		tPane.addTab("About Pythagoras", pythagorasTab);
		tPane.addTab("Credits", creditTab);
		
		frame.add(tPane);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		TheoremPanel.replayBtn.doClick();
		TheoremPanel.slider.setValue(1);
	}
}