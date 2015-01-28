//public class which contains all the methods to be operated upon the Binary Search Trees and depends on Node

public class BSTree {

	Node rootNode;

	// private counterpart Add new node to the BSTree with the given data
	private Node add(Node node, int data) {

		if (node == null) {
			return new Node(data);
		} else if (data > node.data) {
			node.right = add(node.right, data);
		} else {
			node.left = add(node.left, data);
		}
		return node;
	}

	// public function to Add new node to the BSTree
	public Node add(int data) {

		return rootNode = add(rootNode, data);

	}

	// private counterpart to remove any node from BSTree
	private Node remove(Node node, int data) {

		if (node.data > data) {
			node.left = remove(node.left, data);
		} else if (node.data < data) {
			node.right = remove(node.right, data);
		} else {
			if (node.right == null) {
				return node.left;
			} else if (node.left == null) {
				return node.right;
			} else {
				Node right = node.right;
				while (right.left != null) {
					right = right.left;
				}
				right.left = node.left;
				return node.right;
			}
		}
		return node;

	}

	// public function to remove a data from bst
	public Node remove(int data) {
		if (rootNode == null) {
			return null;
		}
		return rootNode = remove(rootNode, data);
	}

	// private counter part to search for data in bst returns reference variable
	// to corresponding Node object if found else null
	private Node search(Node node, int data) {
		if (node == null)
			return null;
		else if (data > node.data)
			return search(node.right, data);
		else if (data < node.data)
			return search(node.left, data);
		else
			return node;
	}

	// public function to search for data in bst
	public Node search(int data) {
		return search(rootNode, data);
	}

	// private counterpart for printing the node in inorder
	private void print_inorder(Node node) {

		if (node == null) {
			return;
		} else {
			print_inorder(node.left);
			System.out.printf("%d ", node.data);
			print_inorder(node.right);
		}
	}

	// public function to print the bst in sorted or inorder
	public void print_inorder() {
		print_inorder(rootNode);
		System.out.println();
	}

	// print the tree in breadthfirst manner
	public void print_breadthfirst() {
		if (rootNode == null)
			return;
		else {
			Node[] node = new Node[count(rootNode)];
			int i = 0, n = 0;
			node[n++] = rootNode;

			while (i < n) {
				System.out.printf("%d ", node[i].data);
				if (node[i].left != null) {
					node[n++] = node[i].left;
				}
				if (node[i].right != null) {
					node[n++] = node[i].right;
				}
				i++;
			}

		}
		System.out.println();
	}

	// private function used by breadthfirst to count no. of elements in the bst
	private int count(Node node) {
		if (node == null)
			return 0;
		else
			return count(node.left) + 1 + count(node.right);
	}

	// public counterpart to find no. of nodes in the bst
	public int count() {
		return count(rootNode);
	}

}
