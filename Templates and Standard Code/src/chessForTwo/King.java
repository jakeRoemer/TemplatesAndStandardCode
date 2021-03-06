package chessForTwo;

public class King extends Piece {

	public King(boolean color) {
		super("King", color ? "K" : "k", color);
		startingPosition();
	}

	@Override
	public boolean move(int newFile, int newRank) {
		if (getFile() == newFile && getRank() == newRank) {
			return false;
		}
		if (Math.abs(newFile - getFile()) <= 1) {
			if (Math.abs(newRank - getRank()) <= 1) {
				if (validMove(newFile, newRank)) {
					updatePosition(newFile, newRank);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void startingPosition() {
		if (color) {
			setRank(1-1); //-1 due to index
		} else {
			setRank(8-1);
		}
		setFile(5-1);
	}
}