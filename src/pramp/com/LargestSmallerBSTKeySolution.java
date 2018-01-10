package pramp.com;

import java.io.*;
import java.util.*;

/***********************************************************
 * CODE INSTRUCTIONS:                                      *
 * 1) The method findLargestSmallerKey you're              *
 *    asked to implement is located at line 36.            *
 * 2) Use the helper code below to implement it.           *
 * 3) In a nutshell, the helper code allows you to         *
 *    to build a Binary Search Tree.                       *
 * 4) Jump to line 82 to see an example for how the        *
 *    helper code is used to test findLargestSmallerKey.   *
 ***********************************************************/


class LargestSmallerBSTKeySolution {

  static class Node {
    int key;
    Node left;
    Node right;
    Node parent;

    Node(int key) {
      this.key = key;
      left = null;
      right = null;
      parent = null;
    }
  }

  static class BinarySearchTree {
    Node root;

    // Provided solution
    int findLargestSmallerKey(int num) {
      int result = -1;
      Node aux = root;

      while (aux != null) {
        if (aux.key < num) {
          result = aux.key;
          aux = aux.right;
        }
        else {
          aux = aux.left;
        }
      }
      return result;
    }

      // My solution after failing the exercise
//    int findLargestSmallerKey(int num) {
//      if (root == null) {
//        return -1;
//      }
//      // Locate the position of the key
//      Node aux = root;
//
//      while (true) {
//        if (num == aux.key) {
//          break;
//        } else if (num < aux.key) {
//          if (aux.left != null) {
//            aux = aux.left;
//          } else {
//            break;
//          }
//        } else {
//          if (aux.right != null) {
//            aux = aux.right;
//          } else {
//            break;
//          }
//        }
//      }
//
//      // If num is greater than current node, return this node
//      if (num > aux.key) {
//        return aux.key;
//      }
//
//      // If the num is the node and left node is not null
//      // return the rightmost element from the left node
//      if (num == aux.key && aux.left != null) {
//        aux = aux.left;
//        while (aux.right != null) {
//          aux = aux.right;
//        }
//        return aux.key;
//      }
//
//      // If num is smaller than current node, return first parent smaller than it
//      while (aux != null && aux.key >= num) {
//        aux = aux.parent;
//      }
//      if (aux != null) {
//        return aux.key;
//      } else {
//        return -1;
//      }
//    }

    //  inserts a new node with the given number in the
    //  correct place in the tree
    void insert(int key) {

      // 1) If the tree is empty, create the root
      if (this.root == null) {
        this.root = new Node(key);
        return;
      }

      // 2) Otherwise, create a node with the key
      //    and traverse down the tree to find where to
      //    to insert the new node
      Node currentNode = this.root;
      Node newNode = new Node(key);

      while (currentNode != null) {
        if (key < currentNode.key) {
          if (currentNode.left == null) {
            currentNode.left = newNode;
            newNode.parent = currentNode;
            break;
          } else {
            currentNode = currentNode.left;
          }
        } else {
          if (currentNode.right == null) {
            currentNode.right = newNode;
            newNode.parent = currentNode;
            break;
          } else {
            currentNode = currentNode.right;
          }
        }
      }
    }
  }

  /*********************************************
   * Driver program to test above function     *
   *********************************************/

  public static void main(String[] args) {

    // Create a Binary Search Tree
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(20);
    bst.insert(9);
    bst.insert(25);
    bst.insert(5);
    bst.insert(12);
    bst.insert(11);
    bst.insert(14);

    int result = bst.findLargestSmallerKey(21);
    System.out.println("Largest smaller number is " + result);

  }
}