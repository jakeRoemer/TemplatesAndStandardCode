package chessForTwo;

public class Bishop extends Piece {

	public Bishop(boolean color, int identifier) {
		super("Bishop" + identifier, "B", color, identifier);
	}

	@Override
	public boolean move(int newFile, int newRank) {
		if ((Math.abs(rank - newRank) == Math.abs(file - newFile))) {
			if (realSquare(newFile, newRank)) {
				file = newFile;
				rank = newRank;
				return true; // must change pieces on board as well
			}
		}
		System.out.println("Can not move piece there");
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
			file = 3;
		} else {
			file = 6;
		}
	}
}
