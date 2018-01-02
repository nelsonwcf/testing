package custom.structures;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class UnweightedGraph<T> {
  int numberOfVertices;
  int numberOfEdges;
  boolean isDirected;
  HashMap<T, LinkedList<T>> adjacencyMap;
  HashMap<T, Integer> verticeOutDegree;

  public UnweightedGraph(boolean isDirected) {
    numberOfVertices = 0;
    numberOfEdges = 0;
    this.isDirected = isDirected;
    adjacencyMap = new HashMap<>();
    verticeOutDegree = new HashMap<>();
  }

  public boolean addVertex(T vertex) {
    if (adjacencyMap.containsKey(vertex)) {
      return false;
    }

    adjacencyMap.put(vertex, new LinkedList<T>());
    verticeOutDegree.put(vertex, 0);
    numberOfVertices++;
    return true;
  }

  public boolean addEdge(T vertexOfOrigin, T vertexOfDestination) {
    if (!adjacencyMap.containsKey(vertexOfOrigin)) {
      addVertex(vertexOfOrigin);
    }

    if (!adjacencyMap.containsKey(vertexOfDestination)) {
      addVertex(vertexOfDestination);
    }

    adjacencyMap.get(vertexOfOrigin).add(vertexOfDestination);
    verticeOutDegree.put(vertexOfOrigin, verticeOutDegree.get(vertexOfOrigin) + 1);
    numberOfEdges++;

    if (!isDirected) {
      adjacencyMap.get(vertexOfDestination).add(vertexOfOrigin);
      verticeOutDegree.put(vertexOfDestination, verticeOutDegree.get(vertexOfDestination) + 1);
      numberOfEdges++;
    }

    return true;
  }

  void showGraph() {
    for (T v : adjacencyMap.keySet()) {
      System.out.println(v + ":" + adjacencyMap.get(v).toString());

    }
  }

  boolean bfs(T vertex) {
    HashSet<T> processed;
    ArrayDeque<T> discovered;
    HashMap<T, Integer> distance;
    int currentDistance;

    if (!adjacencyMap.containsKey(vertex)) {
      return false;
    }

    // Initialize BFS
    processed = new HashSet<>();
    discovered = new ArrayDeque<>();
    distance = new HashMap<>();
    currentDistance = 0;

    // Addfirst Vertex to the queue
    processed.add(vertex);
    discovered.addFirst(vertex);
    distance.put(vertex, currentDistance);

    // Remove vertex, check all neighbors not in the set yet and add those to the queue
    while (!discovered.isEmpty()) {
      T current = discovered.removeLast();
      currentDistance = distance.get(current);
      for (T neighbor : adjacencyMap.get(current)) {
        if (!processed.contains(neighbor)) {
          discovered.addFirst(neighbor);
          processed.add(neighbor);
          distance.put(neighbor, currentDistance + 1);
        }
      }
    }

    // Takes care of graph nodes that are disconnected from vertex
    for (T disjointedNode : adjacencyMap.keySet()) {
      if (!processed.contains(disjointedNode)) {
        processed.add(disjointedNode);
        distance.put(disjointedNode, -1);
      }
    }
    for (T obj : distance.keySet()) {
      System.out.println(obj + ":" + distance.get(obj));
    }
    return true;
  }

  void dfs(T vertex) {
    HashSet<T> memory = new HashSet<>();

    dfs(vertex, memory, 0);
    for (T disjointedNode : adjacencyMap.keySet()) {
      if (!memory.contains(disjointedNode)) {
        memory.add(disjointedNode);
        System.out.print(disjointedNode + ":" + (-1) + " ");
      }
    }
  }

  private void dfs(T vertex, HashSet<T> processed, int distance) {
    if (!processed.contains(vertex)) {
      System.out.print(vertex + ":" + distance + " ");
      processed.add(vertex);
      for (T v : adjacencyMap.get(vertex)) {
        dfs(v, processed, distance + 1);
      }
    }
  }

  public static void main(String[] args) {
    UnweightedGraph<String> g = new UnweightedGraph<>(false);
    g.addEdge("A", "B");
    g.addEdge("A", "C");
    g.addEdge("A", "D");
    g.addEdge("B", "E");
    g.addEdge("D", "F");
    g.addEdge("D", "G");
    g.addEdge("G", "H");
    g.addVertex("X");
    g.dfs("A");
  }
}

