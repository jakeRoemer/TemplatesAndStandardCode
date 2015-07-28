package chessForTwo;

public abstract class Piece {
	
	private String name;
	private String boardName;
	private boolean alive = true;
	public int position; 
	//position is specified by first digit corresponding to vertical side of the board
	//and the second digit corresponding to the horizontal side of the board
	//Since the board is only 8x8, the position digits can only range from 1 to 8 (or 0 to 7)
	//WARNING: If the board becomes larger than 9x9 this method of position will not work
	//You would have to then handle a vertical or horizontal position more than one digit.
	
	public Piece(String name, String boardName) {
		this.name = name;
		this.boardName = boardName;
		//this.position = position; //Not sure yet since the starting position relies on the player
		//and the board has to recognize where to place a piece
		//So using a one dimensional array to store the pieces would lead to a different positioning
		//system compared to a two dimensional array
	}
	
	public abstract void move(); 
	
	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean state) {
		alive = state;
	}
}
