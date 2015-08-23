package chessForTwo;

public class Bishop extends Piece {

	public Bishop(boolean color, int identifier) {
		super("Bishop" + identifier, color ? "B" : "b", color, identifier);
		startingPosition();
	}

	@Override
	public boolean move(int newFile, int newRank) {
		if (getFile() == newFile && getRank() == newRank) {
			return false;
		}
		if ((Math.abs(getRank() - newRank) == Math.abs(getFile() - newFile))) {
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
			setFile(3-1);
		} else {
			setFile(6-1);
		}
	}
}
