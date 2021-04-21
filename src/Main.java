import sun.reflect.generics.tree.Tree;

public class Main {
    public static void main(String[] args) {
        BST obj =new BST();
        obj.insert(6);
        obj.insert(10);
        obj.insert(2);
        obj.insert(14);
        obj.insert(1);
        obj.insert(45);
        obj.insert(1);
        obj.insert(0);
        obj.insert(22);
        obj.insert(11);
        obj.deleteNode(45);
        obj.deleteNode(6);

        obj.preOrderTraversal();

    }
}

