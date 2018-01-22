package careercup;

// it may need some revisions later
// code works but got too complex
// it may be simplified
public class KthOrderTraversalSolution {
  static class TreeNode {
    int val;
    int NumberOfchildren;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, int children) {
      this.val = val;
      NumberOfchildren = children;
    }
  }

  static TreeNode root = null;

  static TreeNode getKthElement(int pos) {
    TreeNode aux = root;
    int carry = 0;
    int currentPosition = root.left != null ? root.left.NumberOfchildren + 2 : 1;

    while (currentPosition != pos && aux != null) {
      if (currentPosition < pos && aux.right != null) {
        aux = aux.right;
        carry = currentPosition;
        currentPosition = aux.left != null ? carry + aux.left.NumberOfchildren + 2 : carry + 1;
      } else if (currentPosition > pos && aux.left != null) {
        aux = aux.left;
        currentPosition = aux.left != null ? carry + aux.left.NumberOfchildren + 2 : carry + 1;
      } else {
        return null;
      }
    }
    if (aux == null) {
      return null;
    }
    return aux;
  }

  static boolean insertAtKtPosition(TreeNode n, int pos) {
    if (root == null) {
      root = n;
    }

    // traverse the tree incrementing the number of children of each node until reaching the element
    TreeNode aux = root;
    TreeNode parent = null;
    int carry = 0;
    int currentPosition = root.left != null ? root.left.NumberOfchildren + 2 : 1;
    while (currentPosition != pos && aux != null) {
      if (currentPosition < pos && aux.right != null) {
        parent = aux;
        parent.NumberOfchildren++;
        aux = aux.right;
        carry = currentPosition;
        currentPosition = aux.left != null ? carry + aux.left.NumberOfchildren + 2 : carry + 1;
      } else if (currentPosition > pos && aux.left != null) {
        parent = aux;
        parent.NumberOfchildren++;
        aux = aux.left;
        currentPosition = aux.left != null ? carry + aux.left.NumberOfchildren + 2 : carry + 1;
      }
      else {
        aux.right = null;
        parent = aux;
        parent.NumberOfchildren++;
        aux = aux.right;
        break;
      }
    }

    if (aux == null) {
      parent.right = n;
      return true;
    }

    if (parent.right == aux) {
      n.NumberOfchildren = aux.NumberOfchildren + 1;
      n.left = aux.left;
      aux.left = null;
      n.right = aux;
      parent.right = n;
      return true;
  }

    if (parent.left == aux) {
      n.NumberOfchildren = aux.NumberOfchildren + 1;
      n.left = aux.left;
      aux.left = null;
      n.right = aux;
      parent.left = n;
      return true;
    }

    return false;
  }

  public static void buildTree() {
    root = new TreeNode(10, 8);
    root.left = new TreeNode(9, 2);

    TreeNode t = root;
    t = t.left;
    t.left = new TreeNode(5, 1);
    t = t.left;
    t.right = new TreeNode(8, 0);

    t = root;
    root.right = new TreeNode(15, 4);
    t = t.right;
    t.left = new TreeNode(12, 3);
    t = t.left;
    t.left = new TreeNode(11, 0);
    t.right = new TreeNode(14, 1);
    t = t.right;
    t.left = new TreeNode(13, 0);
  }

  public static void inOrderPrint() {
    TreeNode aux = root;
    iP(aux);
  }

  private static void iP(TreeNode n) {
    if (n == null) {
      return;
    }

    iP(n.left);
    System.out.print(n.val + " ");
    iP(n.right);
  }

  public static void main(String[] args) {
    buildTree();
    insertAtKtPosition(new TreeNode(19, 0), 13);
    inOrderPrint();
  }
}