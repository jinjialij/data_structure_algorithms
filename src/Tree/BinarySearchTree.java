package Tree;

public class BinarySearchTree {
    private Node root;
    private int height;

    public BinarySearchTree(){
        this.root=null;
        this.height=0;
    }

    public boolean isEmpty(){return this.root==null;}

    public void insert(Node node){
        if (isEmpty()){
            this.root=node;
            this.height++;
        } else {
            Node current = this.root;
            while (true){
                //right
                if (node.getValue()>current.getValue()){
                    if (current.getRight()==null){
                        current.setRight(node);
                        break;
                    }
                    current=current.getRight();
                } else {
                    if (current.getLeft()==null){
                        current.setLeft(node);
                        break;
                    }
                    current=current.getLeft();
                }
            }
        }
    }

    public Node lookup(Node node){
        Node current = this.root;
        if (current==null) return null;
        while (current!=null){
            if (node.getValue()<current.getValue()){
                current=current.getLeft();
            } else if (node.getValue()==current.getValue()){
                return current;
            } else {
                current=current.getRight();
            }
        }
        return null;
    }

    public Node lookup2(Node node){
        Node current = this.root;
        if (current==null) return null;
        if (current.getValue()==node.getValue()){
            return current;
        }
        return lookupInChildren(current, node);
    }

    public Node lookupInChildren(Node current, Node node){
        if (current.getValue()==node.getValue()) return current;
        if (current.getValue()> node.getValue()){
            if (current.getLeft()==null) return null;
            if (current.getLeft().getValue()!= node.getValue()){
                return lookupInChildren(current.getLeft(), node);
            } else {
                return current.getLeft();
            }
        } else {
            if (current.getRight()==null) return null;
            if (current.getRight().getValue()!= node.getValue()){
                return lookupInChildren(current.getRight(), node);
            }else {
                return current.getRight();
            }
        }
    }

    public void printTree(){
        Node current = this.root;
        //print root
        System.out.println("Root: "+ current.getValue()+", ");
        printChildren(current);
    }

    public void printChildren(Node current){
        if (current==null){
            return;
        }else {
            if (current.getLeft()!=null){
                System.out.print("Left: "+current.getLeft().getValue()+", ");
            }
            if (current.getRight()!=null){
                System.out.print("Right: "+current.getRight().getValue()+", ");
            }
            printChildren(current.getLeft());
            printChildren(current.getRight());
        }
    }

//    public Node remove(Node node){
//
//    }
}
