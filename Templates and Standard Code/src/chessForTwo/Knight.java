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
		if (color) {
			rank = 1;
		} else {
			rank = 8;
		}
		if (id == 1) {
			file = 2;
		} else {
			file = 7;
		}
	}
}
