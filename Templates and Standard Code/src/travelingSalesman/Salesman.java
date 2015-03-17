package travelingSalesman;

//Traveling Salesman: Dynamic Algorithm Approach
//Given an undirected, complete weighted graph G find the length of the shortest Hamiltonian cycle of G
//Author: Jake Roemer
//Email: roemer.37@osu.edu

import java.io.File;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Salesman {
	//path example -> {2,3,4} set containing the nodes 2, 3, and 4. A path between them exists
	int pathLength; //keeps track of length of the path leading to this node
	
	//example -> 2,{3,4}, 2 is a single node which the path connecting nodes 3 and 4 lead to
	int frontierVertex; //single node which the path leads to
	
	//all possible useful subsets
	//ex. {1},{2},{3},{4},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4},{1,2,3},ect.
	public static LinkedHashSet<LinkedHashSet<Integer>> subSets;

	//Adjacency list of edges between nodes in the graph.
	//Since the graph is undirected the matrix of edges is symmetric.
	//So only n(n-1)/2 elements of the matrix are useful.
	//Therefore I used an adjacency list to save on size.
	public static LinkedList<Integer> [] edges;
	
	//Mapping of paths for each node
	//Maps path to path data [ie. length of path, node path is leading to]
	public HashMap<LinkedHashSet<Integer>, Salesman> path;

	//For specifying paths vertices are part of 
	public Salesman(int vertices) {
		path = new HashMap<LinkedHashSet<Integer>, Salesman>();
	}

	//For specifying path data
	public Salesman(int pathLength, int frontierVertex) {
		this.pathLength = pathLength;
		this.frontierVertex = frontierVertex;
	}

	public static void main(String[] args) {
		try {
			//Open file and scan for adjacency representation
			File file = new File("input.txt");
			Scanner in = new Scanner(file);
			int vertices = in.nextInt();
			edges = new LinkedList[vertices];
			Salesman[] graph = new Salesman[vertices];
			for (int i = 0; i < vertices; i++) {
				graph[i] = new Salesman(vertices);
				edges[i] = new LinkedList<Integer>();
				for (int j = 0; j < vertices; j++) {
					if(j > i) {
						edges[i].add(in.nextInt());
					} else {
						in.nextInt();
					}
				}
			}
			in.close();
			//generate all possible useful subsets
			generateSubSets(graph);
			//search for optimal tour
			DynamicTS(graph);
			//print permutation of tour and lenght of optimal tour
			PrintWriter out = new PrintWriter("output.txt");
			LinkedHashSet<Integer> Set = new LinkedHashSet<Integer>();
			for (int i = 1; i < vertices; i++) {
				Set.add(i);
			}
			out.print(1 + " "); /* changed */
			getCycle(out, Set, 0, graph);
			out.println();
			out.print(graph[0].pathLength);
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
	}

	//DynamicTS(Salesman[] graph)
	//INPUT: Salesman[] graph -> undirected, complete weighted graph. Keeps track of paths for each node
	//OUTPUT: length of shortest Hamiltonian cycle of G is computed
	public static void DynamicTS(Salesman[] graph) {
		//initialize path between nodes and starting node 0
		int n = graph.length;
		for (int i = 1; i < n; i++) {
			graph[i].path.put(new LinkedHashSet<Integer>(), new Salesman(edges[0].get(i-1), -1));
		}
		//for each v in V
		for (int i = 1; i < n; i++) {
			//set of paths that will be removed from total set of paths after exploration.
			//Reduces time to search through all possible paths for paths of length i
			LinkedList<LinkedHashSet<Integer>> deleteSet = new LinkedList<LinkedHashSet<Integer>>();
			//for each W subset equal V - {s} where {s} is 0
			for (Iterator<LinkedHashSet<Integer>> j = subSets.iterator(); j.hasNext();) {
				LinkedHashSet<Integer> Set = j.next();
				//such that |W| = i [W is the correct size]
				while (Set.size() != i && j.hasNext()) {
					Set = j.next();
				}
				for (int k = 1; k < n; k++) {
					//for each v in V - W
					if (!Set.contains(k)) {
						int subsetLength = Integer.MAX_VALUE;
						int minVal = 0;
						//for each v_i in W
						for (Iterator<Integer> z = Set.iterator(); z.hasNext();) {
							Integer val = z.next();
							//W - {v_i}
							LinkedHashSet<Integer> tmp = (LinkedHashSet<Integer>) Set.clone();
							tmp.remove(val);
							//min {dist(v,v_i) + length(v_i, W - {v_i})}
							if (k != val && (graph[val].path.get(tmp).pathLength + (k < val ? edges[k].get(val-k-1) : edges[val].get(k-val-1))) < subsetLength) {
								subsetLength = graph[val].path.get(tmp).pathLength + (k < val ? edges[k].get(val-k-1) : edges[val].get(k-val-1));
								minVal = val;
							}
						}
						//length(v,W) <- min{}
						graph[k].path.put(Set, new Salesman(subsetLength,minVal));
					}
				}
				deleteSet.add(Set);
			}
			//Removal of paths to reduces time to search through all possible paths for paths of length i
			for (Iterator<LinkedHashSet<Integer>> it = deleteSet.iterator(); it.hasNext();) {
				LinkedHashSet<Integer> deleteNode = it.next();
				subSets.remove(deleteNode);
			}
		}
		//V-{s}
		LinkedHashSet<Integer> Set = new LinkedHashSet<Integer>();
		for (int i = 1; i < n; i++) {
			Set.add(i);
		}
		int subsetLength = Integer.MAX_VALUE;
		int minVal = 0;
		for (int i = 1; i < n; i++) {
			for (Iterator<Integer> z = Set.iterator(); z.hasNext();) {
				Integer val = z.next();
				LinkedHashSet<Integer> tmp = (LinkedHashSet<Integer>) Set.clone();
				tmp.remove(val);
				if ((graph[val].path.get(tmp).pathLength + edges[0].get(val-1)) < subsetLength) {
					subsetLength = graph[val].path.get(tmp).pathLength + edges[0].get(val-1);
					minVal = val;
				}
			}
		}
		//length(s,V-{s})
		graph[0].pathLength = subsetLength; // cheating, kind of, to print with less hassle
		graph[0].path.put(Set, new Salesman(subsetLength, minVal));
	}

	//generateSubSets(Salesman[] graph)
	//INPUT: Salesman[] graph -> undirected, complete weighted graph. Keeps track of paths for each node
	//OUTPUT: all possible useful subsets are generated
	public static void generateSubSets(Salesman[] graph) {
		if (subSets == null) {
			subSets = new LinkedHashSet<LinkedHashSet<Integer>>();
		}
		//number of subsets, 2^n where n is the number of nodes in the graph
		int n = 1;
		for (int i = 0; i < graph.length; i++) {
			n <<= 1;
		}
		//generation of useful subsets
		//Uses bit indices of an incrementing number to generate subsets
		//value: 1 has bit placing: 1 giving set: {1}
		//value: 2 has bit placing: 1 0 giving set: {2}
		//value: 3 has bit placing: 1 1 giving set: {1 2}
		//value: 4 has bit placing: 1 0 0 giving set: {3} and so on
		for (int i = 1; i < n; i++) {
			BitSet bs = BitSet.valueOf(new long[] { i });
			LinkedHashSet<Integer> temp = new LinkedHashSet<Integer>();
			for (int j = bs.nextSetBit(0); j >= 0; j = bs.nextSetBit(j + 1)) {
				if (j == 0) {
					break;
				} else {
					temp.add(j);
				}
			}
			subSets.add(temp);
		}
	}

	//getCycle(PrintWriter out, LinkedHashSet<Integer> Set, int vertex, Salesman[] graph)
	//INPUT: PrinterWriter out -> port to output file. LinkedHashSet<Integer> Set -> initially the set contains all
	//	nodes and will trace the frontierVertex backward to yield the permutation of the optimal tour. int vertex -> current
	//	frontierVertex which starts with starting node 0. Salesman[] graph -> Salesman[] graph -> undirected, complete 
	//	weighted graph. Keeps track of paths for each node
	//OUTPUT: prints the permutation of the optimal tour to the output file
	public static void getCycle(PrintWriter out, LinkedHashSet<Integer> Set, int vertex, Salesman[] graph) {
		if (Set.isEmpty() || vertex == -1) {
			out.println();
		} else {
			int node = graph[vertex].path.get(Set).frontierVertex;
			if (node != -1) {
				out.print((node + 1) + " "); /* changed */
			}
			Set.remove(node);
			getCycle(out, Set, node, graph);
		}
	}
}