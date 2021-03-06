package cs13b027_lab8_1;
public class Edge{

	
	private Node a;
	private Node b;
	private int capacity;
	private int flow;
	private int maxFlow;
	public int getMaxFlow() {
		return maxFlow;
	}


	public void setMaxFlow(int maxFlow) {
		this.maxFlow = maxFlow;
	}

	private boolean pathMark;


	public boolean getPathMark() {
		return pathMark;
	}


	public void setPathMark(boolean pathMark) {
		this.pathMark = pathMark;
	}


	public int getFlow() {
		return flow;
	}


	public void setFlow(int flow) {
		this.flow = flow;
	}


	public Edge(Node a, Node b, int capacity){
		
		this.a = a;
		this.b = b;
		this.capacity = capacity;
		this.flow = 0;
	}
	
	public Edge(Node a, Node b, int capacity, int flow){
		this.a = a;
		this.b = b;
		this.capacity = capacity;
		this.flow = flow;
	}
	
	
	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public Node getFirstNode(){
		return a;
	}
	
	public Node getSecondNode(){
		return b;
	}
	
	public String toString(){
		return this.getFirstNode() + "->" + this.getSecondNode();
	}
	
}
