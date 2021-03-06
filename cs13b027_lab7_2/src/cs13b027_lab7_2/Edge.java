package cs13b027_lab7_2;
public class Edge implements Comparable<Edge>{

	
	private Node a;
	private Node b;
	private int weight;
	private int present;
	
	public Edge(Node a, Node b, int wt){
		
		this.a = a;
		this.b = b;
		this.weight = wt;
		this.present = 0;
	}
	
	
	public Node getA() {
		return a;
	}

	public void setA(Node a) {
		this.a = a;
	}

	public Node getB() {
		return b;
	}

	public void setB(Node b) {
		this.b = b;
	}

	public int getPresent() {
		return present;
	}

	public void setPresent(int present) {
		this.present = present;
	}


	public Node getFirstNode(){
		return a;
	}
	
	public Node getSecondNode(){
		return b;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	
	}


	@Override
	public int compareTo(Edge edge) {
		// TODO Auto-generated method stub
		
		return weight - edge.getWeight();
	}	
	
	public String toString(){
		return this.getFirstNode() + "->" + this.getSecondNode();
	}
}
