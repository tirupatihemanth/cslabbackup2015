package lab3_3;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int m = input.nextInt();

		Graph graph = new Graph(n, m);

		for (int i = 0; i < m; i++) {	
			graph.addWeightedUndirectedEdge(input.nextInt(), input.nextInt(),
					input.nextInt());
		}
		graph.getNode(0).setMinPath(0);

		PriorityQueue<Node> pQueue = new PriorityQueue<Node>();

		for (int i = 0; i < n; i++) {
			pQueue.add(graph.getNode(i));
		}

		Node temp, temp1;
		int minPath;

		while (true) {
			temp = pQueue.poll();
			//System.out.println("minElement: " + temp.getMinPath());
			if ( temp == null || temp.getMinPath() == Integer.MAX_VALUE ) {
				break;
			}

			temp.setVisitStatus(1);
			
			for (Edge adjEdge : graph.getAdjacentEdges(temp.getIndex())) {
				
				if(adjEdge.getSecondNode().getVisitStatus()!=1){
				
					minPath = temp.getMinPath() + adjEdge.getWeight();
					if (minPath < adjEdge.getSecondNode().getMinPath()) {
						
						pQueue.remove(adjEdge.getSecondNode());
						adjEdge.getSecondNode().setMinPath(minPath);
						adjEdge.getSecondNode().setPrevNodeIdx(temp.getIndex());
						pQueue.add(adjEdge.getSecondNode());
						
					}
					
				}
			}
		}

		int destination;
	while ((destination = input.nextInt()) != 0) {
			if (graph.getNode(destination).getMinPath() == Integer.MAX_VALUE) {
				System.out.println("No route Found");
			} else {
				printPath(graph, destination);
				System.out.print(destination + " ");
				System.out.println();
			}
		}

	}

	public static void printPath(Graph graph, int destination) {

		if (graph.getNode(destination).getPrevNodeIdx() == -1) {
			return;
		}

		int nodeIdx = graph.getNode(destination).getPrevNodeIdx();
		printPath(graph, nodeIdx);
		System.out.print(nodeIdx + " ");
	}

}
