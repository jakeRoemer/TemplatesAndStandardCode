package chessForTwo;

public class Queen extends Piece {

	public Queen(boolean color) {
		super("Queen", color ? "Q" : "q", color);
		startingPosition();
	}

	@Override
	public boolean move(int newFile, int newRank) {
		if (getFile() == newFile && getRank() == newRank) {
			System.out.println("Can not move piece there");
			return false;
		}
		if (Math.abs(newFile - getFile()) == Math.abs(newRank - getRank())
				|| (Math.abs(getRank() - newRank) > 0 && Math.abs(getFile() - newFile) == 0)
				|| (Math.abs(getRank() - newRank) == 0 && Math.abs(getFile() - newFile) > 0)) {
			if (validMove(newFile, newRank)) {
				updatePosition(newFile, newRank);
				return true; // must change pieces on board as well
			}
		}
		System.out.println("Can not move piece there");
		return false;
	}

	@Override
	public void startingPosition() {
		if (color) {
			setRank(1-1); //-1 due to index
		} else {
			setRank(8-1);
		}
		setFile(4-1);
	}
}