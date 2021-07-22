package LinkedList;

public class DoubleLinkedList {
    public class Node{
        private int data;
        private Node previous;
        private Node next;

        public Node (int data, Node previous, Node next){
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public void setValue(int value){ this.data = value;}
        public int getValue(){ return this.data;}

        public void setNext(Node node){ this.next = node;}
        public Node getNext(){ return this.next;}
    }

    private Node first;
    private Node last;
    private int length;

    public DoubleLinkedList(){
        this.first=null;
        this.last=null;
        this.length=0;
    }

}
