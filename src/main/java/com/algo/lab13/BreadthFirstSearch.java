package com.algo.lab13;

import java.util.*;

//implement
public class BreadthFirstSearch {
    private Map<Vertex, Vertex> visitedVertices = new HashMap<>();
    private Map<Vertex, Integer> levelVertices = new HashMap<>();
    private Graph graph;
    private Queue<Vertex> queue;
    private List<Vertex> vertices;
    private Iterator<Vertex> iterator;
    private List<Edge> edges;
    private List<Edge> visitedEdgesInDFS = new ArrayList<>();
    private int numVertices;
    private int numEdges;
    private int verticesLevel;

    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
        this.queue = new LinkedList<>();
        this.edges = graph.edges;
        this.numEdges = edges.size();
        this.vertices = graph.vertices;
        this.iterator = vertices.iterator();
        this.numVertices = vertices.size();
        this.verticesLevel = 0;
    }

    public void start() {
        while (this.isVertexUnvisited()) {
            this.initialVertex();
            this.singleComponentLoop();
            this.additionalProcessing();
        }
    }

    private boolean isVertexUnvisited() {
        return visitedVertices.size() < numVertices;
    }

    private void initialVertex() {
        Vertex v = this.getNextVertex();
        if (v != null) {
            this.updateVisitedVertices(v);
            this.updateVerticesLevel(v, 0);
            this.processVertex(v);
            queue.add(v);
        }
    }

    private Vertex getNextVertex() {
        while (iterator.hasNext()) {
            Vertex next = iterator.next();
            if (!visitedVertices.containsKey(next)) {
                return next;
            }
        }
        return null;
    }

    private void updateVisitedVertices(Vertex v) {
        visitedVertices.put(v, v);
    }

    private boolean isVisitedVertices(Vertex v) {
        return visitedVertices.containsKey(v);
    }

    private void updateVerticesLevel(Vertex v, int level) {
        levelVertices.put(v, level);
    }

    protected int getVerticesLevel(Vertex v) {
        return levelVertices.getOrDefault(v, 0);
    }

    private void singleComponentLoop() {
        while (!queue.isEmpty()) {
            Vertex v = queue.remove();
            int parentLevel = this.getVerticesLevel(v);
            List<Vertex> childList = graph.getListOfAdjacentVerts(v);

            for (Vertex child : childList) {
                if (!this.isVisitedVertices(child)) {
                    this.updateVisitedVertices(child);
                    this.updateVerticesLevel(child, parentLevel + 1);
                } else {
                    checkCycle(child, parentLevel);
                }
            }
        }
    }

    protected void processVertex(Vertex w) {
        // Should be implemented in the child class
    }

    protected void checkCycle(Vertex v, int level) {
        // Should be implemented in the child class
    }

    protected void additionalProcessing() {
        // Should be implemented in the child class
    }
}
