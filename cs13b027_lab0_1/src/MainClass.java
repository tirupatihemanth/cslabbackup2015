import java.util.Scanner;

//Class Which drives the Module i.e which contains the main method and which depends on BSTree class and Node class

public class MainClass {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BSTree bstree = new BSTree();

		while (input.hasNext()) {
			// System.out.println("Getting Input");
			int data = input.nextInt();

			if (data == -1) {
				break;
			}

			if (bstree.search(data) == null) {
				// System.out.println("item not found");
				// System.out.println(bstree.rootNode.data);
				bstree.add(data);
			} else {
				// System.out.println("Item already present");
				bstree.remove(data);
			}

			bstree.print_inorder();

		}
		// bstree.print_breadthfirst();
		// System.out.println(bstree.count());
		// System.out.println("Program finished");

	}

}
