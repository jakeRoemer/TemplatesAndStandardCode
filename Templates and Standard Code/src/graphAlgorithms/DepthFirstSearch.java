package graphAlgorithms;

public class DepthFirstSearch {
	
	public void DFS(Node [] G){
		for(int i = 0; i < G.length; i++) {
			Node l = G[i];
			l.color = "WHITE";
			for(int j = 0; j < l.numEdges; j++) {
				l.edges.get(j).color = "WHITE";
			}
		}
		int time = 0;
		for(int i = 0; i < G.length; i++) {
			if(G[i].color.equals("WHITE")) {
				Visit(G, G[i], time);
			}
		}
	}
	
	public void Visit(Node [] G, Node s, int time) {
		s.color = "GREY";
		s.setTime(time++);
		for(int i = 0; i < s.numEdges; i++) {
			if(s.edges.get(i).color.equals("WHITE")) {
				Visit(G,s.edges.get(i), time);
			}
		}
		s.color = "BLACK";
		s.setTime(time++);
	}
	
	public void nonRecursiveDFS(Node [] G) {
		for(int i = 0; i < G.length; i++) {
			Node l = G[i];
			for(int j = 0; j < l.numEdges; j++) {
				l.edges.get(j).color = "WHITE";
			}
		}
		int time = 0;
		Stack<Node> stack = new Stack<Node>();
		G[0].color = "GREY";
		G[0].setTime(time);
		stack.push(G[0]);
		while(!stack.isEmpty()) {
			Node n = stack.pop();
			n.color = "BLACK";
			n.setTime(time++);
			for(int i = 0; i < n.numEdges; i++) {
				if(n.edges.get(i).color.equals("WHITE")) {
					n.edges.get(i).color = "GREY";
					n.edges.get(i).setTime(time);
					time++;
					stack.push(n.edges.get(i));
				}
			}
		}
	}
}