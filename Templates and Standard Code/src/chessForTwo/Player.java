package chessForTwo;

import java.util.LinkedList;

public class Player {

	private boolean turn = false;
	public boolean color; //white or black
	public boolean winner = false;
	public LinkedList<Piece> playerPieces;
	
	public Player(boolean color) {
		this.color = color;
		playerPieces = new LinkedList<Piece>();
		grabPieces(color);
	}
	
	public void grabPieces(boolean name) {
		playerPieces.add(new King(name));
		playerPieces.add(new Queen(name));
		for (int i = 0; i < 2; i++) {
			playerPieces.add(new Rook(name,i));
			playerPieces.add(new Knight(name,i));
			playerPieces.add(new Bishop(name,i));
		}
		for (int i = 0; i < 8; i++) {
			playerPieces.add(new Pawn(name,i));
		}
	}
}
