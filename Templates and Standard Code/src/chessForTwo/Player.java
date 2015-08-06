package chessForTwo;

import java.util.LinkedList;

public class Player {

	public boolean turn = false;
	public boolean color; //white or black
	public boolean winner = false;
	public int turnCount = 0;
	public long timer = 0;
	public LinkedList<Piece> playerPieces;
	
	public Player(boolean color) {
		this.color = color;
		if (color) { //white goes first
			turn = true;
		}
		playerPieces = new LinkedList<Piece>();
		grabPieces(color);
	}
	
	public void grabPieces(boolean name) {
		playerPieces.add(new King(name));
		playerPieces.add(new Queen(name));
		for (int i = 1; i <= 2; i++) {
			playerPieces.add(new Rook(name,i));
			playerPieces.add(new Knight(name,i));
			playerPieces.add(new Bishop(name,i));
		}
		for (int i = 1; i <= 8; i++) {
			playerPieces.add(new Pawn(name,i));
		}
	}
}
