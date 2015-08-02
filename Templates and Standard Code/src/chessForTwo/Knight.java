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
				setFile(newFile);
				setRank(newRank);
				return true; // must change pieces on board as well
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
			setFile(2);
		} else {
			setFile(7);
		}
	}
}
