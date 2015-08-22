package chessForTwo;

public class Rook extends Piece {

	public Rook(boolean color, int identifier) {
		super("Rook" + identifier, color ? "R" : "r", color, identifier);
		startingPosition();
	}

	@Override
	public boolean move(int newFile, int newRank) {
		if ((Math.abs(getRank() - newRank) > 0 && Math.abs(getFile() - newFile) == 0)
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
		if (id == 1) {
			setFile(1-1);
		} else {
			setFile(8-1);
		}
	}
}