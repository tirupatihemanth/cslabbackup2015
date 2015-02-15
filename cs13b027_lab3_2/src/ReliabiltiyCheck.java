import java.util.Scanner;


public class ReliabiltiyCheck {

	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		
		Graph graph = new Graph(n);
		
		for(int i = 0;i<m;i++){
			graph.addEdge(input.nextInt()-1, input.nextInt()-1);
		}
		
		boolean reliable = true;
		
		for(int i=0;i<n;i++){
			if(reliable){
				reliable = reliabilityCheck(graph, i);
			}
		}
		
		if(reliable){
			System.out.println("RELIABLE");
		}
		else{
			System.out.println("NOT RELIABLE");
		}
		
	}
	
	public static boolean reliabilityCheck(Graph graph, int vertex){
	
		Node node = graph.getNode(vertex);
		
		if(node.getVisitStatus() == 1){
			return false;
		}
		else{
			node.setVisitStatus(1);
			
			for(Node adj: graph.getAdacentNodes(vertex)){
				if(!reliabilityCheck(graph, adj.getIndex())){
					return false;
				}
			}
		}
		node.setVisitStatus(0);
		return true;
	}
	
}