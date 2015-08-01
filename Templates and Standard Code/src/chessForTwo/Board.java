package chessForTwo;

public class Board {
	
	int sizeOfBoard = 8; //8x8 board. Stick to an 8x8 board. If expanded -> Do 3D chess.
	String [][] piecesOnBoard = new String[sizeOfBoard][sizeOfBoard];
	
	public Board(Player p1, Player p2) {
		createBoard(p1, p2);
		displayBoard();
	}
	
	public void createBoard(Player p1, Player p2) { //put pieces on the board
		for (int i = 0; i < sizeOfBoard; i++) {
			for (int j = 0; j < sizeOfBoard; j++) {
				piecesOnBoard[i][j] = "";
			}
		}
		for (Piece p : p1.playerPieces) {
			piecesOnBoard[p.file-1][p.rank-1] = p.boardName;
		}
		for (Piece p : p2.playerPieces) {
			piecesOnBoard[p.file-1][p.rank-1] = p.boardName;
		}
	}
	
	public void displayBoard() {
		for (int i = 0; i < sizeOfBoard; i++) { //top of board
			System.out.print(" _");
		}
		System.out.println();
		for (int i = 0; i < sizeOfBoard; i++) {
			for (int j = 0; j < sizeOfBoard; j++) {
				if (!piecesOnBoard[i][j].equals("")) {
					System.out.print("|" + piecesOnBoard[i][j]);
				} else {
					System.out.print("|_");
				}
			}
			System.out.println("|");
		}
	}
	
	public void play() {
		
	}
}
