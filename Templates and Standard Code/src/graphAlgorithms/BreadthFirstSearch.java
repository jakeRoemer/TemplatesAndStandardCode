/* Author: Jake Roemer */
package graphAlgorithms;

public class BreadthFirstSearch {
	
	public void BFS(Node [] G, Node s){
		for(int i = 0; i < G.length; i++){
			Node l = G[i];
			for(int j = 0; j < l.numEdges; j++){
				l.edges.get(j).distance = -1; //assuming there are no negative edges
				l.edges.get(j).color = "WHITE";
			}
		}
		s.distance = 0;
		s.color = "BLACK";
		Queue<Node> q = new Queue<Node>(s);
		while(!q.isEmpty()){
			Node current = q.pop();
			Node l = G[current.id];
			for(int i = 0; i < l.numEdges; i++){
				if(l.edges.get(i).color.equals("WHITE")){
					q.push(l.edges.get(i));
					l.edges.get(i).distance = current.distance + 1;
					l.edges.get(i).color = "BLACK";
				}
			}
		}
	}
}
