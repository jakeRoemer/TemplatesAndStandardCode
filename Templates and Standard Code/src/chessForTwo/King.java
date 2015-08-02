package chessForTwo;

public class King extends Piece {

	public King(boolean color) {
		super("King", color ? "K" : "k", color);
		startingPosition();
	}

	@Override
	public boolean move(int newFile, int newRank) {
		if (getFile() == newFile && getRank() == newRank) {
			System.out.println("Can not move piece there");
			return false;
		}
		if (Math.abs(newFile - getFile()) <= 1) {
			if (Math.abs(newRank - getRank()) <= 1) {
				if (validMove(newFile, newRank)) {
					updatePosition(this, newFile, newRank);
					return true;
				}
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
		setFile(5);
	}
}
