package chessForTwo;

public class Pawn extends Piece {

	public Boolean enPassant = false;

	public Pawn(boolean color, int identifier) {
		super("Pawn" + identifier, "P", color, identifier);
		startingPosition();
	}

	@Override
	public boolean move(int newFile, int newRank) {
		if (color /* white */ && Math.abs(getFile() - newFile) == 0 && (validMove(newFile, newRank))) {
			if (newRank == getRank() + 1) {
				setFile(newFile);
				setRank(newRank);
				return true; // must change pieces on board as well
			} else if (newRank == getRank() + 2 && getRank() == 2) {
				setFile(newFile);
				setRank(newRank);
				enPassant = true;
				return true; // must change pieces on board as well
			}
		} else if (Math.abs(getFile() - newFile) == 0 && (validMove(newFile, newRank))) {
			if (newRank == getRank() - 1) {
				setFile(newFile);
				setRank(newRank);
				return true; // must change pieces on board as well
			} else if (newRank == getRank() - 2 && getRank() == 7) {
				setFile(newFile);
				setRank(newRank);
				enPassant = true;
				return true; // must change pieces on board as well
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
