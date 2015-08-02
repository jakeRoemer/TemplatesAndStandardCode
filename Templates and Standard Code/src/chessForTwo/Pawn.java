package chessForTwo;

public class Pawn extends Piece {
	
	public Pawn(boolean color, int identifier) {
		super("Pawn" + identifier, "P", color, identifier);
		startingPosition();
	}
	
	@Override
	public boolean move(int newFile, int newRank) {
		if (getRank() + 1 != newRank) {
			System.out.println("Can not move piece there");
		}
		if (realSquare(newFile, newRank)) {
			setFile(newFile);
			setRank(newRank);
			return true; //must change pieces on board as well					
		}
		return true;
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
