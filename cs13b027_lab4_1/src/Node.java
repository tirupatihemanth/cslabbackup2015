
public class Node implements Comparable<Node>{

	private int index;
	private int minPath;
	private int visitStatus;
	private int prevNodeIdx;
	private int parent;
	
	
	public Node(int index){
		this.index = index;
		this.minPath = Integer.MAX_VALUE;
		this.visitStatus = 0;
		this.prevNodeIdx = -1;
		this.parent = -1;
	}
	
	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}
	
	public void setVisitStatus(int visitStatus){
		this.visitStatus =  visitStatus;
	}
	
	public int getVisitStatus(){
		return visitStatus;
	}
	public int getPrevNodeIdx() {
		return prevNodeIdx;
	}

	public void setPrevNodeIdx(int prevNodeIdx) {
		this.prevNodeIdx = prevNodeIdx;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getMinPath() {
		return minPath;
	}

	public void setMinPath(int minPath) {
		this.minPath = minPath;
	}

	@Override
	public int compareTo(Node node) {
		// TODO Auto-generated method stub
		return minPath - node.getMinPath();
	}
	
}
