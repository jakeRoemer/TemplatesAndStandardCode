package chessForTwo;

public class Pawn extends Piece {

	public boolean enPassant = false; 

	public Pawn(boolean color, int identifier) {
		super("Pawn" + identifier, color ? "P" : "p", color, identifier);
		startingPosition();
	}

	@Override
	public boolean move(int newFile, int newRank) {
		if (getFile() == newFile && getRank() == newRank) {
			return false;
		}
		if (color /* white */ && validMove(newFile, newRank)) {
			if (Math.abs(getFile() - newFile) == 0 || (captureAttempt && Math.abs(getFile() - newFile) == 1)) {
				if (newRank == getRank() + 1 || (newRank == getRank() + 2 && getRank() == (2-1))) {
					if (newRank == getRank() + 2) {
						enPassant = true;
					}
					updatePosition(newFile, newRank);
					captureAttempt = false;
					return true;
				}
			}
		}
		if (!color && validMove(newFile, newRank) && Math.abs(getFile() - newFile) <= 1) {
			if (Math.abs(getFile() - newFile) == 0 || (captureAttempt && Math.abs(getFile() - newFile) == 1)) {
				if (newRank == getRank() - 1 || (newRank == getRank() - 2 && getRank() == (7-1))) {
					if (newRank == getRank() - 2) {
						enPassant = true;
					}
					updatePosition(newFile, newRank);
					captureAttempt = false;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void startingPosition() {
		if (color) {
			setRank(2-1); //-1 due to index
		} else {
			setRank(7-1);
		}
		setFile(id-1);
	}
}