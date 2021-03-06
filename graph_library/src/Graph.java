import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;


//Giving IGraph interface this Graph implements Graph by using adjacency list
public class Graph implements IGraph{

	private ArrayList<LinkedList<IEdge>> graph;
	private Node[] nodes;
	private int vertices;
	private int edges;
	
	public Graph(int vertices, int edges){
		this.vertices = vertices;
		this.edges = edges;
		nodes = new Node[vertices];
		
		for(int i=0;i<vertices;i++){
			graph.add(new LinkedList<IEdge>());
			nodes[i] = new Node(i);
		}
		
	}
	
	public ArrayList<LinkedList<IEdge>> getGraph() {
		return graph;
	}

	public void setGraph(ArrayList<LinkedList<IEdge>> graph) {
		this.graph = graph;
	}

	public Node[] getNodes() {
		return nodes;
	}

	public void setNodes(Node[] nodes) {
		this.nodes = nodes;
	}
	
	@Override
//	public void addEdge(int nodeIdx1, int nodeIdx2) {
//		// TODO Auto-generated method stub
//		
//		graph.get(nodeIdx1).add(new Edge(nodes[nodeIdx1], nodes[nodeIdx2]));
//		//graph.get(nodeIdx2).add(new Edge(nodes[nodeIdx2], nodes[nodeIdx1]));
//		
//	}

	public void addWeightedEdge(int nodeIdx1, int nodeIdx2, int weight){
		graph.get(nodeIdx1).add(new Edge(nodes[nodeIdx1], nodes[nodeIdx2], weight));
	}
	
	@Override
	public void addEdge(INode node1, INode node2) {
		// TODO Auto-generated method stub
		
		graph.get(node1.getIndex()).add(new Edge(node1, node2));
		
	}

	@Override
	public void removeEdge(int nodeIdx1, int nodeIdx2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEdge(INode node1, INode node2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUndirectedEdge(int nodeIdx1, int nodeIdx2) {
		// TODO Auto-generated method stub
		
		graph.get(nodeIdx1).add(new Edge(nodes[nodeIdx1], nodes[nodeIdx2]));
		graph.get(nodeIdx2).add(new Edge(nodes[nodeIdx2], nodes[nodeIdx1]));
		
	}
	
	public void addWeightedUndirectedEdge(int nodeIdx1, int nodeIdx2, int weight){
		
		graph.get(nodeIdx1).add(new Edge(nodes[nodeIdx1], nodes[nodeIdx2], weight));
		graph.get(nodeIdx2).add(new Edge(nodes[nodeIdx2], nodes[nodeIdx2], weight));
		
	}

	@Override
	public void addUndirectedEdge(INode node1, INode node2) {
		// TODO Auto-generated method stub
		
		graph.get(node1.getIndex()).add(new Edge(node1, node2));
		graph.get(node2.getIndex()).add(new Edge(node2, node1));
		
	}

	@Override
	public void removeUndirectedEdge(int nodeIdx1, int nodeIdx2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUndirectedEdge(INode node1, INode node2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListIterator<IEdge> getAdjacentEdges(int nodeIdx) {
		// TODO Auto-generated method stub
		return graph.get(nodeIdx).listIterator();
	}

	@Override
	public ListIterator<IEdge> getAdjacentEdges(INode node) {
		// TODO Auto-generated method stub
		return graph.get(node.getIndex()).listIterator();
	}

	@Override
	public INode getNode(int nodeIdx) {
		// TODO Auto-generated method stub
		return nodes[nodeIdx];
	}

	@Override
	public int numOfNodes() {
		// TODO Auto-generated method stub
		return vertices;
	}
	
	@Override
	public int numOfEdges(){
		return edges;
	}

}