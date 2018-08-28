package DiGraph_A5;

public class Edge {

	Vertex startNode;
	Vertex destNode;
	String label;
	long id;
	long weight;
	
	public Edge(long id, long weight, String label, Vertex destNode, Vertex startNode) {
		this.id = id;
		this.weight = weight;
		this.label = label;
		this.startNode = startNode;
		this.destNode = destNode;
	}
}