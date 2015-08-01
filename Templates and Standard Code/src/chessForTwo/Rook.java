package chessForTwo;

public class Rook extends Piece {

	public Rook(boolean color, int identifier) {
		super("Rook" + identifier, "R", color, identifier);
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
//		if (id == 1) {
//			position += 1;
//		} else {
//			position += 8;
//		}
	}
}
