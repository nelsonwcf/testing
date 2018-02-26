package hackerrank;

import javafx.util.Pair;

import java.util.*;

public class EvenTreeSolution {

//  private static boolean hasEvenConnectedNodes(HashMap<Integer, HashSet<Integer>> tree) {
//    // list of graph nodes
//    Iterator<Integer> it = tree.keySet().iterator();
//
//    // BFS queue
//    ArrayDeque<Integer> nodeQueue = new ArrayDeque<>();
//
//    // already traversed nodes
//    HashSet<Integer> done = new HashSet<Integer>();
//
//    while (it.hasNext()) {
//      int node = it.next();
//      if (!done.contains(node)) {
//        int connectedSetSize = 0;
//        nodeQueue.addFirst(node);
//        while (!nodeQueue.isEmpty()) {
//          int curr = nodeQueue.removeLast();
//          connectedSetSize++;
//          done.add(curr);
//          for (Integer i : tree.get(curr)) {
//            if (!done.contains(i)) {
//              nodeQueue.addFirst(i);
//            }
//          }
//        }
//        if (connectedSetSize % 2 == 1) {
//          return false;
//        }
//      }
//    }
//    return true;
//  }
//
//  private static boolean removeEdge(int node1, int node2, HashMap<Integer, HashSet<Integer>> tree) {
//    if (!tree.containsKey(node1) || !tree.containsKey(node2)) {
//      return false;
//    }
//    if (!tree.get(node1).contains(node2) || !tree.get(node1).contains(node2)) {
//      return false;
//    }
//    tree.get(node1).remove(node2);
//    tree.get(node2).remove(node1);
//    return true;
//  }
//
//  private static boolean addEdge(int node1, int node2, HashMap<Integer, HashSet<Integer>> tree) {
//    if (!tree.containsKey(node1) || !tree.containsKey(node2)) {
//      return false;
//    }
//
//    if (tree.get(node1).contains(node2)) {
//      return false;
//    }
//
//    tree.get(node1).add(node2);
//    tree.get(node2).add(node1);
//    return true;
//  }
//
//
//  static int evenTree(int n, int m, int[][] tree) {
//    if (tree == null || n < 4) {
//      return 0;
//    }
//
//    // map containing all edges
//    ArrayList<Pair<Integer, Integer>> edges = new ArrayList<>();
//
//    // Convert tree into a better structure
//    HashMap<Integer, HashSet<Integer>> newTree = new HashMap<>();
//    for (int i = 0; i < tree.length; i++) {
//      int node1 = tree[i][0];
//      int node2 = tree[i][1];
//      edges.add(new Pair<>(node1, node2));
//      if (!newTree.containsKey(node1)) {
//        newTree.put(node1, new HashSet<>());
//      }
//      if (!newTree.containsKey(node2)) {
//        newTree.put(node2, new HashSet<>());
//      }
//      newTree.get(node1).add(node2);
//      newTree.get(node2).add(node1);
//    }
//
//    if (!hasEvenConnectedNodes(newTree)) {
//      return 0;
//    }
//
//
//    return recEvenTree(edges, newTree, 0);
//  }
//
//  private static int recEvenTree(ArrayList<Pair<Integer, Integer>> edges, HashMap<Integer, HashSet<Integer>> tree, int removedEdges) {
//    if (!hasEvenConnectedNodes(tree) || edges.isEmpty()) {
//      return removedEdges - 1;
//    }
//
//    int result = 0;
//    for (int i = 0; i < edges.size(); i++) {
//      Pair<Integer, Integer> p = edges.remove(i);
//      int node1 = p.getKey();
//      int node2 = p.getValue();
//      removeEdge(node1, node2, tree);
//      result = recEvenTree(edges, tree, removedEdges + 1) > result ? recEvenTree(edges, tree, removedEdges + 1) : result;
//      addEdge(node1, node2, tree);
//      edges.add(i, p);
//    }
//
//    return result;
//  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] tree = new int[m][2];
    for (int tree_i = 0; tree_i < m; tree_i++) {
      for (int tree_j = 0; tree_j < 2; tree_j++) {
        tree[tree_i][tree_j] = in.nextInt();
      }
    }
    int result = 0;
    System.out.println(result);
    in.close();
  }
}
