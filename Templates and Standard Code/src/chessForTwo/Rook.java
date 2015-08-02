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
		if (color) {
			rank = 1;
		} else {
			rank = 8;
		}
		if (id == 1) {
			file = 1;
		} else {
			file = 8;
		}
	}
}
