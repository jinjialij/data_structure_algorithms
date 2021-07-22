package StackAndQueue;

import LinkedList.Node;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue(){
        this.last=this.first=null;
        this.length=0;
    }

    public boolean isEmpty(){
        return this.length==0 ? true:false;
    }

    public Node peek(){
        return this.first;
    }

    //add to the last
    public void enqueue(Node element){
        if (isEmpty()){
            this.first=this.last=element;
        } else {
            this.last.setNext(element);
            this.last=element;
        }
        this.length++;
    }

    //remove from the start
    public Node dequeue(){
        if (isEmpty()) return null;
        Node hold = this.first;
        if (this.length==1){
            this.first=this.last=null;
        } else {
            this.first=this.first.getNext();
        }
        this.length--;
        return hold;
    }

    public String toString(){
        Node current = this.first;
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
