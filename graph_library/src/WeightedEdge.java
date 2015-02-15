
public class WeightedEdge extends Edge{
	
	private int weight;
	
	public WeightedEdge(Node a, Node b, int weight){
		super(a, b);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	
}
