import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsDriver {

	/**
	 * This function performs the prim's algorithm for the given graph. 
	 * It does not work for some cases. 
	 * @param file1
	 * @param file2
	 */
	public static void primsAlgo(String file1, String file2) {

		int cost;
		Scanner input = null;
		
		//taking input from the command line
		
		try {
			file1 = System.getProperty("user.dir")+"/" + file1;
			input = new Scanner(new FileInputStream(file1));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cost = input.nextInt();
		ArrayList<Integer> alist = new ArrayList<Integer>();

		//determining number of nodes
		
		int n = Integer.MIN_VALUE, temp;
		while (input.hasNext()) {
			temp = input.nextInt() - 1;
			alist.add(temp);
			n = n < temp ? temp : n;
			temp = input.nextInt() - 1;
			alist.add(temp);
			n = n < temp ? temp : n;
			alist.add(input.nextInt());
		}

		n++;
		int m = alist.size() / 3;
		Graph graph = new Graph(n, m);
		ListIterator<Integer> listiterator = alist.listIterator();

		for (int i = 0; i < m; i++) {
			graph.addWeightedUndirectedEdge(listiterator.next(),
					listiterator.next(), listiterator.next());
		}

		//Adding nodes to the priority queue to get the minimum weight from the visited set to the unvisited set
		
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>();

		for (int i = 0; i < n; i++) {
			pQueue.add(graph.getNode(i));
		}

		graph.getNode(0).setMinPath(0);
		Node minNode;
		int minPath;

		//Algorithm to add edges to the visited set and build up the spanning tree
		
		while (true) {
			minNode = pQueue.poll();
			if (minNode == null || minNode.getMinPath() == Integer.MAX_VALUE) {
				break;
			}

			//System.out.println(minNode.getIndex());

			minNode.setVisitStatus(1);
			for (Edge adjEdge : graph.getAdjacentEdges(minNode.getIndex())) {
				if (adjEdge.getSecondNode().getVisitStatus() != 1) {
					minPath = adjEdge.getWeight();
					if (minPath < adjEdge.getSecondNode().getMinPath()) {
						pQueue.remove(adjEdge.getSecondNode());
						adjEdge.setPresent(1);
						
						if (adjEdge.getSecondNode().getPrevNodeIdx() != -1) {
							for (Edge tempEdge : graph.getAdjacentEdges(adjEdge
									.getSecondNode().getPrevNodeIdx())) {
								if (tempEdge.getSecondNode().getIndex() == adjEdge
										.getSecondNode().getIndex()) {
									tempEdge.setPresent(0);
									break;
								}
							}
						}
						
						adjEdge.getSecondNode().setMinPath(minPath);
						adjEdge.getSecondNode().setPrevNodeIdx(
								minNode.getIndex());
		
						pQueue.add(adjEdge.getSecondNode());

					}
				}
			}
			
			
		}

		int sum =0;
		for (int i = 0; i < n; i++) {
			for (Edge adjEdge : graph.getAdjacentEdges(i)) {
				if (adjEdge.getPresent() == 1) {
					sum+=adjEdge.getWeight();
				}
			}
		}
		
		//Writing the output to the output files
		
		//System.out.println(cost*sum);
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(file2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter writer = new PrintWriter(outputStream);
		
		writer.println(sum*cost);
		
		for (int i = 0; i < n; i++) {
			for (Edge adjEdge : graph.getAdjacentEdges(i)) {
				if (adjEdge.getPresent() == 1) {
					writer.printf("%d %d\n",i+1,adjEdge.getSecondNode().getIndex()+1);
					//System.out.printf("%d %d\n",i+1,adjEdge.getSecondNode().getIndex()+1);
				}
			}
		}
		writer.flush();
		writer.close();
		input.close();
		
	}
}
