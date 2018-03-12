//package hackerrank;
//
//import java.util.*;
//
//public class EvenTreeSolution {
//
//  // structure to graph
//  private static class Node {
//    HashMap<Node, Integer> neighbor;
//    int value;
//
//    Node(int value) {
//      this.value = value;
//    }
//  }
//
//  private static class Tree {
//    Node head;
//    HashMap<Integer, Node> nodes = new HashMap<>();
//
//    Tree(int[][] t) {
//      head = new Node(1);
//      nodes.put(1,head);
//      for (int[] aT : t) {
//        addNode(aT[0], getNode(aT[1]));
//      }
//    }
//
//    void addNode(int value, Node parent) {
//      Node n = new Node(value);
//      parent.child.put(n, 0);
//      nodes.put(value, n);
//    }
//
//    Node getNode(int value) {
//      return nodes.get(value);
//    }
//
//    void calculateSize() {
//      calcAux(head);
//    }
//
//    private int calcAux(Node n) {
//      if (n.child.isEmpty()) {
//        n.size = 1;
//        return 1;
//      }
//
//      n.size = 1;
//      for (Node c : n.child.keySet()) {
//        n.size += calcAux(c);
//      }
//
//      return n.size;
//    }
//
//    void print() {
//      recPrint(head);
//    }
//
//    void recPrint(Node n) {
//      if (n.child.isEmpty()) {
//        System.out.print("(" + n.nodeValue + "," + n.size + ")" + " ");
//        return;
//      }
//
//      System.out.print("(" + n.nodeValue + "," + n.size + ")" + " ");
//      for (Node c : n.child.keySet()) {
//        recPrint(c);
//      }
//    }
//  }
//
//  static int evenTree(int n, int m, int[][] tree) {
//    Tree t = new Tree(tree);
//    t.calculateSize();
//    t.print();
//    return 0;
//  }
//
//  public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    int n = in.nextInt();
//    int m = in.nextInt();
//    int[][] tree = new int[m][2];
//    for (int tree_i = 0; tree_i < m; tree_i++) {
//      for (int tree_j = 0; tree_j < 2; tree_j++) {
//        tree[tree_i][tree_j] = in.nextInt();
//      }
//    }
//    int result = evenTree(n, m, tree);
//    // System.out.println(result);
//    in.close();
//  }
//}
//
////  // brute force solution
////  private static boolean hasEvenConnectedNodes(HashMap<Integer, HashSet<Integer>> tree) {
////    // list of graph nodes
////    Iterator<Integer> it = tree.keySet().iterator();
////
////    // BFS queue
////    ArrayDeque<Integer> nodeQueue = new ArrayDeque<>();
////
////    // already traversed nodes
////    HashSet<Integer> done = new HashSet<Integer>();
////
////    while (it.hasNext()) {
////      int node = it.next();
////      if (!done.contains(node)) {
////        int connectedSetSize = 0;
////        nodeQueue.addFirst(node);
////        while (!nodeQueue.isEmpty()) {
////          int curr = nodeQueue.removeLast();
////          connectedSetSize++;
////          done.add(curr);
////          for (Integer i : tree.get(curr)) {
////            if (!done.contains(i)) {
////              nodeQueue.addFirst(i);
////            }
////          }
////        }
////        if (connectedSetSize % 2 == 1) {
////          return false;
////        }
////      }
////    }
////    return true;
////  }
////
////  private static boolean removeEdge(int node1, int node2, HashMap<Integer, HashSet<Integer>> tree) {
////    if (!tree.containsKey(node1) || !tree.containsKey(node2)) {
////      return false;
////    }
////    if (!tree.get(node1).contains(node2) || !tree.get(node1).contains(node2)) {
////      return false;
////    }
////    tree.get(node1).remove(node2);
////    tree.get(node2).remove(node1);
////    return true;
////  }
////
////  private static boolean addEdge(int node1, int node2, HashMap<Integer, HashSet<Integer>> tree) {
////    if (!tree.containsKey(node1) || !tree.containsKey(node2)) {
////      return false;
////    }
////
////    if (tree.get(node1).contains(node2)) {
////      return false;
////    }
////
////    tree.get(node1).add(node2);
////    tree.get(node2).add(node1);
////    return true;
////  }
////
////
////  static int evenTree(int n, int m, int[][] tree) {
////    if (tree == null || n < 4) {
////      return 0;
////    }
////
////    // map containing all edges
////    ArrayList<Pair<Integer, Integer>> edges = new ArrayList<>();
////
////    // Convert tree into a better structure
////    HashMap<Integer, HashSet<Integer>> newTree = new HashMap<>();
////    for (int i = 0; i < tree.length; i++) {
////      int node1 = tree[i][0];
////      int node2 = tree[i][1];
////      edges.add(new Pair<>(node1, node2));
////      if (!newTree.containsKey(node1)) {
////        newTree.put(node1, new HashSet<>());
////      }
////      if (!newTree.containsKey(node2)) {
////        newTree.put(node2, new HashSet<>());
////      }
////      newTree.get(node1).add(node2);
////      newTree.get(node2).add(node1);
////    }
////
////    if (!hasEvenConnectedNodes(newTree)) {
////      return 0;
////    }
////
////
////    return recEvenTree(edges, newTree, 0);
////  }
////
////  private static int recEvenTree(ArrayList<Pair<Integer, Integer>> edges, HashMap<Integer, HashSet<Integer>> tree, int removedEdges) {
////    if (!hasEvenConnectedNodes(tree) || edges.isEmpty()) {
////      return removedEdges - 1;
////    }
////
////    int result = 0;
////    for (int i = 0; i < edges.size(); i++) {
////      Pair<Integer, Integer> p = edges.remove(i);
////      int node1 = p.getKey();
////      int node2 = p.getValue();
////      removeEdge(node1, node2, tree);
////      result = recEvenTree(edges, tree, removedEdges + 1) > result ? recEvenTree(edges, tree, removedEdges + 1) : result;
////      addEdge(node1, node2, tree);
////      edges.add(i, p);
////    }
////
////    return result;
////  }
