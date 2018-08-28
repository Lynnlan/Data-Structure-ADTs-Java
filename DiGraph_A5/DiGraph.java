package DiGraph_A5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DiGraph implements DiGraph_Interface {

  // in here go all your data and methods for the graph
  // and the topo sort operation

	HashSet<Long> allVertexId;
	HashSet<Long> allEdgeId;
	HashMap<String, Vertex> allVertex;
	
	public DiGraph ( ) { // default constructor
		
		this.allVertex = new HashMap<String, Vertex>();
		this.allVertexId = new HashSet<Long>();
		this.allEdgeId = new HashSet<Long>();
	  
	  // explicitly include this
    // we need to have the default constructor
    // if you then write others, this one will still be there
	}

	@Override
	public boolean addNode(long idNum, String label) {
		
		if((idNum<0)||this.allVertexId.contains(idNum)) {
			return false;
		}		
		if((label==null)||this.allVertex.containsKey(label)) {
			return false;
		}
		
		Vertex V = new Vertex(idNum, label);
		this.allVertex.put(label, V);
		this.allVertexId.add(idNum);
		return true;
	}

	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		
		if((idNum<0)||this.allEdgeId.contains(idNum)) {
			return false;
		}
		
		if((!this.allVertex.containsKey(sLabel))||(!this.allVertex.containsKey(dLabel))) {
			return false;
		}

		Vertex startNode = this.allVertex.get(sLabel);
		Vertex destNode = this.allVertex.get(dLabel);
		if(startNode.outEdges.containsKey(dLabel)&&destNode.inEdges.containsKey(sLabel)) {
			return false;
		}
		
		Edge E = new Edge(idNum, weight, eLabel, destNode, startNode);
		destNode.inEdges.put(sLabel, E);
		destNode.indegree += 1; 
		startNode.outEdges.put(dLabel, E);
		//startNode.outdegree += 1;
		this.allEdgeId.add(idNum);
		return true;
	}
	
	@Override
	public boolean delNode(String label) {
		if(label==null) {
			return false;
		}
		if(!this.allVertex.containsKey(label)) {
			return false;
		}
		
		Vertex V = this.allVertex.get(label);
		for(Edge e: V.inEdges.values()) {
			this.allEdgeId.remove(e.id);
		}
		for(Edge e: V.outEdges.values()) {
			this.allEdgeId.remove(e.id);
		}
		V.inEdges.clear();
		V.outEdges.clear();
		this.allVertex.remove(label);
		this.allVertexId.remove(V.id);
		return true;
	}
	
	@Override
	public boolean delEdge(String sLabel, String dLabel) {
		
		Vertex startNode = this.allVertex.get(sLabel);
		Vertex destNode = this.allVertex.get(dLabel);
		
		if(!this.allVertex.containsKey(sLabel)||!this.allVertex.containsKey(dLabel)) {
			return false;
		}
		if(!startNode.outEdges.containsKey(dLabel)) {
			return false;
		}
		
		Edge E = startNode.outEdges.get(dLabel);
		this.allEdgeId.remove(E.id);
		startNode.outEdges.remove(dLabel, E);
		//startNode.outdegree -= 1;
		destNode.inEdges.remove(sLabel, E);
		destNode.indegree -=1;
		return true;
	}
	
	@Override
	public long numNodes() {
		return this.allVertex.size();
	}
	
	@Override
	public long numEdges() {
		return this.allEdgeId.size();
	}
	
	@Override
	public String[] topoSort() {
		
		if(this.allVertex.isEmpty()) {
			return null;
		}
		
		ArrayList<String> topoL = new ArrayList<String>();
		Queue<Vertex> topoQ = new LinkedList<Vertex>();
		
		for(Vertex V:this.allVertex.values()){
			if(V.indegree==0 && V.marked==false) {
				topoQ.add(V);
				V.marked = true;				
			}
		}
		
		while(!topoQ.isEmpty()) {
			Vertex deqNode = topoQ.poll();
			topoL.add(deqNode.label);
			
			Iterator<Edge> it = deqNode.outEdges.values().iterator();
			while(it.hasNext()) {
				String label = it.next().destNode.label;
				this.allVertex.get(label).indegree -=1;
				if(this.allVertex.get(label).indegree ==0 ) {
					topoQ.add(this.allVertex.get(label));
				}
			}
			
			//System.out.println(topoL.toString());		
		}
		
		int graph_size = this.allVertex.size();		
		int topo_size = topoL.size();
	
		String[] topoF = (String[]) topoL.toArray(new String[graph_size]);
		
		//System.out.println(topoF.toString());
		
		if(topo_size == graph_size) {
			return topoF;
		}else {
			return null;
		}
	}
}