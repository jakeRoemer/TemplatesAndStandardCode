package chessForTwo;

public abstract class Piece {

	public String name;
	public String boardName;
	protected boolean color; // can be black or white
	private boolean alive = true;
	public int file; // x
	public int rank; // y
	public int id;
	public boolean captureAttempt = false;
	// position is specified by first digit corresponding to vertical side of
	// the board
	// and the second digit corresponding to the horizontal side of the board
	// Since the board is only 8x8, the position digits can only range from 1 to
	// 8 (or 0 to 7)

	/** Creates King or Queen since only one exist on a player's side. */
	public Piece(String name, String boardName, boolean color) {
		this.name = name;
		this.boardName = boardName;
		this.color = color;
	}

	/** Creates one of multiple pieces that exist on a player's side. */
	public Piece(String name, String boardName, boolean color, int identifier) {
		this.name = name;
		this.boardName = boardName;
		this.color = color;
		id = identifier;
	}

	/**
	 * Determines if this placement is possible. Will move the piece to this new
	 * position if possible. A move is possible if the piece is allowed to move
	 * to that square, if the square exists on the board, and the square is not
	 * occupied
	 */
	public abstract boolean move(int newFile, int newRank);

	/**
	 * Starting position for a piece based on owner (white/black) and id (for
	 * multiple of the same piece)
	 */
	public abstract void startingPosition();

	/**
	 * Helper function to determine if a square is a valid place to move. It
	 * must be on the board and not already occupied. Best to check for real
	 * square after checking if a move is possible. Can also be used as a check
	 * for capturing a piece.
	 */
	public boolean validMove(int newFile, int newRank) {
		if (isOnBoard(newFile, newRank) && isEmptyPath(newFile, newRank) && isEmptySpace(newFile, newRank)) {
			return true;
		}
		return false;
	}

	public boolean isOnBoard(int newFile, int newRank) {
		if (newRank < 8 && newRank >= 0 && newFile < 8 && newFile >= 0) {
			return true;
		}
		return false;
	}

	public boolean isEmptyPath(int newFile, int newRank) {
		if (Math.abs(newRank - getRank()) == Math.abs(newFile - getFile())) { //diagonals have 4 directions
			// condition met for diagonal movement
			for (int i = 1; i < Math.abs(newFile-getFile())-1; i++) {
				if (Board.piecesOnBoard[(getFile() < newFile) ? getFile()+i : getFile()-i][(getRank() < newRank) ? getRank()+i : getRank()-i] != null) {
					return false;
				}
			}
			return true;
		}
		if (Math.abs(newRank - getRank()) > 0 && Math.abs(newFile - getFile()) == 0) {
			// Condition met if movement in Rank Direction only
			for (int i = 1; i < Math.abs(newRank-getRank())-1; i++) {
				if (Board.piecesOnBoard[getFile()][(getRank() < newRank) ? getRank()+i : getRank()-i] != null) {
					return false;
				}
			}
			return true;
		}
		if (Math.abs(newRank - getRank()) == 0 && Math.abs(newFile - getFile()) > 0) {
			// Condition met if movement in File Direction only
			for (int i = 1; i < Math.abs(newFile-getFile())-1; i++) {
				if (Board.piecesOnBoard[(getFile() < newFile) ? getFile()+i : getFile()-i][getRank()] != null) {
					return false;
				}
			}
			return true;
		}
		for (Piece[] pieces : Board.piecesOnBoard) {
			for (Piece p : pieces) {
				if (p != null && !p.boardName.equals("N")) {

				} else {
					return true;
				}
			}
		}
		return true; //default should be true
	}

	// isCapturable method to determine if the Non-empty space
	// contains an opposing players piece.
	public boolean isEmptySpace(int newFile, int newRank) {
		if (Board.piecesOnBoard[newFile][newRank] == null) {
			return true;
		}
		if (boardName.equals("p") || boardName.equals("P")) {
			if (Math.abs(newFile - getFile()) != Math.abs(newRank - getRank())) {
				return false;
			}
		}
		if (Board.piecesOnBoard[newFile][newRank].color != color) {
			//need to determine winner here. If the piece that is about to be captured is a king then it is possible that a player is going to win.
			//simply remove the piece that was there if it is of the opposing color
			Board.piecesOnBoard[newFile][newRank].alive = false;
			Board.piecesOnBoard[newFile][newRank] = null;
			captureAttempt = true;
			return true;
		} 
		return false;
	}

	/** Will update position of a piece on the board once it has moved */
	public void updatePosition(int newFile, int newRank) {
		Board.piecesOnBoard[getFile()][getRank()] = null;
		setRank(newRank);
		setFile(newFile);
		Board.piecesOnBoard[getFile()][getRank()] = this;
	}

	/** Returns the state of the piece. Can be used to tally standing points. */
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean state) {
		alive = state;
	}

	public void setFile(int newFile) {
		file = newFile;
	}

	public int getFile() {
		return file;
	}

	public void setRank(int newRank) {
		rank = newRank;
	}

	public int getRank() {
		return rank;
	}
}