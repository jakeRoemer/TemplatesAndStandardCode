package chessForTwo;

import java.util.LinkedList;

public class Player {

	private boolean turn = false;
	public String name;
	public boolean winner = false;
	public LinkedList<Piece> playerPieces;
	
	public Player(String name) {
		this.name = name;
		playerPieces = new LinkedList<Piece>();
		grabPieces();
	}
	
	public void grabPieces() {
		playerPieces.add(new King());
		playerPieces.add(new Queen());
		for (int i = 0; i < 2; i++) {
			playerPieces.add(new Rook(i));
			playerPieces.add(new Knight(i));
			playerPieces.add(new Bishop(i));
		}
		for (int i = 0; i < 8; i++) {
			playerPieces.add(new Pawn(i));
		}
	}
}
