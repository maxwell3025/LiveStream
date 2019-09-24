package src;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JFrame window = new JFrame();
	int width, height;
	BufferedImage finalFrame;
	Raycaster frame;

	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width,height));
		finalFrame = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		frame = new Raycaster(width,height, 10,10);
		window.setDefaultCloseOperation(3);
		window.add(this);
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	public void update(){
		frame.update();
		frame.copyToImage(finalFrame);
		repaint();
	}
	public void paint(Graphics g){
		g.drawImage(finalFrame, 0, 0, null);
	}
}
