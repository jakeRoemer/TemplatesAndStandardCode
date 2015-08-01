package chessForTwo;

public class Queen extends Piece {

	public Queen(boolean color) {
		super("Queen", "Q", color);
		startingPosition();
	}

	@Override
	public boolean move (int newFile, int newRank) {
		if (file == newFile && rank == newRank) {
			System.out.println("Can not move piece there");
			return false;
		}
		if (Math.abs(newFile - file) == Math.abs(newRank - rank)) {
			if (realSquare(newFile, newRank)) {
				file = newFile;
				rank = newRank;
				return true; //must change pieces on board as well					
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
		file = 4;
	}
}
