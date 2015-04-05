package cs13b027_lab8_2;

//Node class which instantiates to a node object
public class BSNode {

	BSNode left, right;
	int data;

	// Constructor for creating a new node
	public BSNode(BSNode left, BSNode right, int data) {
		this.left = left;
		this.right = right;
		this.data = data;
	}

	// Overloading constructors depending on the user requirements
	public BSNode(int data) {
		this.data = data;
	}

}
