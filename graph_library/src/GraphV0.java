import java.util.ArrayList;
import java.util.LinkedList;


public class GraphV0 {

	private ArrayList<LinkedList<Node>> adjList;
	private ArrayList<LinkedList<Weight>> wtList;
	private Node[] nodes;
	
	public GraphV0(int nodes){
		adjList = new ArrayList<LinkedList<Node>>();
		wtList = new ArrayList<LinkedList<Weight>>();
		this.nodes = new Node[nodes];
		for(int i =0;i<nodes;i++){
			this.nodes[i] = new Node(i);
			adjList.add(new LinkedList<Node>());
			wtList.add(new LinkedList<Weight>());
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

	public void setWeight(int n, int m, int weight){
		this.wtList.get(n).add(new Weight(m, weight));
	}
	
	public void setUndirectedWeight(int n, int m, int weight) {
		// TODO Auto-generated method stub
		this.wtList.get(n).add(new Weight(m, weight));
		this.wtList.get(m).add(new Weight(n, weight));
	}
}
