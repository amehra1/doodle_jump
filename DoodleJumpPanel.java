import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;

public class DoodleJumpPanel  extends JPanel { 

	private BufferedImage image; 
	
	public DoodleJumpPanel() throws IOException {
		image = ImageIO.read(new File(
				"/Users/anikamehra/eclipse-workspace/DoodleJump/src/jump.png"
				));
		
		
	}
	
	Creature c = new Creature(); 

	Timer timer = new Timer(500,null);

	public static void main(String[] args) throws IOException {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		JFrame frame = new JFrame("Doodle Jump!!!!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		DoodleJumpPanel dp = new DoodleJumpPanel();
		frame.add(dp);
		dp.setPreferredSize(new Dimension(800,600));
		frame.pack();
		frame.setVisible(true);
		dp.setUpKeyMappings();
		dp.startGame();

	}
	private void setUpKeyMappings() {

		this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"left");
		this.getActionMap().put("left",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// what do you want to do when the left arrow is pressed?
				System.out.println("Hit left arrow!!");
			}
		});
		this.requestFocusInWindow();

	}

	private void startGame() {
		timer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				tick();
			}

		});
		timer.start();
	}
	protected void tick() {
		
		System.out.println("Timer went off!");
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image,350,500, 100, 100, this);
		

	}

}