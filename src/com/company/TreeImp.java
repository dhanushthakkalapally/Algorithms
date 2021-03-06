package com.company;

public class TreeImp implements Tree {

    Node rootNode = null;

    /**
     * In binary search tree if the value is greater than the root the value will be inserted in the right sub tree
     * else inserted in the left subtree
     * */

    /**
     * In Binary search tree every node has two left  left child and the right child
     * If a node has both left and right child empty then  it is called leaf node
     */

    @Override
    public boolean insert(Number value) {

        /**
         * While implementing BST consider that at any given point of time there is only single node in the data structure based on the nodes value decide where to insert
         * in the tree
         *Only Unique values are allowed in BST
         * */
//check if root node is equal to null if yes insert in the root node
        if (this.rootNode == null) {
            this.rootNode = new Node(null, null, null, value);
            return true;
        } else if (rootNode != null) {
//             Then the tree is established so we need to parse the tree
//             get the root node and insert

            return insertOne(this.rootNode, value);


        }


        return false;
    }

    private boolean insertOne(Node node, Number value) {

        if (value.floatValue() > node.value.floatValue()) {
            if (node.right == null) {
//                         create a node and attach it here
                Node n = new Node(node, null, null, value);
                node.right = n;
                return true;
            }
            return insertOne(node.right, value);

        } else if (node.value.floatValue() > value.floatValue()) {
            if (node.left == null) {
                Node n = new Node(node, null, null, value);
                node.left = n;
                return true;
            }
            return insertOne(node.left, value);
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(Number value) {
//            if root Node is == null return -1
        if (rootNode == null) {
            return false;

        } else if (rootNode != null) {
            return deleteNode(rootNode, value);
        }


        return false;
    }

    private boolean deleteNode(Node node, Number value) {
        if (node.value == value) {
//             delete the node
//             if the node have no children
            if (node.right == null && node.left == null) {
                if (node.parent.right.value.floatValue() == value.floatValue()) {
                    node.parent.right = null;
                } else {
                    node.parent.left = null;
                }
                return true;
            } else if (node.right == null && node.left != null) {
                node.parent.right = node.left;
                return true;
            } else if (node.right != null) {
                Node min = findMinNode(node.right);
                System.out.println("++++++++++++++++++++"+min.value);
                min.parent = node.parent;

                if (node.parent == null) {
                    this.rootNode = min;
                            return true;
                } else if (node.parent.left.value.floatValue() == node.value.floatValue()) {
                    node.parent.left = min;

                } else {
                    node.parent.right = min;
                }

                return true;
            }


        } else if (value.floatValue() > node.value.floatValue()) {
//             go to the right
            if (node.right != null)
                return deleteNode(node.right, value);
            else
                return false;
        } else if (value.floatValue() < node.value.floatValue()) {
            if (node.left != null)
                return deleteNode(node.left, value);
            else
                return false;


        }

        return false;
    }

    private Node findMinNode(Node node) {
        if (node.left == null) {
            return node;
        } else
            return findMinNode(node.left);


    }

    @Override
    public Number min() {
        if (this.rootNode == null) {
            return null;
        } else {
            return findMin(this.rootNode);
        }
    }

    private Number findMin(Node node) {
//        Traverse all the way down to the leaf from the left and if the if any node has no left leaf then it is the minimum value

        if (node.left == null) {
            return node.value;
        } else {
            return findMin(node.left);

        }

    }

    @Override
    public Number max() {

        if (this.rootNode == null) {
            return null;
        } else {
            return findMax(rootNode);
        }

    }

    private Number findMax(Node node) {

        if (node.right != null) {
            return findMax(node.right);
        } else
            return node.value;

    }


}
