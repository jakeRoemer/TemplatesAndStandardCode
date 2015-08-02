package chessForTwo;

public class Bishop extends Piece {

	public Bishop(boolean color, int identifier) {
		super("Bishop" + identifier, "B", color, identifier);
		startingPosition();
	}

	@Override
	public boolean move(int newFile, int newRank) {
		if ((Math.abs(getRank() - newRank) == Math.abs(getFile() - newFile))) {
			if (realSquare(newFile, newRank)) {
				updatePosition(this, newFile, newRank);
				return true;
			}
		}
		System.out.println("Can not move piece there");
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
			setFile(3);
		} else {
			setFile(6);
		}
	}
}
