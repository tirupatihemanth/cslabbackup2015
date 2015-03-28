package cs13b027_lab7_2;

import java.util.Scanner;

public class MinCCTvCameras {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		Node[] nodes = new Node[n];

		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(i);
		}

		/**
		 * Taking input and cunstructing a tree as it connected we just start from any node as a root and proceed further
		 */
		while (input.hasNext()) {	
			int temp1 = input.nextInt()-1;
			int temp2 = input.nextInt()-1;
			if(temp1<temp2){
				nodes[temp1].getChildren().add(nodes[temp2]);
			}
			else{
				nodes[temp2].getChildren().add(nodes[temp1]);
			}
		}

		System.out.println(getMinCameras(nodes[0]));

	}

	/**
	 * Method which undergoes recursion necessary for dynamic programming
	 * @param node
	 * @return
	 */
	public static int getMinCameras(Node node) {
		if (node == null) {
			return 0;
		}
		boolean temp = true;
		for (Node tempNode : node.getChildren()) {
			temp = temp && (tempNode == null);
		}
		if (temp) {
			return 0;
		}
		
		if(node.getPresent()!=0){
			return node.getPresent();
		}
		int nodeSize1 = 1;
		for (Node tempNode : node.getChildren()) {
			nodeSize1 += getMinCameras(tempNode);
		}
		int nodeSize2 = 0;
		
		for(Node tempNode : node.getChildren()){
			nodeSize2++;
			for(Node grandChild: tempNode.getChildren()){
				nodeSize2+=getMinCameras(grandChild);
			}
		}
		
		node.setPresent(nodeSize1<nodeSize2?nodeSize1: nodeSize2);
		return node.getPresent();
		
	}

}
