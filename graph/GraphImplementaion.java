package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class GraphImplementaion implements Graph {

	/*** Property of graph****/

	//number of vertices in graph
	private int numberOfVertices;
	
	private Vertex vertices[];

	//adjacency list of graph 
	private LinkedList<Edge> edgeList;

	/************************/


	/****Getter Setter start *****/
	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	public void setNumberOfVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}

	public LinkedList<Edge> getEdgeList() {
		return edgeList;
	}

	/*****Getter Setter End*********/


	/**
	 * Constructor
	 * @param numberOfVertices, number of nodes in graph
	 * */
	public GraphImplementaion(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		vertices = new Vertex[numberOfVertices];
		edgeList = new LinkedList<Edge>();
		
		//assigning object to array pf refference 
		for(int i=0;i<numberOfVertices;i++)
			vertices[i]=new Vertex();
	}


	/***Global variable using in methods**/ 

	// edge class to add edges with weight or distance in the list
	private Edge edge;


	/***********************************/




	/**
	 * Function to add edges in graph in case of weighted undirected graph
	 * 
	 * @param source
	 * @param destination
	 * @param weight
	 */

	public void addEdge(int source, int destination,int weight) {
		edgeList.add(new Edge(source, destination, weight));//making a new edge object for adding in list
		this.vertices[source].addNeighbour(destination, weight);//destination is neighbour of source
		this.vertices[destination].addNeighbour(source, weight);//source is neighbour of destination
	}

	/**
	 * @param this graph
	 * @return 'true' if all the vertices have visited in dfs traversal else 'false'
	 * */
	@Override
	public boolean isConnected() {
		
		if(this.numberOfVertices<=0)
			return false;
		//if all the vertices has visited then only graph will be connected
		return this.dfs(0).size() == this.getNumberOfVertices();
		
	}
	
	/**
	 * private helper method for traversing graph in dfs manner
	 * @param source, the source vertex of the graph 
	 * @return visitedVertex,set of visited vertex
	 * */
	private Set<Integer> dfs(int source){
		
		Stack<Integer> dfsStack = new Stack<Integer>();//stack for dfs traversal
		Set<Integer> visitedVertex = new HashSet();//set for storing/marking visited vertex
		dfsStack.push(source);	//pushing first source vertex in dfsStack
		
		while (!dfsStack.isEmpty()) {
			int vertex = dfsStack.pop();
			//if vertex is already visited then move further
			if(visitedVertex.contains(vertex)) {
				continue;
			}

			visitedVertex.add(vertex);//adding vertex in visited list
			//pushing it's all neighbour in stack
			for(Neighbour neighbour : this.vertices[vertex].getNeighbourList()) {
				
				dfsStack.push(neighbour.getNeighbourVertex());
			}
		}
		
		return visitedVertex;
	}

	
	/**
	 * @param vertex
	 * @return reachableNode,an array of Integer
	 * */
	@Override
	public Integer[] reachable(int vertex) {
		Set<Integer> visitedVertex = this.dfs(vertex);
		Integer[] reachableNode = visitedVertex.toArray(new Integer[0]);//converting set into Integer type array
		Arrays.sort(reachableNode);//sorting array
		
		return reachableNode;//returning 
	}
	
	

	/**
	 * @param this graph
	 * @return minimumSpanningTreeEdges, list of edges in minimum spanning tree
	 * */
	@Override
	public List<Edge> minimumSpanningTree() {
		
		
		List<Edge> minimumSpanningTreeEdges = new ArrayList<Edge>();
		
		//sorting edgeList based on weight in ascending order
		Collections.sort(this.edgeList, Edge.sortByWeight);
		
		//hash map for storing the parent node of a vertex key-> vertex value->parent of vertex 
		HashMap<Integer, Integer> parentVertices = new HashMap<Integer, Integer>();
		
		//Initially every vertex is parent of itself 
		for(int i=0;i<this.numberOfVertices;i++) {
			parentVertices.put(i, i);
		}
		
		int index = 0;
		
		for(Edge edge : this.getEdgeList()) {
			//if limits crosses then break the loop
			if(index>this.getNumberOfVertices()-1)
			{
				break;
			}
			else if(!isCycle(parentVertices,edge.getVertex1(),edge.getVertex2())) {
				minimumSpanningTreeEdges.add(edge);//if this edge is not creating cycle then add this in minimun spannig tree
			}
		}
		return minimumSpanningTreeEdges;
	}
	
	/**
	 *  private Helper method
	 * @param parentVertices,hashMap which contain key as vertex number and value as their parent
	 * @param v1,vertex one
	 * @param v2, vertex second
	 * @return "true" if this edge creating cycle else "false"
	 * */
	private boolean isCycle(HashMap<Integer, Integer> parentVertices,int v1,int v2) {
		int parent1 = parent(parentVertices,v1);//calling parent Method for getting parent of the vertex
		int parent2 = parent(parentVertices,v2);//calling parent Method for getting parent of the vertex
		
		//if both vertices has same parent then this edge will create cycle in graph
		if(parent1 == parent2) {
			return true;//cycle exist
		}
		
		//else parent are not same so make parent1(source vertex of edge) as a parent of parent2(destination vertex of edge) 
		parentVertices.put(parent1, parent2);
		return false;
	}
	
	/**
	 * private Helper method
	 * @param parentVertices,hashMap which contain key as vertex number and value as their parent
	 * @param vertex, of which vertex this method is finding parent
	 * @return parent,parent of the given vertex
	 * */
	private int parent(HashMap<Integer, Integer> parentVertices,int vertex) {
		int parent = vertex;//as initially we set vertex is parent of itself in hashMap
		
		//if entry contain diferent parent for the vertex
		while(parentVertices.get(vertex)!=parent) {
			
			parent = parentVertices.get(vertex);//fetch the parent then in next cycle condition will false 
		}
		
		return parent;
	}

	@Override
	public List<Edge> shortestPath(int vertex1, int vertex2) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
