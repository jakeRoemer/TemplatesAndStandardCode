package chessForTwo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TurnGUI extends JFrame {
	
	public TurnGUI() {
		JFrame playingField = new JFrame();
		playingField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playingField.setTitle("Chess");
		playingField.setSize(490,340);
		playingField.setLocationRelativeTo(null);
		playingField.setContentPane(createPanel());
		playingField.setVisible(true);
	}
	
	public JPanel createPanel() {
		//single panel to place all other panels
		JPanel gui = new JPanel();
		gui.setLayout(null);
		//player panel to display who is playing and score and such
		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(null);
		playerPanel.setLocation(10,0);
		playerPanel.setSize(250, 30);
		gui.add(playerPanel);
		//player label text to display on player panel
		//only one player will be displayed at a time
		JLabel p1 = new JLabel("White");
		p1.setLocation(0,0);
		p1.setSize(250,30);
		p1.setHorizontalAlignment(0);
		p1.setVisible(true);
		JLabel p2 = new JLabel("Black");
		p2.setLocation(0,0);
		p2.setSize(250,30);
		p2.setHorizontalAlignment(0);
		p2.setVisible(false);
		playerPanel.add(p1);
		playerPanel.add(p2);
		//button panel to display board for piece movement
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLocation(10,30);
		buttonPanel.setSize(450,340);
		gui.add(buttonPanel);
		//buttons to add to button panel
		JButton [] squares = new JButton[8*8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i*8+j] = new JButton((i+1)+" "+(j+1));
				squares[i*8+j].setLocation(10*(i*8+j)+1,10*(i*8+j)+1);
				squares[i*8+j].setSize(10,10);
				squares[i*8+j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						//switch player and relay information from button press
						System.out.println("Button pushed");
					}
				});
				buttonPanel.add(squares[i*8+j]);
			}
		}
		return gui;
	}
}
