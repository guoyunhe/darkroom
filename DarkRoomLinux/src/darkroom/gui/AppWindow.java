package darkroom.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JToggleButton;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import darkroom.io.HostsIO;

import java.awt.Window.Type;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AppWindow {

	private JFrame mainFrame;
	private JToggleButton toggleButton;
	private HostsIO hostio;

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
		hostio = new HostsIO();
		
		mainFrame = new JFrame();
		mainFrame.setAlwaysOnTop(true);
		mainFrame.setTitle("小黑屋/真的要来不及了！");
		mainFrame.setBounds(20, 20, 300, 200);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		mainFrame.getContentPane().setBackground(Color.WHITE);
		mainFrame.getContentPane().setLayout(null);
		
		toggleButton = new JToggleButton("关进小黑屋");
		toggleButton.setBounds(90, 60, 120, 40);
		toggleButton.setFont(new Font("Arial", Font.PLAIN, 16));
		toggleButton.setFocusPainted(false);
		toggleButton.setBackground(Color.BLACK);
		toggleButton.setForeground(Color.WHITE);
		toggleButton.setBorderPainted(false);
		toggleButton.addMouseListener(listener);
		mainFrame.getContentPane().add(toggleButton);
		
		// TODO Check if hosts is dark
		// toggleButton.setSelected(true);
	}
	
	MouseListener listener = new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(toggleButton.isSelected()) {
				// Unselected -> Selected
				// Light -> Dark
				System.out.println("Dark!");
				mainFrame.getContentPane().setBackground(Color.BLACK);
				toggleButton.setForeground(Color.BLACK);
				toggleButton.setText("救出小黑屋");
				hostio.writeHosts(true);
			} else {
				// Selected -> Unselected
				// Dark -> Light
				System.out.println("Light~");
				mainFrame.getContentPane().setBackground(Color.WHITE);
				toggleButton.setForeground(Color.WHITE);
				toggleButton.setText("关进小黑屋");
				hostio.writeHosts(false);
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
