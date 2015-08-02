package chessForTwo;

public class Board {
	
	static int sizeOfBoard = 8; //8x8 board. Stick to an 8x8 board. If expanded -> Do 3D chess.
	static Piece [][] piecesOnBoard = new Piece[sizeOfBoard][sizeOfBoard];
	
	public Board(Player p1, Player p2) {
		createBoard(p1, p2);
		displayBoard();
	}
	
	public void createBoard(Player p1, Player p2) { //put pieces on the board
		for (int i = 0; i < sizeOfBoard; i++) {
			for (int j = 0; j < sizeOfBoard; j++) {
				piecesOnBoard[i][j] = null;
			}
		}
		for (Piece p : p1.playerPieces) {
			piecesOnBoard[p.getRank()-1][p.getFile()-1] = p;
		}
		for (Piece p : p2.playerPieces) {
			piecesOnBoard[p.getRank()-1][p.getFile()-1] = p;
		}
	}
	
	public static void displayBoard() {
		for (int i = 0; i < sizeOfBoard; i++) { //top of board
			System.out.print(" _");
		}
		System.out.println();
		for (int i = 0; i < sizeOfBoard; i++) {
			for (int j = 0; j < sizeOfBoard; j++) {
				if (piecesOnBoard[i][j] != null) {
					System.out.print("|" + piecesOnBoard[i][j].boardName);
				} else {
					System.out.print("|_");
				}
			}
			System.out.println("|");
		}
	}
	
	public static void play(Player p1, Player p2) {
		if (p1.turn) {
			p1.playerPieces.getLast().move(p1.playerPieces.getLast().file, p1.playerPieces.getLast().rank+1);
			p1.winner = true;
			p2.turn = true;
			p1.turn = false;
			displayBoard();
		} else {
			p1.turn = true;
			p2.turn = false;
		}
	}
}
