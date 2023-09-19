import java.util.ArrayList;
import java.util.List;

//implement
public class ConnectedComponentSearch extends DepthFirstSearch {
	List<Graph> connectedComponents;
	ArrayList<Edge> connectedEdges = new ArrayList<>();
	public ConnectedComponentSearch(Graph graph) {
		super(graph);
		connectedComponents = new ArrayList<>();
	}
	public List<Graph> getConnectedComponents() {
		start();
		return connectedComponents;
	}

	@Override
	protected void additionalProcessing() {
		connectedComponents.add(new Graph(connectedEdges.toArray(new Edge[connectedEdges.size()])));
	}
	protected void processEdge(Edge e) {
		connectedEdges.add(e);
	}
}
