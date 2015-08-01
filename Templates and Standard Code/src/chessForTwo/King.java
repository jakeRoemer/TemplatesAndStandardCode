package chessForTwo;

public class King extends Piece {

	public King (boolean color) {
		super("King", "K", color);
		startingPosition();
	}
	
	@Override
	public boolean move (int newFile, int newRank) {
		if (rank + 1 == newRank || rank - 1 == newRank || rank == newRank) {
			if (file == newFile && rank == newRank){
				System.out.println("Can not move piece there");
			} else if (file + 1 == newFile || file - 1 == newFile || file == newFile) {
				if (realSquare(newFile, newRank)) {
					file = newFile;
					rank = newRank;
					return true; //must change pieces on board as well					
				} else {
					System.out.println("Can not move piece there");
				}
			} else {
				System.out.println("Can not move piece there");
			}
		} else {
			System.out.println("Can not move piece there");
		}
		return false;
	}

	@Override
	public void startingPosition() {
		if (color) {
			rank = 1;
		} else {
			rank = 8;
		}
		file = 5;
	}
}
