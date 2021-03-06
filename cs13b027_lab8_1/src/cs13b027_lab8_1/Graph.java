package cs13b027_lab8_1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

	private ArrayList<LinkedList<Edge>> graph;
	private ArrayList<Node> nodes;
	public Graph(int vertices, int edges){
		
		graph = new ArrayList<LinkedList<Edge>>();
		nodes = new ArrayList<Node>(vertices);
		for(int i=0;i<vertices;i++){
			nodes.add(new Node(i));
			graph.add(new LinkedList<Edge>());
		}
		
	}
	
	public void addEdge(int nodeIdx1, int nodeIdx2, int capacity){
		graph.get(nodeIdx1).add(new Edge(nodes.get(nodeIdx1), nodes.get(nodeIdx2), capacity));
	}
	
	public void addUndirectedEdge(int nodeIdx1, int nodeIdx2, int capacity){
		graph.get(nodeIdx1).add(new Edge(nodes.get(nodeIdx1), nodes.get(nodeIdx2), capacity, capacity));
		graph.get(nodeIdx2).add(new Edge(nodes.get(nodeIdx2), nodes.get(nodeIdx1), capacity));
	}
	
	public LinkedList<Edge> getAdjacentEdges(int idx){
		return graph.get(idx);
	}
	
	public Node getNode(int nodeIdx){
		return nodes.get(nodeIdx);
	}
	
	public ArrayList<Node> getAllNodes(){
		return nodes;
	}
	
	public ArrayList<LinkedList<Edge>> getAdjacencyList(){
		return graph;
	}
	
	
}
