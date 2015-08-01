package coveringProblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

//implements greedy approximation approach
public class SetCover {
	
	//testing Jake
	public static HashSet<Integer> universalSet;
	public static LinkedList<HashSet<Integer>> subSets;
	public static LinkedList<HashSet<Integer>> completeCover;
	
	public static void main(String [] args) {
		File file = new File("input.txt");
		try {
			Scanner scan = new Scanner(file);
			int numSets = scan.nextInt();
			universalSet = new HashSet<Integer>();
			subSets = new LinkedList<HashSet<Integer>>();
			int setValue;
			HashSet<Integer> tempSet;
			for (int i = 0; i < numSets; i++) {
				tempSet = new HashSet<Integer>();
				setValue = scan.nextInt();
				while (setValue != 0) {
					tempSet.add(setValue);
					universalSet.add(setValue);
				}
				subSets.add(tempSet);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("input could not be opened");
		}
		try {
			PrintWriter out = new PrintWriter("outputSetCover");
			for (int i = 0; i < completeCover.size(); i++) {
				for (Iterator<Integer> j = completeCover.get(i).iterator(); j.hasNext();) {
					out.print(j.next() + " ");
				}
				out.println();
			}
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("output could not be opened");
		}
	}
	
	public void greedyApprox() {
		completeCover = new LinkedList<HashSet<Integer>>();
		while (!universalSet.isEmpty()) {
			//select S in F that maximizes S intersect U
			//remove selected S [defaulted to 0 for now]
			universalSet.removeAll(subSets.get(0));
			//add selected S [defaulted to 0 for now]
			completeCover.add(subSets.get(0));
		}
	}
}