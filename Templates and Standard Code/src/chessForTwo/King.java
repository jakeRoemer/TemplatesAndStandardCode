package chessForTwo;

public class King extends Piece {

	public King (boolean color) {
		super("King", "K", color);
		startingPosition();
	}
	
	@Override
	public boolean move (int newFile, int newRank) {
		if (getFile() == newFile && getRank() == newRank) {
			System.out.println("Can not move piece there");
			return false;
		}
		if (Math.abs(newFile - getFile()) <= 1) {
			if (Math.abs(newRank - getRank()) <= 1) {
				if (realSquare(newFile, newRank)) {
					setFile(newFile);
					setRank(newRank);
					return true; //must change pieces on board as well					
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
