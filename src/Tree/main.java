package Tree;

public class main {
    public static void main(String []args){
        binarySearchTree();
    }

    public static void binarySearchTree(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(new Node(9));
        tree.insert(new Node(4));
        tree.insert(new Node(6));
        tree.insert(new Node(20));
        tree.insert(new Node(170));
        tree.insert(new Node(15));
        tree.insert(new Node(1));
//           9
//      4        20
//  1    6   15    170

        tree.printTree();
        Node result = tree.lookup(new Node(9));
        if (result!=null){
            System.out.println("\nFound: "+result.getValue());
        } else {
            System.out.println("\nNot found");
        }

    }
}
