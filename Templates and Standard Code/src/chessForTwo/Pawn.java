package chessForTwo;

public class Pawn extends Piece {
	
	public Pawn(boolean color, int identifier) {
		super("Pawn" + identifier, "P", color, identifier);
	}
	
	@Override
	public boolean move(int newFile, int newRank) {
		if (rank + 1 != newRank) {
			System.out.println("Can not move piece there");
		}
		if (realSquare(newFile, newRank)) {
			file = newFile;
			rank = newRank;
			return true; //must change pieces on board as well					
		}
		return true;
	}
	
	@Override
	public void startingPosition() {
		if (color) {
			rank = 1;
		} else {
			rank = 8;
		}
		file = id;
	}
}
