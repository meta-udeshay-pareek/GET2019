package graph;

import java.util.List;

public interface Graph {

	boolean isConnected();
	Integer[] reachable(int node);
	List<Edge> minimumSpanningTree();
	List<Edge> shortestPath(int vertex1, int vertex2);
}
