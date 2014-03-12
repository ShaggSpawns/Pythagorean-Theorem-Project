package pythagoreanProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TheoremPanel extends JPanel implements ChangeListener, ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	
	final int currentStep = 0;
	
	final JSlider slider;
	final JButton replayBtn;
	
	public TheoremPanel() {
		setLayout(null);
		slider = new JSlider(JSlider.VERTICAL,1,9,1);
		slider.setBounds(400, 62, 30, 428);
		slider.setInverted(true);
		slider.setFocusable(true);
		slider.addChangeListener(this);
		add(slider);
		
		replayBtn = new JButton(new ImageIcon("images/replayImg.png"));
		replayBtn.setBounds(360, 480, 30, 30);
		replayBtn.setFocusable(false);
		replayBtn.addActionListener(this);
		add(replayBtn);
		addMouseListener(this);
		
		final TheoremComponents tComponenents = new TheoremComponents();
		tComponenents.setBounds(0, 0, 800, 600);
		add(tComponenents);
	}
	
	private class TheoremComponents extends JComponent {
		private static final long serialVersionUID = 1L;
		
		private Polygon drawRightTriangle(int a, int b, int x, int y, String orientation) {
			int[] xArray = null;
			int[] yArray = null;
			
			switch(orientation) {
			case "NE":
				xArray = new int[]{x,x+a,x};
				yArray = new int[]{y,y,y-b};
				break;
			case "NW":
				xArray = new int[]{x,x-a,x};
				yArray = new int[]{y,y,y-b};
				break;
			case "SE":
				xArray = new int[]{x,x+a,x};
				yArray = new int[]{y,y,y+b};
				break;
			case "SW":
				xArray = new int[]{x,x-a,x};
				yArray = new int[]{y,y,y+b};
				break;
			default:
				xArray = new int[]{x,x+a,x};
				yArray = new int[]{y,y,y+b};
			}
			Polygon p = new Polygon();
			p.xpoints = xArray;
			p.ypoints = yArray;
			p.npoints = 3;
			return p;
		}
		
		private Polygon triangleIcon(int x, int y) {
			Polygon p = new Polygon();
			p.xpoints = new int[]{x,x-4,x-8};
			p.ypoints = new int[]{y,y-8,y};
			p.npoints = 3;
			return p;
		}
		
		private AttributedString proveString() {
			AttributedString as = new AttributedString("Prove: a2 + b2 = c2");
			as.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 8,9);
			as.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 13,14);
			as.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 18,19);
			as.addAttribute(TextAttribute.SIZE, 16);
			return as;
		}
		
		private AttributedString proofString() {
			AttributedString as = new AttributedString("9.) a2 + b2 = c2");
			as.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 5,6);
			as.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 10,11);
			as.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 15,16);
			return as;
		}
		
		@Override
		protected void paintComponent(final Graphics g) {
			// Triangles
			g.drawPolygon(drawRightTriangle(165, 220, 180, 230, "NW"));
			g.drawPolygon(drawRightTriangle(165, 220, 380, 230, "NW"));
			g.setColor(getBackground());
			//g.fillPolygon(drawRightTriangle(72, 135, 197, 197, "NW"));
			
			// Given
			g.setColor(new Color(50,100,0));
			g.setFont(g.getFont().deriveFont(16.0f));
			g.drawString("Given:", 430, 25);
			g.drawPolygon(triangleIcon(456, 25));
			g.drawString("abc ~", 458, 25);
			g.drawPolygon(triangleIcon(499, 25));
			g.drawString("a'b'c' ~", 501, 25);
			g.drawPolygon(triangleIcon(548, 25));
			g.drawString("xza' ~", 550, 25);
			g.drawPolygon(triangleIcon(591, 25));
			g.drawString("zyb'", 593, 25);
			
			g.setFont(g.getFont().deriveFont(12.0f));
			g.drawString("1.)", 430, 80);
			g.drawPolygon(triangleIcon(456, 80));
			g.drawString("abc ~", 458, 80);
			g.drawPolygon(triangleIcon(499, 80));
			g.drawString("a'b'c' ~", 501, 80);
			g.drawPolygon(triangleIcon(548, 80));
			g.drawString("xza' ~", 550, 80);
			g.drawPolygon(triangleIcon(591, 80));
			g.drawString("zyb'", 593, 80);
			g.drawString("1.) Given", 615, 80);
			
			// Prove
			g.setColor(Color.RED);
			g.drawString(proveString().getIterator(), 430, 50);
			g.drawString(proofString().getIterator(), 430, 480);
			g.drawString("9.) Assume a = a',", 615, 480);
			g.drawString("    b = b', c = c'", 615, 493);
			
			
			// Statements
			g.setColor(Color.BLUE);
			g.drawString("2.)", 430, 130);
			g.drawString("y", 455, 130);
			g.drawString("b'", 478, 130);
			g.drawString("--- = ---", 451, 143);
			g.drawString("b", 455, 156);
			g.drawString("c", 478, 156);
			g.drawString("3.)  x         a'", 430, 180);
			g.drawString("    --- = --- ", 430, 193);
			g.drawString("      a         c", 430, 206);
			g.drawString("4.) bb' = cy", 430, 230);
			g.drawString("5.) aa' = cx", 430, 280);
			g.drawString("6.) aa' + bb' = cx + cy", 430, 330);
			g.drawString("7.) aa' + bb' = c ( x + y )", 430, 380);
			g.drawString("8.) aa' + bb' = cc'", 430, 430);
			
			// Reasons
			g.drawString("2.) If similar triangles,", 615, 130);
			g.drawString("     then their sides are", 615, 143);
			g.drawString("     proportional.", 615, 156);
			g.drawString("3.) If similar triangles,", 615, 180);
			g.drawString("     then their sides are", 615, 193);
			g.drawString("     proportional.", 615, 206);
			g.drawString("4.) Transitive Property", 615, 230);
			g.drawString("5.) Transitive Property", 615, 280);
			g.drawString("6.) Addition Property", 615, 330);
			g.drawString("7.) Distributive Property", 615, 380);
			g.drawString("8.) Substitution Property", 615, 430);
		}
	}

	@Override
	public void stateChanged(final ChangeEvent e) {
		if (slider.getValue() != currentStep) {
			System.out.println(slider.getValue());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Replay");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("(" + e.getX() + ", " + e.getY() + ")");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}