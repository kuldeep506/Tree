public class BST {
    public Node root;

    public BST() {
        this.root = null;
    }


    /**
     * //method to insert a node in binary search tree.
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        Node newNode = new Node(data);
        if (node == null) {
            return newNode;
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    /**
     * inorder traversal
     */
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        } else {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }

    /**
     * prOrder traversal
     */
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    public void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.println(node.data);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    /**
     * postOrder traversal
     */
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        } else {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.data);
        }
    }

    /**
     * method to calculate height of tree
     * * @return int height
     */
    public int heightOfTree() {
        return heightOfTree(root);
    }

    private int heightOfTree(Node node) {
        if (node.right == null && root.left == null) {
            return 0;
        }
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(heightOfTree(node.left), heightOfTree(node.right));
    }

    public Node minNode() {
        return minNode(root);
    }

    /**
     * method to return node having minimum value
     *
     * @param root
     * @return node
     */
    private Node minNode(Node root) {
        if (root.left != null) {
            return minNode(root.left);
        } else
            return root;
    }

    /**
     * method to delete a node from binary tree.
     *
     * @param value
     */
    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    private Node deleteNode(Node node, int value) {
        if (node == null) {
            return null;
        }

        //if value is less then given node then search the value in left subtree.
        if (value < node.data) {
            node.left = deleteNode(node.left, value);

            //if value is greater then given node then search the value in right subtree.
        } else if (value > node.data) {
            node.right = deleteNode(node.right, value);

            //if value is equal to node's data that is we have found node to be deleted.
        } else {

            //if node to be deleted has no child set node to null.
            if (node.right == null && node.left == null) {
                return null;

                //if node to be deleted has single child(right child).
            } else if (node.left == null) {
                node = node.right;

                //if node to be deleted has single child(lest child).
            } else if (node.right == null) {
                node = node.left;

                // if node is to deleted has two child.
            } else {

                //find minimum node from right subtree.
                Node temp = minNode(node.right);

                // assign node to that right subtree's minimum node.
                node.data = temp.data;

                //delete duplicate node from right subtree.
                node.right = deleteNode(node.right, value);
            }

        }
        return node;

    }
}

