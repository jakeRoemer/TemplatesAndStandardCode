package chessForTwo;

public abstract class Piece {
	
	public String name;
	public String boardName;
	protected boolean color; //can be black or white
	private boolean alive = true;
	public int file; //x
	public int rank; //y
	public int id;
	//position is specified by first digit corresponding to vertical side of the board
	//and the second digit corresponding to the horizontal side of the board
	//Since the board is only 8x8, the position digits can only range from 1 to 8 (or 0 to 7)
	
	/** Creates King or Queen since only one exist on a player's side. */
	public Piece (String name, String boardName, boolean color) {
		this.name = name;
		this.boardName = boardName;
		this.color = color;
	}

	/** Creates one of multiple pieces that exist on a player's side. */
	public Piece (String name, String boardName, boolean color, int identifier) {
		this.name = name;
		this.boardName = boardName;
		this.color = color;
		id = identifier; 
	}
	
	/** Determines if this placement is possible. Will move the piece to this new position if possible.
	 * A move is possible if the piece is allowed to move to that square, if the square exists on the board,
	 *  and the square is not occupied */
	public abstract boolean move (int newFile, int newRank);

	/** Starting position for a piece based on owner (white/black) and id (for multiple of the same piece) */
	public abstract void startingPosition();
	
	/** Helper function to determine if a square exists and is not already occupied.
	 * Best to check for real square after checking if a move is possible.
	 * Can also be used as a check for capturing a piece. */
	public boolean realSquare (int file, int rank) {
		return true;
	}
	
	/** Will update position of a piece on the board once it has moved */
	public void updatePosition (Piece p, int newFile, int newRank) {
		Board.piecesOnBoard[p.rank-1][p.file-1] = "";
		p.setRank(newRank);
		p.setFile(newFile);
		Board.piecesOnBoard[p.rank-1][p.file-1] = p.boardName;
	}
	
	/** Returns the state of the piece. Can be used to tally standing points. */
	public boolean isAlive () {
		return alive;
	}
	
	public void setAlive (boolean state) {
		alive = state;
	}
	
	public void setFile (int newFile) {
		file = newFile;
	}
	
	public int getFile () {
		return file;
	}
	
	public void setRank (int newRank) {
		rank = newRank;
	}
	
	public int getRank () {
		return rank;
	}
}
