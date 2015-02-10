import java.util.Scanner;

public class BipartiteDFS {

	static int n, m;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		
		Graph graph = new Graph(n);
		
		for(int i = 0;i<m;i++){
			graph.addUndirectedEdge(input.nextInt(), input.nextInt());
		}
		
		boolean bipartite = true;
		for (int i = 0; i < n; i++) {
			if (graph.getNode(i).getColor() == 0) {
				graph.getNode(i).setColor(1);
			}
			if(bipartite){
				bipartite = checkBipartite(graph, i);
			}
		}

		if (bipartite) {
			System.out.println("Bipartite");
		} else {
			System.out.println("Not Bipartite");
		}

	}

	public static boolean checkBipartite(Graph graph,int vertex) {
		
		Node node = graph.getNode(vertex);
		if (node.getVisitStatus()!=0) {
			return true;
		} else {
			
			node.setVisitStatus(1);
			for (Node temp : graph.getAdacentNodes(vertex)) {

				if (node.getColor() == 1) {
					if (temp.getColor() == 0) {
						temp.setColor(2);
					}
				} else if (node.getColor() == 2) {
					if (temp.getColor() == 0) {
						temp.setColor(1);
					}
				}

				if (temp.getColor() == node.getColor()) {
					//System.out.println("blah");
					return false;
				}

			}

			for (Node temp : graph.getAdacentNodes(vertex)) {
				if (!checkBipartite(graph,temp.getIndex())) {
					return false;
				}
			}
		}

		return true;
	}

}