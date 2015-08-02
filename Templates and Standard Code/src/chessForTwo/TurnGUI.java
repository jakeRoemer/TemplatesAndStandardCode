package chessForTwo;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TurnGUI {
	
	public TurnGUI() {
		JFrame playingField = new JFrame();
		playingField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playingField.setTitle("Chess");
		playingField.setSize(300,300);
		playingField.setLocationRelativeTo(null);
		JButton [] squares = new JButton[8*8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i*8+j];
			}
		}
	}
}
