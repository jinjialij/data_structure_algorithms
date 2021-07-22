package StackAndQueue;

import LinkedList.Node;

public class Stack {
    private Node top;
    private Node bottom;
    private int length;

    public Stack(){
        this.top=null;
        this.bottom=null;
        this.length=0;
    }

    public Node peek(){return this.top;}
    public void push(Node element){
        if (isEmpty()){
            this.top=this.bottom=element;
        } else {
            Node current = this.top;
            this.top=element;
            this.top.setNext(current);
        }
        this.length++;
    }

    public Node pop(){
        if (isEmpty()) return null;
        Node result = this.top;
        if (this.length==1) {
            this.top=this.bottom=null;
        } else {
            this.top = this.top.getNext();
        }
        this.length--;
        return result;
    }

    public boolean isEmpty(){
        if (this.length==0) {return true;}
        return false;
    }

    public String toString(){
        Node current = this.top;
        String result = "[ ";
        while (current!=null){
            result+=current.getValue();
            current=current.getNext();
            if (current!=null){
                result+=", ";
            }
        }
        result+=" ]";
        return result;
    }

}
