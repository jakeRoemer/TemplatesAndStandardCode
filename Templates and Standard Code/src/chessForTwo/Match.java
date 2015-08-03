package chessForTwo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class Match {
	
	public static void main (String [] args) {
		Player p1 = new Player(true); //white
		Player p2 = new Player(false); //black
		Board b = new Board(p1, p2);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TurnGUI();
			}
		});
		while (!p1.winner && !p2.winner) {}
		if (p1.winner) {
			System.out.println("Player 1 is the winner");
		} else {
			System.out.println("Player 2 is the winner");
		}
		updateScoreBoard(p1, p2);
		System.exit(0); //closes gui
	}
	
	public static void updateScoreBoard(Player p1, Player p2) {
		File file = new File("ScoreBoard.txt");
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			Scanner scan = new Scanner(System.in);
			System.out.println("Winner enter name: ");
			out.print(scan.nextLine() + "-> ");
			if (p1.winner) {
				out.print("timer: " + p1.timer + " | ");
				out.print("turns taken: " + p1.turnCount);
			} else {
				out.print("timer: " + p2.timer + " | ");
				out.print("turns taken: " + p2.turnCount);
			}
			out.close();
			scan.close();
		} catch (IOException e) {
			System.out.println("score board can not be opened.");
		}
	}
}
