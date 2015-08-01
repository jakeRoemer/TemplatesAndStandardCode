package chessForTwo;

public class Pawn extends Piece {
	
	public Pawn(boolean color, int identifier) {
		super("Pawn" + identifier, "P", color, identifier);
	}
	
	@Override
	public boolean move(int newFile, int newRank) {
		return false;
	}
	
	@Override
	public void startingPosition() {
//		if (color) {
//			position = 10;
//		} else {
//			position = 80;
//		}
//		position += id;
	}
}
