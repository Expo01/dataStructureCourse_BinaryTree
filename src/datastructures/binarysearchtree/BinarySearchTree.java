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
    } // contains a while loop, but it does not iterate through linearly, so
    // insert should bee O(log n)

    public boolean contains(int value) {
//        if (root == null) return false; // this line is unneccessary although some may like it for readability but
        // it accounts for the tree being empty
        Node temp = root; //
        while (temp != null) { // since temp = root, we can also handle the empty tree scenario where the while loop
            // never runs and returns false.
            // for non-empty trees, the while loop will exit if the searched value does not exist
            if (value < temp.value) {
                temp = temp.left; //root pointer remains at first node and temp reassigned to next node to the left down
                // the tree OR to null if the temp is already on the last node (temp is a leaf)
            } else if (value > temp.value) {
                temp = temp.right; // same thing but to the right
            } else {
                return true; // if the 'value' is not less or greater than 'temp' it must equal temp and will return true
                //  UNLESS temp was reassigned to null in which case the loop would not have run and would have gone
                // straight to returning false
            }
        }
        return false;
    } // also contains while loop but used to traverse tree so also O(log n)

}