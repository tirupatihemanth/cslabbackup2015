package lab3_3;


import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

	private ArrayList<LinkedList<Edge>> graph;
	private Node[] nodes;

	public Graph(int vertices, int edges){
		
		graph = new ArrayList<LinkedList<Edge>>();
		nodes = new Node[vertices];
		for(int i=0;i<vertices;i++){
			nodes[i] = new Node(i);
			graph.add(new LinkedList<Edge>());
		}
		
	}
	
	public void addWeightedUndirectedEdge(int nodeIdx1, int nodeIdx2, int weight){
		
		graph.get(nodeIdx1).add(new Edge(nodes[nodeIdx1], nodes[nodeIdx2], weight));
		graph.get(nodeIdx2).add(new Edge(nodes[nodeIdx2], nodes[nodeIdx1], weight));
		
	}
	
	public LinkedList<Edge> getAdjacentEdges(int nodeIdx){
		return graph.get(nodeIdx);
	}
	
	public Node getNode(int nodeIdx){
		return nodes[nodeIdx];
	}
	
	
}
