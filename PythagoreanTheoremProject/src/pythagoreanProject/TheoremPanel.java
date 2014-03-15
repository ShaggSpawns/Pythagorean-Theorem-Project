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
import java.awt.font.TextAttribute;
import java.text.AttributedString;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TheoremPanel extends JPanel implements ChangeListener, ActionListener/*, MouseListener*/ {
	private static final long serialVersionUID = 1L;
	
	float a1 = 0.0f;
	float a2 = 0.0f;
	float a3 = 0.0f;
	float a4 = 0.0f;
	float a5 = 0.0f;
	float a6_1 = 0.0f;
	float a6_2 = 0.0f;
	float a7 = 0.0f;
	float a8 = 0.0f;
	float a9 = 0.0f;
	int currentStep = 1;
	
	public static JSlider slider;
	public static JButton replayBtn;
	
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
		
		replayBtn = new JButton(ResourceGetter.replayButtonIcon());
		replayBtn.setBounds(360, 480, 30, 30);
		replayBtn.setFocusable(false);
		replayBtn.addActionListener(this);
		add(replayBtn);
		//addMouseListener(this);
		
		JComponent j = new JComponent() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(final Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(2));
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
				
				// Given Triangle #2
				g.drawPolygon(drawRightTriangle(104, 195, 180, 230, "NW"));
				g.drawLine(133, 230, 133, 125);
				g.drawLine(131, 229, 89, 207);
				
				// Given Triangle #1
				g.drawPolygon(drawRightTriangle(104, 195, 340, 230, "NW"));
				g.drawLine(293, 230, 293, 125);
				g2.setStroke(new BasicStroke(1));
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, a1));
				
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
				
				// Proportion #1
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, a2));
				g.setColor(Color.ORANGE);
				g.drawString(e1().getIterator(), 66, 284);
				g.setColor(Color.BLUE);
				g.setFont(getFont().deriveFont(16.0f));
				g.drawString("y", 83, 310);
				g.drawString("b'", 129, 310);
				g.drawLine(78, 320, 93, 320);
				g.drawString("=", 105, 326);
				g.drawLine(125, 320, 140, 320);
				g.drawString("b", 82, 342);
				g.drawString("c", 129, 342);
				
				// Proportion #2
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, a3));
				g.setColor(Color.ORANGE);
				g.drawString(e2().getIterator(), 241, 284);
				g.setColor(Color.BLUE);
				g.drawString("x", 258, 310);
				g.drawString("a'", 304, 310);
				g.drawLine(253, 320, 268, 320);
				g.drawString("=", 280, 326);
				g.drawLine(300, 320, 315, 320);
				g.drawString("a", 257, 342);
				g.drawString("c", 304, 342);
				
				// Equation #1
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, a4));
				g.drawString("b", 77, 380);
				g.drawString("b'", 87, 380);
				g.drawString("=", 105, 380);
				g.drawString("c", 123, 380);
				g.drawString("y", 133, 380);
				
				// Equation #2
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, a5));
				g.drawString("a", 252, 380);
				g.drawString("a'", 262, 380);
				g.drawString("=", 280, 380);
				g.drawString("c", 298, 380);
				g.drawString("x", 308, 380);
				
				// Equation #3.0
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, a6_1));
				g.setColor(Color.ORANGE);
				g.drawString(e3().getIterator(), 152, 382);
				g.setColor(Color.BLUE);
				g.drawString("a", 116, 423);
				g.drawString("a'", 126, 423);
				g.drawString("+", 144, 423);
				g.drawString("b", 162, 423);
				g.drawString("b'", 172, 423);
				g.drawString("=", 190, 423);
				
				// Equation #3.1 (Step 6)
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, a6_2));
				g.drawString("c", 208, 423);
				g.drawString("x", 218, 423);
				g.drawString("+", 236, 423);
				g.drawString("c", 254, 423);
				g.drawString("y", 264, 423);
				
				// Equation #3.2 (Step 7)
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, a7));
				g.drawString("c", 208, 423);
				g.drawString("(", 218, 423);
				g.drawString("x", 228, 423);
				g.drawString("+", 246, 423);
				g.drawString("y", 264, 423);
				g.drawString(")", 274, 423);
				
				// Equation #3.3 (Step 8)
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, a8));
				g.drawString("c", 208, 423);
				g.drawString("c'", 218, 423);
				
				// Pythagorean Theorem
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, a9));
				g.setColor(Color.RED);
				g.drawString(pyTheorem().getIterator(), 160, 320);
				g.drawString(proofShow().getIterator(), 210, 358);
				g2.setStroke(new BasicStroke(2));
				g.drawPolygon(drawRightTriangle(104, 195, 126, 470, "NW"));
				final float dash1[] = {10.0f};
				g2.setStroke(new BasicStroke(1.0f,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        10.0f, dash1, 0.0f));
				g.drawLine(78, 365, 78, 470);
				g2.setStroke(new BasicStroke(1));
				g.drawString("a = a'", 135, 380);
				g.drawString("b = b'", 63, 492);
				g.drawString("c = c'", 26, 379);
				g.drawImage(ResourceGetter.arrowImage(), 85, 392, null);
				
				// Set normal font
				g.setFont(getFont().deriveFont(12));
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
				g.drawString("x z a' ~", 550, 80);
				g.drawPolygon(triangleIcon(597, 80));
				g.drawString("z y b' ", 599, 80);
				g.drawString("1.) Given", 636, 80);
				
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
				g.drawString("3.)", 430, 180);
				g.drawString("x", 455, 180);
				g.drawString("a'", 478, 180);
				g.drawString("--- = ---", 451, 193);
				g.drawString("a", 454, 206);
				g.drawString("c", 478, 206);
				g.drawString("4.) bb' = cy", 430, 230);
				g.drawString("5.) aa' = cx", 430, 280);
				g.drawString("6.) aa' + bb' = cx + cy", 430, 330);
				g.drawString("7.) aa' + bb' = c ( x + y )", 430, 380);
				g.drawString("8.) aa' + bb' = cc'", 430, 430);
				
				// Reasons
				g.drawString("2.) If  similar  triangles,", 615, 130);
				g.drawString("     then  their  sides  are", 615, 143);
				g.drawString("     proportional.", 615, 156);
				g.drawString("3.) If  similar  triangles,", 615, 180);
				g.drawString("     then  their  sides  are", 615, 193);
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
	
	private AttributedString proofShow() {
		AttributedString as = new AttributedString("a2 + b2 = c2");
		as.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 1,2);
		as.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 6 ,7);
		as.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 11,12);
		as.addAttribute(TextAttribute.SIZE, 20);
		return as;
	}
	
	private AttributedString pyTheorem() {
		AttributedString as = new AttributedString("The Pythagorean Theorem");
		as.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL, 0, 23);
		as.addAttribute(TextAttribute.SIZE, 18);
		return as;
	}
	
	private AttributedString e1() {
		AttributedString as = new AttributedString("Equation 1");
		as.addAttribute(TextAttribute.SIZE, 18);
		return as;
	}
	
	private AttributedString e2() {
		AttributedString as = new AttributedString("Equation 2");
		as.addAttribute(TextAttribute.SIZE, 18);
		return as;
	}
	
	private AttributedString e3() {
		AttributedString as = new AttributedString("Equation 3");
		as.addAttribute(TextAttribute.SIZE, 18);
		return as;
	}
	
	@Override
	public void stateChanged(final ChangeEvent e) {
		//System.out.println(slider.getValue());
		if (currentStep != slider.getValue()) {
			currentStep = slider.getValue();
			switch(currentStep) {
			case 1:
				a2 = 0.0f;
				repaint();
				break;
			case 2:
				a1 = 0.0f;
				a3 = 0.0f;
				repaint();
				break;
			case 3:
				a2 = 1.0f;
				a4 = 0.0f;
				repaint();
				break;
			case 4:
				a2 = 1.0f;
				a3 = 1.0f;
				a5 = 0.0f;
				repaint();
				break;
			case 5:
				a2 = 1.0f;
				a3 = 1.0f;
				a4 = 1.0f;
				a6_1 = 0.0f;
				a6_2 = 0.0f;
				repaint();
				break;
			case 6:
				a2 = 1.0f;
				a3 = 1.0f;
				a4 = 0.0f;
				a5 = 0.0f;
				a6_1 = 0.0f;
				a6_2 = 0.0f;
				a7 = 0.0f;
				repaint();
				break;
			case 7:
				a2 = 1.0f;
				a3 = 1.0f;
				a6_1 = 1.0f;
				a6_2 = 0.0f;
				a8 = 0.0f;
				repaint();
				break;
			case 8:
				a2 = 1.0f;
				a3 = 1.0f;
				a6_1 = 1.0f;
				a7 = 0.0f;
				a9 = 0.0f;
				repaint();
				break;
			case 9:
				a2 = 0.0f;
				a3 = 0.0f;
				a6_1 = 0.0f;
				a8 = 0.0f;
				repaint();
				break;
			default:
				break;
			}
			new Timer(25,new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch(currentStep) {
					case 1:
						a1 += 0.05f;
					    if (a1 >= 1.0f) {
					        a1 = 1.0f;
					        break;
					    } else {
					        repaint();
					    }
						break;
					case 2:
						a2 += 0.05f;
					    if (a2 >= 1.0f) {
					        a2 = 1.0f;
					    } else {
					        repaint();
					    }
						break;
					case 3:
						a3 += 0.05f;
					    if (a3 >= 1.0f) {
					        a3 = 1.0f;
					    } else {
					        repaint();
					    }
						break;
					case 4:
						a4 += 0.05f;
					    if (a4 >= 1.0f) {
					        a4 = 1.0f;
					    } else {
					        repaint();
					    }
						break;
					case 5:
						a5 += 0.05f;
					    if (a5 >= 1.0f) {
					        a5 = 1.0f;
					    } else {
					        repaint();
					    }
						break;
					case 6:
						a6_1 += 0.05f;
						a6_2 += 0.05f;
					    if (a6_1 >= 1.0f && a6_2 >= 1.0f) {
					        a6_1 = 1.0f;
							a6_2 = 1.0f;
					    } else {
					        repaint();
					    }
						break;
					case 7:
						a7 += 0.05f;
					    if (a7 >= 1.0f) {
					        a7 = 1.0f;
					    } else {
					        repaint();
					    }
						break;
					case 8:
						a8 += 0.05f;
					    if (a8 >= 1.0f) {
					        a8 = 1.0f;
					    } else {
					        repaint();
					    }
						break;
					case 9:
						a9 += 0.05f;
					    if (a9 >= 1.0f) {
							a9 = 1.00f;
					    } else {
						    repaint();
						}
						break;
					}
				}
			}).start();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(currentStep) {
		case 1:
			a1 = 0.0f;
			repaint();
			break;
		case 2:
			a2 = 0.0f;
			repaint();
			break;
		case 3:
			a3 = 0.0f;
			repaint();
			break;
		case 4:
			a4 = 0.0f;
			repaint();
			break;
		case 5:
			a5 = 0.0f;
			repaint();
			break;
		case 6:
			a6_1 = 0.0f;
			a6_2 = 0.0f;
			repaint();
			break;
		case 7:
			a7 = 0.0f;
			repaint();
			break;
		case 8:
			a8 = 0.0f;
			repaint();
			break;
		case 9:
			a9 = 0.0f;
			break;
		}
		new Timer(25,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(currentStep) {
				case 1:
					a1 += 0.05f;
				    if (a1 >= 1.0f) {
				        a1 = 1.0f;
				        break;
				    } else {
				        repaint();
				    }
					break;
				case 2:
					a2 += 0.05f;
				    if (a2 >= 1.0f) {
				        a2 = 1.0f;
				        break;
				    } else {
				        repaint();
				    }
					break;
				case 3:
					a3 += 0.05f;
				    if (a3 >= 1.0f) {
				        a3 = 1.0f;
				        break;
				    } else {
				        repaint();
				    }
					break;
				case 4:
					a4 += 0.05f;
				    if (a4 >= 1.0f) {
				        a4 = 1.0f;
				        break;
				    } else {
				        repaint();
				    }
					break;
				case 5:
					a5 += 0.05f;
				    if (a5 >= 1.0f) {
				        a5 = 1.0f;
				        break;
				    } else {
				        repaint();
				    }
					break;
				case 6:
					a6_1 += 0.05f;
					a6_2 += 0.05f;
				    if (a6_1 >= 1.0f) {
				        a6_1 = 1.0f;
						a6_2 = 1.0f;
				        break;
				    } else {
				        repaint();
				    }
					break;
				case 7:
					a7 += 0.05f;
				    if (a7 >= 1.0f) {
				        a7 = 1.0f;
				        break;
				    } else {
				        repaint();
				    }
					break;
				case 8:
					a8 += 0.05f;
				    if (a8 >= 1.0f) {
				        a8 = 1.0f;
				        break;
				    } else {
				        repaint();
				    }
					break;
				case 9:
					a9 += 0.05f;
				    if (a9 >= 1.0f) {
						a9 = 1.00f;
				    } else {
				        repaint();
				    }
					break;
				}
			}
		}).start();
	}
	/*

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("(" + e.getX() + ", " + e.getY() + ")");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}*/
}