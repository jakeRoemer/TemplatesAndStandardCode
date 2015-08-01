package chessForTwo;

public class Match {
	public static void main (String [] args) {
		Player p1 = new Player(true); //white
		Player p2 = new Player(false); //black
		Board b = new Board(p1, p2);
		while (!p1.winner && !p2.winner) {
			b.play();
		}
		if (p1.winner) {
			System.out.println("Player 1 is the winner");
		} else {
			System.out.println("Player 2 is the winner");
		}
	}
}
