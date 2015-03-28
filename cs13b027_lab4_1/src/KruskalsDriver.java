import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class KruskalsDriver {


	public static void main(String[] args){
		
		//taking input from the command line arguments
		
		Scanner input = null;
		String file1 = args[0];
		String file2 = args[2];
		try {
			file1 = System.getProperty("user.dir")+ "/" + file1;
			//System.out.println(file1);
			//System.out.println(System.getProperty("user.dir")+"/" + file1);
			input = new Scanner(new FileInputStream(file1));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int cost = input.nextInt();
		ArrayList<Integer> alist = new ArrayList<Integer>();

		//Determining the no. of edges
		
		int n = Integer.MIN_VALUE, temp;
		while (input.hasNext()) {
			temp = input.nextInt() - 1;
			alist.add(temp);
			n = n < temp ? temp : n;
			temp = input.nextInt() - 1;
			alist.add(temp);
			n = n < temp ? temp : n;
			alist.add(input.nextInt());
		}

		n++;
		int m = alist.size() / 3;
		
		ListIterator<Integer> listiterator = alist.listIterator();
		Node[] nodes = new Node[n];
		ArrayList<Edge> edges = new ArrayList<Edge>();
		ArrayList<LinkedList<Node>> componentList = new ArrayList<LinkedList<Node>>();
		for(int i=0;i<n;i++){
			componentList.add(new LinkedList<Node>());
			nodes[i] = new Node(i);
		}
		
		for(int i=0;i<m;i++){
			edges.add(new Edge(nodes[listiterator.next()], nodes[listiterator.next()], listiterator.next()));
		}
		//sorting is done here based on the edges as required by the kruskal's algorithm
		
		edges.sort(null);

		//Determining if the edges form a cycle by component method
		
		for(Edge edge: edges){
			
			
			if(edge.getFirstNode().getParent() == -1 && edge.getSecondNode().getParent() == -1){
				
				componentList.get(edge.getFirstNode().getIndex()).add(edge.getFirstNode());
				componentList.get(edge.getFirstNode().getIndex()).add(edge.getSecondNode());
				edge.getFirstNode().setParent(edge.getFirstNode().getIndex());
				edge.getSecondNode().setParent(edge.getFirstNode().getIndex());
				edge.setPresent(1);
				
			}
			else if(edge.getFirstNode().getParent() == -1 && edge.getSecondNode().getParent()!= -1){
				componentList.get(edge.getSecondNode().getParent()).add(edge.getFirstNode());
				edge.getFirstNode().setParent(edge.getSecondNode().getParent());
				edge.setPresent(1);
			}
			else if(edge.getFirstNode().getParent() != -1 && edge.getSecondNode().getParent() == -1){
				
				componentList.get(edge.getFirstNode().getParent()).add(edge.getSecondNode());
				edge.getSecondNode().setParent(edge.getFirstNode().getParent());
				edge.setPresent(1);
			}
			else if(edge.getFirstNode().getParent()!= edge.getSecondNode().getParent()){
				
				int idx = edge.getFirstNode().getParent();
				for(Node node: componentList.get(edge.getSecondNode().getIndex())){
					node.setParent(idx);
					componentList.get(edge.getFirstNode().getIndex()).add(node);
				}
				edge.setPresent(1);
			
			}
			
		}
	
		//New comparator for sorting of edges so that output is as required
		
		Comparator<Edge> comp = new Comparator<Edge>(){

			@Override
			public int compare(Edge o1, Edge o2) {
				int temp = o1.getFirstNode().getIndex()-o2.getFirstNode().getIndex();
				if(temp == 0){
					return o1.getSecondNode().getIndex() - o2.getSecondNode().getIndex();
				}
				else{
					return temp;
				}
			}
		
		};
		
		//wrting to files
		
		int sum = 0;
		edges.sort(comp);
		FileOutputStream outputStream = null;
		try {
			file2 = System.getProperty("user.dir")+"/" + file2;
			//System.out.println(file2);
			outputStream = new FileOutputStream(file2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter writer = new PrintWriter(outputStream);
		
		for(Edge edge:edges){
			if(edge.getPresent() == 1){
				sum+= edge.getWeight();
			}
		}
		// TODO: kajdlkjfkadjfkj
		writer.println(sum*cost);
		
		//System.out.println(cost*sum);
		for(Edge edge:edges){
			if(edge.getPresent() == 1){
				writer.printf("%d %d\n",edge.getFirstNode().getIndex()+1, edge.getSecondNode().getIndex()+1);
				//System.out.printf("%d %d\n",edge.getFirstNode().getIndex()+1, edge.getSecondNode().getIndex()+1);
			}
		}
		
		// TODO: akldjfkajdfk
		
		writer.flush();
		writer.close();
		input.close();
		
		//Calling prims algorithm using first two arguments
		PrimsDriver.primsAlgo(args[0], args[1]);
		
	}
	

}
