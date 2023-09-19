package com.algo.lab13.solution;

import java.util.*;

//implement
public class BreadthFirstSearch {
    protected HashMap<Vertex, Vertex> visitedVertices = new HashMap<>();
    protected HashMap<Vertex, Integer> levelVertices = new HashMap<>();
    protected int numVertices;
    protected int numEdges;
    protected int verticesLevel;
    Graph graph;
    Queue<Vertex> queue;
    List<Vertex> vertices = null;
    Iterator<Vertex> iterator = null;
    List<Edge> edges = null;
    List<Edge> edgesVisitedDuringDFS = new ArrayList<>();
    public BreadthFirstSearch(Graph graph) {
        queue = new LinkedList<Vertex>();
        this.graph = graph;
        vertices = graph.vertices;
        iterator = vertices.iterator();
        edges = graph.edges;
        numVertices = vertices.size();
        numEdges = edges.size();
        verticesLevel = 0;
    }

    protected boolean someVertexUnvisited() {
        return visitedVertices.size() < numVertices;
    }
    protected void handleInitialVertex() {
        Vertex v = nextUnvisited();
        if(v != null) {
            setHasBeenVisited(v);
            setVerticesLevel(v, 0);
            processVertex(v);
            queue.add(v);
        }
    }
    public Vertex nextUnvisited() {
        while (iterator.hasNext()) {
            Vertex next = iterator.next();
            if(!visitedVertices.containsKey(next)) {
                return next;
            }
        }
        return null;
    }
    protected void processVertex(Vertex w) {}
    protected void checkCycle(Vertex w, int level) {}
    public boolean getHasBeenVisited(Vertex v) {
        return visitedVertices.containsKey(v);
    }
    public void setHasBeenVisited(Vertex v) {
        visitedVertices.put(v, v);
    }
    public int getVerticesLevel(Vertex v) {
        return (int) levelVertices.get(v);
    }
    public void setVerticesLevel(Vertex v, int level) {
        levelVertices.put(v, level);
    }
    protected void singleComponentLoop() {
        Vertex s = queue.peek();
        while (!queue.isEmpty()) {
            Vertex v = queue.remove();
            int parentLevel = getVerticesLevel(v);
            List<Vertex> childs = graph.getListOfAdjacentVerts(v);
            for (Vertex child :childs) {
                if(!getHasBeenVisited(child)) {
                    setHasBeenVisited(child);
                    setVerticesLevel(child, parentLevel + 1);
                } else {
                    checkCycle(child, parentLevel);
                }
            }
        }
    }
    protected void additionalProcessing(){}
    public void start() {
        while (someVertexUnvisited()) {
            handleInitialVertex();
            singleComponentLoop();
            additionalProcessing();
        }
    }

}
