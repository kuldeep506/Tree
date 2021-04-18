public class BST {
    public Node root;

    public BST() {
        this.root = null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            root = node;
        } else {
            Node temp = root;
            Node current = null;
            while (temp != null) {
                current = temp;
                if (value <= temp.data) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
            if (value <= current.data) {
                current.left = node;
            } else {
                current.right = node;
            }
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

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

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.println(node.data);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal() {
        preOrderTraversal(root);
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

    public boolean search(int value) {
        if (isEmpty()) {
            System.out.println("empty");
        }
        Node temp = root;
        while (temp != null) {
            if (value > temp.data) {
                temp = temp.right;
            } else if (value < temp.data) {
                temp = temp.left;
            } else {
                return true;
            }
        }
        return false;
    }

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
}
