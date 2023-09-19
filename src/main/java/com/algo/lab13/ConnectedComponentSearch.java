package com.algo.lab13;

import java.util.ArrayList;
import java.util.List;

//implement
public class ConnectedComponentSearch extends DepthFirstSearch {
	private List<Graph> connectedComponnents = new ArrayList<>();
	private List<Edge> connectedEdges = new ArrayList<>();

	public ConnectedComponentSearch(Graph graph) {
		super(graph);
	}

	public List<Graph> getConnectedComponents() {
		this.start();
		return connectedComponnents;
	}

	@Override
	protected void additionalProcessing() {
		connectedComponnents.add(new Graph(connectedEdges.toArray(new Edge[connectedEdges.size()])));
	}

	protected void processEdge(Edge e) {
		connectedEdges.add(e);
	}
}
