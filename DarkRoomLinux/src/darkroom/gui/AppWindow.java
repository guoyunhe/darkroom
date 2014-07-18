package darkroom.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

import darkroom.io.HostsIO;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AppWindow {

	private JFrame mainFrame;
	private JToggleButton toggleButton;
	private Image iconImage;
	private HostsIO hostsio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		hostsio = new HostsIO();
		
		boolean isLocked = hostsio.readHosts();
		
		mainFrame = new JFrame();
		mainFrame.setTitle("小黑屋/真的要来不及了！");
		mainFrame.setBounds(20, 20, 300, 200);
		iconImage = Toolkit.getDefaultToolkit().getImage("icon.png");
		mainFrame.setIconImage(iconImage);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		
		mainFrame.getContentPane().setBackground(Color.WHITE);
		mainFrame.getContentPane().setLayout(null);
		
		toggleButton = new JToggleButton("关进小黑屋");
		toggleButton.setBounds(90, 60, 120, 40);
		toggleButton.setFont(new Font("Dialog", Font.PLAIN, 16));
		toggleButton.setFocusPainted(false);
		toggleButton.setBackground(Color.BLACK);
		toggleButton.setForeground(Color.WHITE);
		toggleButton.setBorderPainted(false);
		toggleButton.addMouseListener(listener);
		mainFrame.getContentPane().add(toggleButton);
		
		// TODO Check if hosts is dark
		if(isLocked) {
			toggleButton.setSelected(true);
			mainFrame.getContentPane().setBackground(Color.BLACK);
			toggleButton.setForeground(Color.BLACK);
			toggleButton.setText("救出小黑屋");
		}
	}
	
	MouseListener listener = new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(toggleButton.isSelected()) {
				// Unselected -> Selected
				// Light -> Dark
				mainFrame.getContentPane().setBackground(Color.BLACK);
				toggleButton.setForeground(Color.BLACK);
				toggleButton.setText("救出小黑屋");
				hostsio.writeHosts(true);
			} else {
				// Selected -> Unselected
				// Dark -> Light
				mainFrame.getContentPane().setBackground(Color.WHITE);
				toggleButton.setForeground(Color.WHITE);
				toggleButton.setText("关进小黑屋");
				hostsio.writeHosts(false);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};
}
