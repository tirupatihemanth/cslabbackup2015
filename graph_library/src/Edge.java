
public class Edge implements IEdge{

	private INode a;
	private INode b;
	private int weight;
	
	public Edge(INode a, INode b, int Weight){
		
		this.a = a;
		this.b = b;
		this.weight = weight;
	}
	
	public INode getFirstNode(){
		return a;
	}
	
	public INode getSecondNode(){
		return b;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	
}
