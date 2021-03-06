package chessForTwo;

public class Board {
	
	static int sizeOfBoard = 8; //8x8 board. Stick to an 8x8 board. If expanded -> Do 3D chess.
	static Piece [][] piecesOnBoard = new Piece[sizeOfBoard][sizeOfBoard];
	public static Player white;
	public static Player black;
	public static Piece playerPiece;
	public static boolean pickingPiece = true;
	
	public Board(Player p1, Player p2) {
		white = p1;
		black = p2;
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
			piecesOnBoard[p.getFile()][p.getRank()] = p;
		}
		for (Piece p : p2.playerPieces) {
			piecesOnBoard[p.getFile()][p.getRank()] = p;
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
	
	public static String play(int newFile, int newRank) {
		if (white.turnStartTime == -1) { //start the timer when the first turn starts
			white.turnStartTime = System.currentTimeMillis();
		}
		if (playerPiece != null) {
			if (!playerPiece.move(newFile, newRank)) {
				playerPiece = null;
				pickingPiece = true;
				return (white.turn ? "White" : "Black") + ": Piece can not move there";
			}
			playerPiece = null;
			pickingPiece = true;
		} else {
			if (white.turn) {
				if (piecesOnBoard[newFile][newRank] != null && piecesOnBoard[newFile][newRank].color) {
					playerPiece = piecesOnBoard[newFile][newRank];
				} else {
					return (white.turn ? "White" : "Black") + ": Piece can not move there";
				}
			} else {
				if (piecesOnBoard[newFile][newRank] != null && !piecesOnBoard[newFile][newRank].color) {
					playerPiece = piecesOnBoard[newFile][newRank];
				} else {
					return (white.turn ? "White" : "Black") + ": Piece can not move there";
				}
			}
			pickingPiece = false;
		}
		if (white.turn && pickingPiece) {
			white.timer = System.currentTimeMillis() - white.turnStartTime;
			white.turn = false;
			black.turn = true;
			white.turnCount++; //white took a turn
			displayBoard(); //white just made a move, check if white wins
			white.checkWinner(black);
			black.turnStartTime = System.currentTimeMillis();
		} else if (black.turn && pickingPiece){
			black.timer = System.currentTimeMillis() - black.turnStartTime;
			white.turn = true;
			black.turn = false;
			black.turnCount++; //black took a turn
			displayBoard(); //black just made a move, check if black wins
			black.checkWinner(white);
			white.turnStartTime = System.currentTimeMillis();
		}
		return (white.turn ? "White" : "Black") + ": Successful";
		//maybe update status of movements, can later be logged
	}
}
