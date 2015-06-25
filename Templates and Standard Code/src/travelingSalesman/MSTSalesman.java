package travelingSalesman;

import graphAlgorithms.DepthFirstSearch;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import minSpanTree.MST;

public class MSTSalesman {
	
	//Adjacency list of edges between nodes in the graph.
	//Since the graph is undirected the matrix of edges is symmetric.
	//So only n(n-1)/2 elements of the matrix are useful.
	//Therefore I used an adjacency list to save on size.
	public static LinkedList<Integer> [] edges;
	
	public static void main(String [] args) {
		File file = new File("input.txt");
		try {
			Scanner scan = new Scanner(file);
			int vertices = scan.nextInt();
			edges = new LinkedList[vertices];
			for (int i = 0; i < vertices; i++) {
				edges[i] = new LinkedList<Integer>();
				for (int j = 0; j < vertices; j++) {
					if (j > i) { //undirected graph, only [n*(n-1)]/2 are unique
						edges[i].add(scan.nextInt());
					} else { //the rest are thrown away
						scan.nextInt();
					}
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("input could not be opened");
		}
		MST.MST_Prim(edges,edges[0]);
		//add preorder node tracking. Figure out what to do about types
		//DFS uses node class, mstsalesman uses linkedlist []
		//DepthFirstSearch.DFS(edges);
		try {
			PrintWriter out = new PrintWriter("outputMSTSalesman.txt");
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("output could not be opened");
		}
	}
}
