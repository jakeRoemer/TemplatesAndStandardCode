package chessForTwo;

import javax.swing.SwingUtilities;

public class Match {
	public static void main (String [] args) {
		Player p1 = new Player(true); //white
		Player p2 = new Player(false); //black
		Board b = new Board(p1, p2);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TurnGUI();
			}
		});
		while (!p1.winner && !p2.winner) {}
		if (p1.winner) {
			System.out.println("Player 1 is the winner");
		} else {
			System.out.println("Player 2 is the winner");
		}
		System.exit(0); //closes gui
	}
}
