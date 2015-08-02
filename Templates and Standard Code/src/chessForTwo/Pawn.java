package chessForTwo;

public class Pawn extends Piece {
	
	public Pawn(boolean color, int identifier) {
		super("Pawn" + identifier, "P", color, identifier);
		startingPosition();
	}
	
	@Override
	public boolean move(int newFile, int newRank) {
		if (rank + 1 != newRank) {
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
			setRank(1);
		} else {
			setRank(8);
		}
		setFile(id);
	}
}
