
public class DijkstrasNode extends WeightedNode{

	private int visitStatus;
	private int minPath;
	
	public int getVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(int visitStatus) {
		this.visitStatus = visitStatus;
	}

	public int getMinPath() {
		return minPath;
	}

	public void setMinPath(int minPath) {
		this.minPath = minPath;
	}

	public DijkstrasNode(int index) {
		super(index);
		// TODO Auto-generated constructor stub
	}

}
