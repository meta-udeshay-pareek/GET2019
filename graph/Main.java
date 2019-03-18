package graph;

import java.util.List;

//Temporary main class to test on console
public class Main {
	public static void main(String args[]){
		GraphImplementaion graph = new GraphImplementaion(4);
		
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(2, 3, 4);

//		graph.printGraph();

		System.out.println(graph.isConnected());
		
		Integer i[] = graph.reachable(0);
		for(Integer x : i){
			System.out.println(x);
		}
//
//		List<Integer> listOfReachable = graph.reachable(3);
//		System.out.println(listOfReachable.toString());
//
//		List<Edge> mst = graph.minimumSpanningTree();
//
//		mst.forEach(mstList -> System.out.println(" Source: "
//				+ mstList.getVertex1() + " Destination: "
//				+ mstList.getVertex2() + " Weight: " + mstList.getWeight()));
//
//
//		List<Edge> spt = graph.shortestPath(0, 2);
//
//		spt.forEach(sptList -> System.out.println(" Source : "
//				+ sptList.getVertex1() + " Destination : "
//				+ sptList.getVertex2() + " Distance : " + sptList.getWeight()));

	}
}
