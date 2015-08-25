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
	public void checkWinner(Player opponent) { //checking if after a move is made, you checkmate the opponent
		//Must check if king is in check and if all surrounding available squares are in check
		//Therefore, each square surrounding the king and the square the king exists on itself is checked for capturability and existence
		Piece king = opponent.playerPieces.get(0);
		boolean freeSpace;
		boolean winCondition = true;
		//check all squares surrounding opponent's king for conquerability
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				//check if square is on board
				if (king.isOnBoard(king.getFile()+i,king.getRank()+j)) {
					freeSpace = true; //assume space is free
					for (Piece p : playerPieces) {
						if (p.isAlive()) {
							king.checkMove = true;
							//check if opponent can capture your piece and not be in check
							if (p.getFile() == king.getFile()+i && p.getRank() == king.getRank()+j && king.move(king.getFile()+i, king.getRank()+j)) {
								winCondition = false;
								king.checkMove = false;
								break; //king can capture a piece and escape check so checkmate couldn't happen
							}
							p.checkMove = true;
							//check if a piece is able to capture a square on or around the king
							if (p.move(king.getFile()+i, king.getRank()+j)) {
								for (Piece opponentPiece : opponent.playerPieces) {
									opponentPiece.checkMove = true;
									if (opponentPiece.move(king.getFile()+i, king.getRank()+j)) {
										winCondition = false;
										opponentPiece.checkMove = false;
										break; //a piece can stop the king from being in check so checkmate couldn't happen
										//if a piece can move to a conquerable square and the king is not in check after then the king can not be in checkmate
									}
									opponentPiece.checkMove = false;
								}
								freeSpace = false;
								
							}
							p.checkMove = false;
						}
					}
					//space is not conqurable by a piece, but could still be occupied by a friendly piece
					if (freeSpace) {
						winCondition = false;
						for (Piece opponentPiece : opponent.playerPieces) {
							if (!opponentPiece.name.equals("King") && opponentPiece.getFile() == king.getFile()+i && opponentPiece.getRank() == king.getRank()+j) {
								winCondition = true; //if a square is not conquerable, but a player piece occupies it then it is not free for the king to move to
								//therefore, nothing can be said since the space is not free
								//so even if no piece can move there the king is also not free to move there and no other piece can capture that piece
							}
						}
						//it is true that the square is actually free
						if (!winCondition) {
							break; //a space exists that the king could escape to so checkmate couldn't happen
						}
					}
				}
			}
		}
		if (winCondition) {
			opponent.winner = true;
		}
	}
}