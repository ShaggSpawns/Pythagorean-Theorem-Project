package pythagoreanProject;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ResourceGetter {
	
	// Arrow Image
	public static BufferedImage arrowImage() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(ResourceGetter.class.getResourceAsStream("images/arrowImg.png"));
		} catch (IOException e) {
			System.out.println("Could not load arrowImg.png");
		}
		return image;
	}
	
	// Replay Image
	public static ImageIcon replayButtonIcon() {
		ImageIcon image = null;
		try {
			URL imageURL = ResourceGetter.class.getResource("images/replayImg.png");
			image = new ImageIcon(imageURL);
		} catch (NullPointerException n) {
			System.out.println("Could not load replayImg.png");
		}
		return image;
	}
	
	// Cat Image
	public static ImageIcon catImg() {
		ImageIcon image = null;
		try {
			URL imageURL = ResourceGetter.class.getResource("images/catImg.jpg");
			image = new ImageIcon(imageURL);
		} catch (NullPointerException n) {
			System.out.println("Could not load catImg.jpg");
		}
		return image;
	}
	
	// Credits Text File
	public static InputStreamReader creditsText() {
		InputStreamReader file = new InputStreamReader(ResourceGetter.class.getResourceAsStream("texts/credits.txt"));
		return file;
	}
	
	// Pythagoras Text File
	public static InputStreamReader pythagorasText() {
		InputStreamReader file = new InputStreamReader(ResourceGetter.class.getResourceAsStream("texts/pythagoras.txt"));
		return file;
	}
}