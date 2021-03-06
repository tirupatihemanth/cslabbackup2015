
public class WeightedNode extends Node{

	private int weight;

	public WeightedNode(int nodeIdx){
		super(nodeIdx);
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
		
	}
	
	public int compareTo(WeightedNode node){
		return weight - node.getWeight();
	}
	
}
