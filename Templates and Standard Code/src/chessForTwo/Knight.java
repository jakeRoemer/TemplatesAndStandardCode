package chessForTwo;

public class Knight extends Piece {

	public Knight(boolean color, int identifier) {
		super("Knight" + identifier, "Kn", color, identifier);
	}

	@Override
	public boolean move(int newFile, int newRank) {
		// Knight can move 2 rank if file moves 1, and can move 1 rank if file
		// moves 2

		if ((Math.abs(rank - newRank) == 1 && Math.abs(file - newFile) == 2)
				|| (Math.abs(rank - newRank) == 2 && Math.abs(file - newFile) == 1)) {
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
			file = 2;
		} else {
			file = 7;
		}
	}
}
