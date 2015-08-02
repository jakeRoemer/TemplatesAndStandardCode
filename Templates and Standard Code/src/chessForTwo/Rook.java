package chessForTwo;

public class Rook extends Piece {

	public Rook(boolean color, int identifier) {
		super("Rook" + identifier, "R", color, identifier);
	}

	@Override
	public boolean move(int newFile, int newRank) {
		if ((Math.abs(rank - newRank) > 0 && Math.abs(file - newFile) == 0)
				|| (Math.abs(rank - newRank) == 0 && Math.abs(file - newFile) > 0)) {
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
			file = 1;
		} else {
			file = 8;
		}
	}
}
