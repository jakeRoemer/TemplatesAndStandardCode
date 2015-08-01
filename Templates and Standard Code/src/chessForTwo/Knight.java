package chessForTwo;

public class Knight extends Piece {

	public Knight(boolean color, int identifier) {
		super("Knight" + identifier, "Kn", color, identifier);
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
//			position += 2;
//		} else {
//			position += 7;
//		}
	}
}
