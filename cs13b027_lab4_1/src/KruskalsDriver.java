import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;


public class KruskalsDriver {


	public static void main(String[] args){
		
		
		Scanner input = null;
		try {
			input = new Scanner(new FileInputStream(
					System.getProperty("user.dir") + "/input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int cost = input.nextInt();
		ArrayList<Integer> alist = new ArrayList<Integer>();

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
		boolean[] nodeStatus = new boolean[n];
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i=0;i<n;i++){
			nodes[i] = new Node(i);
			nodeStatus[i] = false;
		}
		
		for(int i=0;i<m;i++){
			edges.add(new Edge(nodes[listiterator.next()], nodes[listiterator.next()], listiterator.next()));
		}
		edges.sort(null);
		
		for(Edge edge: edges){
			if(!nodeStatus[edge.getFirstNode().getIndex()]){
				edge.setPresent(1);
				nodeStatus[edge.getFirstNode().getIndex()] = true;
				if(!nodeStatus[edge.getSecondNode().getIndex()]){
					nodeStatus[edge.getSecondNode().getIndex()] = true;
				}
			}
			else if(!nodeStatus[edge.getSecondNode().getIndex()]){
				edge.setPresent(1);
				nodeStatus[edge.getSecondNode().getIndex()] = true;
			}
			
		}
	
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
		
		int sum = 0;
		edges.sort(comp);
		
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(System.getProperty("user.dir")+"/output1.txt");
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
		
		writer.println(sum*cost);
		
		//System.out.println(cost*sum);
		for(Edge edge:edges){
			if(edge.getPresent() == 1){
				writer.printf("%d %d\n",edge.getFirstNode().getIndex()+1, edge.getSecondNode().getIndex()+1);
				//System.out.printf("%d %d\n",edge.getFirstNode().getIndex()+1, edge.getSecondNode().getIndex()+1);
			}
		}
		
		writer.flush();
		writer.close();
		input.close();
	}
	

}