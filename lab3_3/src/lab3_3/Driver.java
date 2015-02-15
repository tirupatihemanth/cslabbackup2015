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

		//System.out.println(pQueue.toString());
		
		Node temp;
		int minPath;

		while (true) {
			temp = pQueue.poll();
			System.out.print(temp.getMinPath()+" ");
			if (temp.getMinPath() == Integer.MAX_VALUE) {
				break;
			}

			temp.setVisitStatus(1);
			for (Edge adjEdge : graph.getAdjacentEdges(temp.getIndex())) {
				//System.out.println("blah");
				if (adjEdge.getSecondNode().getVisitStatus() != 1) {
					///System.out.println("blah");
					minPath = temp.getMinPath() + adjEdge.getWeight();
					if (minPath < adjEdge.getSecondNode().getMinPath()) {
						adjEdge.getSecondNode().setMinPath(minPath);
						adjEdge.getSecondNode().setPrevNodeIdx(temp.getIndex());
					} 	
				}

			}
		}
		int destination;
		while((destination = input.nextInt())!=0){
			printPath(graph, destination);
			System.out.println();
		}

	}
	
	public static void printPath(Graph graph, int destination){
		
		if(graph.getNode(destination).getPrevNodeIdx() == -1){
			return;
		}
		
		int nodeIdx = graph.getNode(destination).getPrevNodeIdx();
		printPath(graph,nodeIdx);
		System.out.print(nodeIdx);
	}
	

}
