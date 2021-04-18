public class Main {
    public static void main(String[] args) {
        BST obj =new BST();
       obj.insert(5);
        obj.insert(7);
        obj.insert(12);
        obj.insert(2);
       // obj.inOrderTraversal();
        System.out.println(obj.search(4));

    }
}

