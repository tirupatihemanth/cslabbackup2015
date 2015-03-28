package cs13b027_lab5_2;

public class Node {

	/*
	 * Structure of the node
	 * lmc ---> Left Most Child
	 * rs ---> Right Sibling
	 */
	private Node lmc;
	private Node rs;
	private Node parent;
	private int degree;
	private int data;
	
	
	public Node(int data){
		this.data = data;
		this.degree = 0;
	}
	
	
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public Node getLmc() {
		return lmc;
	}
	public void setLmc(Node lmc) {
		this.lmc = lmc;
	}
	public Node getRs() {
		return rs;
	}
	public void setRs(Node rs) {
		this.rs = rs;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
}
