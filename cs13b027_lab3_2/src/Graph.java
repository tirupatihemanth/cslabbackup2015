import java.util.ArrayList;
import java.util.LinkedList;


public class Graph {

	private ArrayList<LinkedList<Node>> adjList;

	private Node[] nodes;
	
	public Graph(int nodes){
		adjList = new ArrayList<LinkedList<Node>>();
		
		
		this.nodes = new Node[nodes];
		for(int i =0;i<nodes;i++){
			this.nodes[i] = new Node(i);
			adjList.add(new LinkedList<Node>());
		
		}
	}
	
	public void addUndirectedEdge(int nodeIdx1, int nodeIdx2){
		this.adjList.get(nodeIdx1).add(nodes[nodeIdx2]);
		this.adjList.get(nodeIdx2).add(nodes[nodeIdx1]);
	}
	
	public void addEdge(int nodeIdx1, int nodeIdx2){
		this.adjList.get(nodeIdx1).add(nodes[nodeIdx2]);
	}
	
	public Node getNode(int nodeIdx){
		return nodes[nodeIdx];
	}
	
	public LinkedList<Node> getAdacentNodes(int nodeIdx){
		return this.adjList.get(nodeIdx);
	}

	public ArrayList<LinkedList<Node>> getAdjList() {
		return adjList;
	}

	public void setAdjList(ArrayList<LinkedList<Node>> adjList) {
		this.adjList = adjList;
	}






	
}
