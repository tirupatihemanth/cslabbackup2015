package cs13b027_lab8_1;
public class Node{

	private int index;

	public Node(int index){
		this.index = index;
		
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public String toString(){
		return  String.valueOf(this.index);
	}
}
