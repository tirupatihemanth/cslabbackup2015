
public class Node implements INode, Comparable<Node>{

	private int index;
	private int visitStatus;
	private int minPath;
	
	public Node(int index){
		this.index = index;
	}
	
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	

	@Override
	public int compareTo(Node node) {
		// TODO Auto-generated method stub
		return minPath - node.minPath;
	}
	
	
}
