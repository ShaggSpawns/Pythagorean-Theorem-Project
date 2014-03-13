package pythagoreanProject;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
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
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TheoremPanel extends JPanel implements ChangeListener, ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	
	float alpha = 0.0f;
	int currentStep = 1;
	
	final JSlider slider;
	final JButton replayBtn;
	
	public TheoremPanel() {
		setLayout(null);
		setBackground(Color.WHITE);
		slider = new JSlider(JSlider.VERTICAL,1,9,1);
		slider.setBounds(400, 68, 30, 415);
		slider.setInverted(true);
		slider.setFocusable(true);
		slider.setOpaque(false);
		slider.addChangeListener(this);
		add(slider);
		
		replayBtn = new JButton(new ImageIcon("images/replayImg.png"));
		replayBtn.setBounds(360, 480, 30, 30);
		replayBtn.setFocusable(false);
		replayBtn.addActionListener(this);
		add(replayBtn);
		addMouseListener(this);
		
		JComponent j = new JComponent() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(final Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(2));
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
				
				// Triangles
				g.drawPolygon(drawRightTriangle(104, 195, 180, 230, "NW"));
				g.drawPolygon(drawRightTriangle(104, 195, 340, 230, "NW"));
				g.drawLine(133, 230, 133, 125);
				g.drawLine(131, 229, 89, 207);
				g.drawLine(293, 230, 293, 125);
				g2.setStroke(new BasicStroke(1));
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
				
				//Triangle abc
				g.setColor(new Color(50,100,0));
				g.drawPolygon(drawRightTriangle(104, 195, 126, 470, "NW"));
				g.drawString("a", 135, 380);
				g.drawString("b", 68, 487);
				g.drawString("c", 52, 379);
				
				// Triangle a'b'c'
				g.drawPolygon(drawRightTriangle(60, 106, 215, 430, "NW"));
				g.drawString("a'", 222, 376);
				g.drawString("b'", 185, 446);
				g.drawString("c'", 170, 378);
				
				// Triangle xza'
				g.drawPolygon(drawRightTriangle(48, 86, 290, 420, "NW"));
				g.drawString("x", 295, 380);
				g.drawString("z", 265, 433);
				g.drawString("a'", 251, 381);
				
				//Triangle zyb'
				g.drawPolygon(drawRightTriangle(22, 44, 340, 405, "NW"));
				g.drawString("z", 344, 385);
				g.drawString("y", 329, 416);
				g.drawString("b'", 318, 384);
				
				g.drawString("Similar Triangles", 168, 484);
				g.setColor(Color.BLACK);
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
				
				// Labels
				g.drawString("x", 95, 168);
				g.drawString("y", 73, 213);
				g.drawString("z", 108, 212);
				g.drawString("a", 192, 136);
				g.drawString("b", 134, 252);
				g.drawString("c", 114, 115);
				g.drawString("a", 350, 136);
				g.drawString("b", 289, 252);
				g.drawString("c", 280, 115);
				g.drawString("a'", 298, 181);
				g.drawString("b'", 262, 245);
				g.drawString("c'", 252, 176);
				g.drawString("a'", 138, 181);
				g.drawString("b'", 100, 248);
				
				// Given
				g.setColor(new Color(50,100,0));
				g.setFont(g.getFont().deriveFont(16.0f));
				g.drawString("Given:", 430, 25);
				g.drawPolygon(triangleIcon(486, 25));
				g.drawString("abc ~", 488, 25);
				g.drawPolygon(triangleIcon(540, 25));
				g.drawString("a'b'c' ~", 542, 25);
				g.drawPolygon(triangleIcon(603, 25));
				g.drawString("xza' ~", 606, 25);
				g.drawPolygon(triangleIcon(657, 25));
				g.drawString("zyb'", 660, 25);
				
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
				g.drawString("1.) Given", 630, 80);
				
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
		};
		j.setBounds(0, 0, 800, 600);
		add(j);
	}
	
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
	
	private class ClearShow {
		public void paint(Graphics g) {
			g.setColor(getBackground());
			g.fillRect(0, 266, 358, 243);
		}
	}
	
	private class Step1 {
		public Step1() {
			alpha = 0.0f;
			new Timer(5,new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    alpha += 0.05f;
				    if (alpha >= 1.0f) {
				        alpha = 1.0f;
				    } else {
				        repaint();
				    }
				}
			}).start();
		}
	}

	private class Step2 {
		public Step2() {
			new Timer(5,new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			}).start();
		}
	}

	private class Step3 {
		public Step3() {
			new Timer(5,new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    
				}
			}).start();
		}
	}

	private class Step4 {
		public Step4() {
			new Timer(5,new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    
				}
			}).start();
		}
	}

	private class Step5 {
		public Step5() {
			new Timer(5,new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    
				}
			}).start();
		}
	}

	private class Step6 {
		public Step6() {
			new Timer(5,new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    
				}
			}).start();
		}
	}

	private class Step7 {
		public Step7() {
			new Timer(5,new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    
				}
			}).start();
		}
	}

	private class Step8 {
		public Step8() {
			new Timer(5,new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			}).start();
		}
	}

	private class Step9 {
		public Step9() {
			new Timer(5,new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    
				}
			}).start();
		}
	}
	
	@Override
	public void stateChanged(final ChangeEvent e) {
		System.out.println(slider.getValue());
		currentStep = slider.getValue();
		
		new ClearShow().paint(getGraphics());
		switch(currentStep) {
		case 1:
			new Step1();
			break;
		case 2:
			new Step2();
			break;
		case 3:
			new Step3();
			break;
		case 4:
			new Step4();
			break;
		case 5:
			new Step5();
			break;
		case 6:
			new Step6();
			break;
		case 7:
			new Step7();
			break;
		case 8:
			new Step8();
			break;
		case 9:
			new Step9();
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new ClearShow().paint(getGraphics());
		switch(currentStep) {
		case 1:
			new Step1();
			break;
		case 2:
			new Step2();
			break;
		case 3:
			new Step3();
			break;
		case 4:
			new Step4();
			break;
		case 5:
			new Step5();
			break;
		case 6:
			new Step6();
			break;
		case 7:
			new Step7();
			break;
		case 8:
			new Step8();
			break;
		case 9:
			new Step9();
			break;
		}
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