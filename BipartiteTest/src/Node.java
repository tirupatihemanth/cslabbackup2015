
public class Node {

	private int index;
	private int color;
	private int visitStatus;
	
	public Node(int index){
		this.index = index;
		this.color = 0;
		this.visitStatus = 0;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
	
	public int getVisitStatus() {
		return visitStatus;
	}
	
	public void setVisitStatus(int visitStatus) {
		this.visitStatus = visitStatus;
	}
	
	
}
