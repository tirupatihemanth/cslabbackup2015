package cs13b027_lab5_2;

public class BinomialHeap {

	//The binomialHeap Implemented here is a minimum binomial heap
	public Node head;
	
	public Node minimum(){
		
		//To obtain the minimum in a given binomialHeap
		Node current = head;
		Node minNode = null;
		int min = Integer.MAX_VALUE;
		
		while(current!=null){
			if(current.getData()<min){
				minNode = current;
			}
			current = current.getRs();
		}
		return minNode;
	}
	
	public void insert(int data){

		//Insert elements in the binomialHeap using meld operation
		BinomialHeap tempHeap = new BinomialHeap();
		Node tempNode = new Node(data);
		tempHeap.head = tempNode;
		heapMeld(tempHeap);
		//System.out.println("blah");
	}

	public void heapMeld(BinomialHeap heap2) {
		
		//Method to meld two binomial Heaps
		head = rootListMerge(heap2.head);
		if(head == null){
			return;
		}
		
		Node prevNode = null,curNode = head,nextNode = head.getRs(),temp;
		while(nextNode!=null){
			if(curNode.getDegree()!=nextNode.getDegree() || (nextNode.getRs()!=null && curNode.getDegree() == nextNode.getRs().getDegree())){
				prevNode = curNode;
				curNode = nextNode;
				nextNode = curNode.getRs();
			}
			else{
				if(curNode.getData()<=nextNode.getData()){	
					temp = nextNode.getRs();
					curNode = treeUnion(curNode, nextNode);
					if(prevNode!=null){
						prevNode.setRs(curNode);
					}
					curNode.setRs(temp);
				}
				else{
					curNode = treeUnion(curNode, nextNode);
					if(prevNode!=null){
						prevNode.setRs(curNode);
					}
					
				}
				nextNode = curNode.getRs();
			}
			
			if(head.getParent()!=null){
				head = head.getParent();
			}
			
		}
		
	}
	
	
	public Node treeUnion(Node node1, Node node2){
		
		//Method for combining two binomial Heaps according to the rules of Binomial Trees
		if(node1.getData()>node2.getData()){
			Node temp = node2;
			node2 = node1;
			node1 = temp;
		}
		
		node2.setParent(node1);
		node2.setRs(node1.getLmc());
		node1.setLmc(node2);
		node1.setDegree(node1.getDegree()+1);
		return node1;
	}
	
	
	private Node rootListMerge(Node head2){
		
		//RootListMerge method does inplace merge of the two root lists using two extra pointers
		Node finalHead = null;
		Node currentHead = null;
	
		//Two avoid multiple time checking of the border line conditions
		if(head2!=null && head!=null){
			if(head.getDegree()<head2.getDegree()){
				finalHead = head;
				currentHead = head;
				head = head.getRs();
			}
			else if(head.getDegree()>head2.getDegree()){
				finalHead = head2;
				currentHead = head2;
				head2 = head2.getRs();
			}
			else{
				finalHead = head;
				currentHead = head;
				head = head.getRs();
				currentHead.setRs(head2);
				head2 = head2.getRs();
				currentHead = currentHead.getRs();
			}
		}
		else if(head == null){
			return head2;
		}
		else{
			return head;
		}
		
		//Now we neednot check much of boundary conditions
		
		while(true){
			
			if(head!=null && head2!=null){
				
				if(head.getDegree()<head2.getDegree()){
					currentHead.setRs(head);
					head = head.getRs();
					currentHead = currentHead.getRs();
				}
				else if(head.getDegree()>head2.getDegree()){
					currentHead.setRs(head2);
					head2 = head2.getRs();
					currentHead = currentHead.getRs();
				}
				else{
					currentHead.setRs(head);
					head = head.getRs();
					currentHead = currentHead.getRs();
					currentHead.setRs(head2);
					head2 = head2.getRs();
					currentHead = currentHead.getRs();
				}
				
			}
			else if(head!= null && head2 == null){
				currentHead.setRs(head);
				break;
			}
			else if(head == null && head2!=null){
				currentHead.setRs(head2);
				break;
			}
			else{
				break;
			}
			
		}
		
		return finalHead;
		
	}
	

	
}
