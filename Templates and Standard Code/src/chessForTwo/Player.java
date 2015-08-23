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
	
	/** Determine winner here. If the piece that is about to be captured is a king then it is possible that a player is going to win.
	 * Must check that every position the king can be in is a position that is capturable by the opposing player
	 * Must check the piece that is attempting to take the king isn't capturable or that is the only available move next turn
	 * TODO: handle restricting movements based on possibility of check or such
	 * */
	public void checkWinner(Player opponent) {
		//Must check if king is in check and if all surrounding available squares are in check
		//Therefore, each square surrounding the king and the square the king exists on itself is checked for capturability and existence
		Piece king = playerPieces.get(0);
		boolean freeSpace;
		boolean winCondition = true;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (king.isOnBoard(king.getFile()+i,king.getRank()+j)) {
					freeSpace = true; //assume space is free
					for (Piece p : opponent.playerPieces) {
						if (p.isAlive()) {
							p.checkMove = true;
							if (p.move(king.getFile()+i, king.getRank()+j)) {
								System.out.println("piece: " + p.name);
								freeSpace = false;
							}
							p.checkMove = false;
						}
					}
					if (freeSpace) {
						winCondition = false;
					}
				}
			}
		}
		if (winCondition) {
			opponent.winner = true;
		}
		//Have to make sure that the king can not be saved by another piece sacrificing itself
		//Have to make sure that the king can not capture a piece itself to stop it from being in check
	}
}