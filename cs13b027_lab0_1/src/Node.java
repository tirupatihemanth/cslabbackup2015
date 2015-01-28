// Node class which instantiates to a node object
public class Node {

	Node left, right;
	int data;

	// Constructor for creating a new node
	public Node(Node left, Node right, int data) {
		this.left = left;
		this.right = right;
		this.data = data;
	}

	// Overloading constructors depending on the user requirements
	public Node(int data) {
		this.data = data;
	}

}
