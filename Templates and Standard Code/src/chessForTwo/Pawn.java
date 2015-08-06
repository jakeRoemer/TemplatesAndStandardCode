package chessForTwo;

public class Pawn extends Piece {

	public Boolean enPassant = false;

	public Pawn(boolean color, int identifier) {
		super("Pawn" + identifier, color ? "P" : "p", color, identifier);
		startingPosition();
	}

	@Override
	public boolean move(int newFile, int newRank) {
		if (color /* white */ && Math.abs(getFile() - newFile) == 0 && (validMove(newFile, newRank))) {
			if (newRank == getRank() + 1 || (newRank == getRank() + 2 && getRank() == 2)) {
				if (newRank == getRank() + 2) {
					enPassant = true;
				}
				updatePosition(this, newFile, newRank);
				return true;
			}
		} else if (Math.abs(getFile() - newFile) == 0 && (validMove(newFile, newRank))) {
			if (newRank == getRank() - 1 || (newRank == getRank() - 2 && getRank() == 7)) {
				if (newRank == getRank() - 2) {
					enPassant = true;
				}
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
			setRank(2);
		} else {
			setRank(7);
		}
		setFile(id);
	}
}