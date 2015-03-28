package cs13b027_lab7_2;

import java.util.ArrayList;

/**
 * Node class as required by the {@link MinCCTvCameras}class
 * @author HemanthKumarTirupati
 *
 */
public class Node {

	private int index;
	private int isPresent;
	private ArrayList<Node> children;
	
	public Node(int index){
		this.index = index;
		isPresent = 0;
		children = new ArrayList<Node>();
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int isPresent() {
		return isPresent;
	}

	public int getPresent(){
		return isPresent;
	}
	public void setPresent(int isPresent) {
		this.isPresent = isPresent;
	}

	public ArrayList<Node> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}

	public String toString(){
		return  String.valueOf(this.index);
	}
}
