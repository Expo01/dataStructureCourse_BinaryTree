package datastructures.binarysearchtree;


public class BinarySearchTree {

    public Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value); //node created but not part of tree
        if (root == null) { //if tree is empty, new node is the root
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) { //will ultimateley run until its ablee to place the newe node and return true, or return false indicating
            // the value already exists in the tree
            if (newNode.value == temp.value) return false; // handles edge case of newNode value already existing in tree. loop ends.
            if (newNode.value < temp.value) {  //checks it value is less than temp
                if (temp.left == null) { //if is less than temp left pointer null
                    temp.left = newNode; //then newNode added as leaf
                    return true;
                }
                temp = temp.left; // if newNode is less than temp but left pointer of temp is not null (node already
                // exists) then temp reassigned to next node down the tree to the left
            } else { //same concepts except for value that is greater than temp
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

}