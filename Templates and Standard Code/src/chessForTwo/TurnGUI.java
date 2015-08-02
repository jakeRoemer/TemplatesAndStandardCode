package chessForTwo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TurnGUI extends JFrame {
	
	public TurnGUI() {
		JFrame playingField = new JFrame();
		playingField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playingField.setTitle("Chess");
		playingField.setSize(300,300);
		playingField.setLocationRelativeTo(null);
		JButton [] squares = new JButton[8*8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i*8+j] = new JButton(i+" "+j);
				squares[i*8+j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						//switch player and relay information from button press
						System.out.println("Button pushed");
						setVisible(true);
					}
				});
				playingField.add(squares[i*8+j]);
			}
		}
		playingField.setVisible(true);
	}
}
