import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsDriver {

	public static void main(String[] args) {

		int cost;
		Scanner input = null;
		try {
			input = new Scanner(new FileInputStream(
					System.getProperty("user.dir") + "/input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cost = input.nextInt();
		ArrayList<Integer> alist = new ArrayList<Integer>();

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

		PriorityQueue<Node> pQueue = new PriorityQueue<Node>();

		for (int i = 0; i < n; i++) {
			pQueue.add(graph.getNode(i));
		}

		graph.getNode(0).setMinPath(0);
		Node minNode;
		int minPath;

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
						// ListIterator<Edge> iterator =
						// graph.getAdjacentEdges(adjEdge.getSecondNode().getPrevNodeIdx()).listIterator();

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
		
		//System.out.println(cost*sum);
		
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(System.getProperty("user.dir")+"/output2.txt");
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
