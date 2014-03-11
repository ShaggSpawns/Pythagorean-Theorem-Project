package pythagoreanProject;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TheoremPanel extends JPanel implements ChangeListener {
	private static final long serialVersionUID = 1L;
	
	final JSlider slider;
	
	public TheoremPanel() {
		setLayout(null);
		slider = new JSlider(JSlider.VERTICAL,0,10,10);
		slider.setBounds(400, 75, 22, 400);
		slider.addChangeListener(this);
		add(slider);
		
		final TheoremComponents tComponenents = new TheoremComponents();
		tComponenents.setBounds(0, 0, 800, 600);
		add(tComponenents);
	}
	
	private class TheoremComponents extends JComponent {
		private static final long serialVersionUID = 1L;
		
		@Override
		protected void paintComponent(final Graphics g) {
			g.fillRect(50, 200, 150, 2);
		}
	}

	@Override
	public void stateChanged(final ChangeEvent e) {
		System.out.println(slider.getValue());
	}
}