package chessForTwo;

public class Queen extends Piece {

	public Queen(boolean color) {
		super("Queen", "Q", color);
		startingPosition();
	}

	@Override
	public boolean move (int newFile, int newRank) { 
//		int diffY = Math.abs(newY-y);
//		int x = position/10;
//		int newX = position/10;
//		int diffX = Math.abs(newX-x);
//		if (y == newY && x == newX) {
//			System.out.println("Can not move piece there");
//		} else if (diffY == diffX) {
//			if (realSquare(newPosition)) {
//				position = newPosition;
//				return true; //must change pieces on board as well					
//			} else {
//				System.out.println("Can not move piece there");
//			}
//		} else if (true) {
//			
//		}
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
