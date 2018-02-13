package pramp;

class CheapestCostSolution {

    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }

    static class SalesPath {

        static int getCheapestCost(Node rootNode) {
            int minimumCost = Integer.MAX_VALUE, aux;

            if (rootNode.children == null || rootNode.children.length == 0) {
                return rootNode.cost;
            } else {
                for (int i = 0; i < rootNode.children.length; i++) {
                    aux = getCheapestCost(rootNode.children[i]);
                    if (minimumCost > aux)
                        minimumCost = aux;
                }
                return rootNode.cost + minimumCost;
            }
        }
    }

    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {
        Node root = new Node(0);
        root.children = new Node[3];
        root.children[0] = new Node(5);
        root.children[1] = new Node(3);
        root.children[2] = new Node(6);
        Node s = root.children[0];
        s.children = new Node[1];
        s.children[0] = new Node(4);
        s = root.children[1];
        s.children = new Node[2];
        s.children[0] = new Node(2);
        s.children[1] = new Node(10);


        System.out.println(SalesPath.getCheapestCost(root));
    }
}