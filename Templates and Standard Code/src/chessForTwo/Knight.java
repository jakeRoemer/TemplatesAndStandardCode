package chessForTwo;

public class Knight extends Piece {

	public Knight(boolean color, int identifier) {
		super("Knight" + identifier, color ? "N" : "n", color, identifier);
		startingPosition();
	}

	@Override
	public boolean move(int newFile, int newRank) {
		// Knight can move 2 rank if file moves 1, and can move 1 rank if file
		// moves 2
		if (getFile() == newFile && getRank() == newRank) {
			return false;
		}
		if ((Math.abs(getRank() - newRank) == 1 && Math.abs(getFile() - newFile) == 2)
				|| (Math.abs(getRank() - newRank) == 2 && Math.abs(getFile() - newFile) == 1)) {
			if (validMove(newFile, newRank)) {
				updatePosition(newFile, newRank);
				return true; // must change pieces on board as well
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
		if (id == 1) {
			setFile(2-1);
		} else {
			setFile(7-1);
		}
	}
}
