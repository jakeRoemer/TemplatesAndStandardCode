package chessForTwo;

public class Bishop extends Piece{

	public Bishop(boolean color, int identifier) {
		super("Bishop" + identifier , "B", color, identifier);
	}
	
	@Override
	public boolean move (int newFile, int newRank) {
		return false;
	}
	
	@Override
	public void startingPosition() {
//		if (color) { 
//			position = 10;
//		} else {
//			position = 80;
//		}
//		if (id == 1) {
//			position += 3;
//		} else {
//			position += 6;
//		}
	}
}
