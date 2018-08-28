package A6_Dijkstra;

import java.util.HashMap;

public class Vertex {

	boolean marked;
	String label;
	long id;
	HashMap<String, Edge> outEdges;
	HashMap<String, Edge> inEdges;
	int indegree;
	long dist;
	
	public Vertex(long id, String label) {
		this.label = label;
		this.id = id;
		this.outEdges = new HashMap<String, Edge>();
		this.inEdges = new HashMap<String, Edge>();
		this.indegree = 0;
		this.marked = false;
		this.dist = 0;
	}	
	
	public String getLabel(){
	    return this.label;
	}
	
	public long getID(){
	    return this.id;
	}
	
}
