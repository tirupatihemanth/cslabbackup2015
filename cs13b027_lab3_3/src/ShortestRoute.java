import java.util.Scanner;

public class ShortestRoute {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		Graph graph = new Graph(n,m);

		for (int i = 0; i < m; i++) {
			graph.addWeightedUndirectedEdge(input.nextInt(), input.nextInt(), input.nextInt());
		}

	}

}
