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

  public boolean addVertix(T vertix) {
    if (adjacencyMap.containsKey(vertix)) {
      return false;
    }

    adjacencyMap.put(vertix, new LinkedList<T>());
    verticeOutDegree.put(vertix, 0);
    numberOfVertices++;
    return true;
  }

  public boolean addEdge(T vertixOfOrigin, T vertixOfDestination) {
    if (!adjacencyMap.containsKey(vertixOfOrigin)) {
      addVertix(vertixOfOrigin);
    }

    if (!adjacencyMap.containsKey(vertixOfDestination)) {
      addVertix(vertixOfDestination);
    }

    adjacencyMap.get(vertixOfOrigin).add(vertixOfDestination);
    verticeOutDegree.put(vertixOfOrigin, verticeOutDegree.get(vertixOfOrigin) + 1);
    numberOfEdges++;

    if (!isDirected) {
      adjacencyMap.get(vertixOfDestination).add(vertixOfOrigin);
      verticeOutDegree.put(vertixOfDestination, verticeOutDegree.get(vertixOfDestination) + 1);
      numberOfEdges++;
    }

    return true;
  }

  void showGraph() {
    for (T v : adjacencyMap.keySet()) {
      System.out.println(v + ":" + adjacencyMap.get(v).toString());

    }
  }

  boolean bfs(T vertix) {
    HashSet<T> processed;
    ArrayDeque<T> discovered;
    HashMap<T, Integer> distance;
    int currentDistance;

    if (!adjacencyMap.containsKey(vertix)) {
      return false;
    }

    // Initialize BFS
    processed = new HashSet<>();
    discovered = new ArrayDeque<>();
    distance = new HashMap<>();
    currentDistance = 0;

    // Addfirst Vertix to the queue
    processed.add(vertix);
    discovered.addFirst(vertix);
    distance.put(vertix, currentDistance);

    // Remove vertix, check all neighbors not in the set yet and add those to the queue
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

    // Takes care of graph nodes that are disconnected from vertix
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

  public static void main(String[] args) {
    UnweightedGraph<String> g = new UnweightedGraph<>(false);
    g.addVertix("A");
    g.addVertix("B");
    g.addEdge("B","D");
    g.addVertix("C");
    g.addEdge("A","C");
    g.bfs("A");
  }
}

