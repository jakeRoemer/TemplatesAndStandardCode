package chessForTwo;

public class Rook extends Piece {

	public Rook(boolean color, int identifier) {
		super("Rook" + identifier, "R", color, identifier);
		startingPosition();
	}
	
	@Override
	public boolean move(int newFile, int newRank) {
		return false;
	}

	@Override
	public void startingPosition() {
		if (color) {
			setRank(1);
		} else {
			setRank(8);
		}
		if (id == 1) {
			setFile(1);
		} else {
			setFile(8);
		}
	}
}
