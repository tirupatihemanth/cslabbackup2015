import java.util.Scanner;


public class ReliabiltiyCheck {

	static int n, hamiltonianCycle=0;
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		int m = input.nextInt();
		
		Graph graph = new Graph(n);
		
		for(int i = 0;i<m;i++){
			graph.addEdge(input.nextInt()-1, input.nextInt()-1);
		}
		
		boolean reliable = true;
		
		for(int i=0;i<n;i++){
			if(reliable){
				reliable = reliabilityCheck(graph, i, 0);
			}
			if(hamiltonianCycle == 1){
				reliable=true;
				break;
			}
		}
		
		if(reliable){
			System.out.println("RELIABLE");
		}
		else{
			System.out.println("NOT RELIABLE");
		}
		
	}
	
	public static boolean reliabilityCheck(Graph graph, int vertex, int visited){
	
		Node node = graph.getNode(vertex);
		
		if(node.getVisitStatus() == 1){
			return false;
		}
		else{
			node.setVisitStatus(1);
			visited++;
			for(Node adj: graph.getAdacentNodes(vertex)){
				if(!reliabilityCheck(graph, adj.getIndex(), visited)){
					if(visited== n){
						hamiltonianCycle=1;
						return true;
					}
					return false;
				}
			}
		}
		node.setVisitStatus(0);
		return true;
	}
	
}
