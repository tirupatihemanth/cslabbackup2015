import java.util.ListIterator;

//Using this interface a graph can be implemented either by using a matrix or an adjacency list

public interface IGraph {

	public void addEdge(int nodeIdx1, int nodeIdx2);
	public void addEdge(INode node1, INode node2);
	
	public void removeEdge(int nodeIdx1, int nodeIdx2);
	public void removeEdge(INode node1, INode node2);
	
	public void addUndirectedEdge(int nodeIdx1, int nodeIdx2);
	public void addUndirectedEdge(INode node1, INode node2);
	
	public void removeUndirectedEdge(int nodeIdx1, int nodeIdx2);
	public void removeUndirectedEdge(INode node1, INode node2);
	
	public ListIterator<IEdge> getAdjacentEdges(int nodeIdx);
	public ListIterator<IEdge> getAdjacentEdges(INode node);
	
	public INode getNode(int nodeIdx);
	public int numOfNodes();
	public int numOfEdges();
	
	
}
