import LinkedList.LinkedList;
import StackAndQueue.Queue;
import StackAndQueue.QueueUsingStacks;
import StackAndQueue.Stack;
import StackAndQueue.StackArray;
import LinkedList.Node;

public class main {
    public static void main(String []args){
//        playLinkedList();
//        stack();
//        stackArray();
//        queue();
//        queueUsingStacks();

    }

    public static void playLinkedList(){
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addFirst(0);

        System.out.print(list);
    }

    public static void reverseLinkedList(){

    }

    public static void stack(){
        Stack myStack = new Stack();
        myStack.push(new Node(1));
        System.out.println("My stack " + myStack);
        myStack.push(new Node(2));
        System.out.println("My stack " + myStack);
        myStack.push(new Node(3));
        System.out.println("Peek: "+myStack.peek().getValue());
        System.out.println("My stack " + myStack);
        System.out.println("POP: "+myStack.pop().getValue());
        System.out.println("My stack " + myStack);
        System.out.println("POP: "+myStack.pop().getValue());
        System.out.println("My stack " + myStack);
        System.out.println("POP: "+myStack.pop().getValue());
        System.out.println("My stack " + myStack);
    }

    public static void stackArray(){
        StackArray myStack = new StackArray();
        myStack.push(1);
        System.out.println("My stack " + myStack);
        myStack.push(2);
        System.out.println("My stack " + myStack);
        myStack.push(3);
        System.out.println("My stack " + myStack);
        System.out.println("Peek: "+myStack.peek());
        System.out.println("POP: "+myStack.pop());
        System.out.println("My stack " + myStack);
        System.out.println("POP: "+myStack.pop());
        System.out.println("My stack " + myStack);
        System.out.println("POP: "+myStack.pop());
        System.out.println("My stack " + myStack);
    }

    public static void queue(){
        Queue myQueue = new Queue();

        myQueue.enqueue(new Node(1));
        System.out.println("My queue " + myQueue);
        myQueue.enqueue(new Node(2));
        System.out.println("My queue " + myQueue);
        myQueue.enqueue(new Node(3));
        System.out.println("My queue " + myQueue);
        System.out.println("Peek " + myQueue.peek().getValue());

        System.out.println("Dequeue: "+myQueue.dequeue().getValue());
        System.out.println("My queue " + myQueue);
        System.out.println("Dequeue: "+myQueue.dequeue().getValue());
        System.out.println("My queue " + myQueue);
        System.out.println("Dequeue: "+myQueue.dequeue().getValue());
        System.out.println("My queue " + myQueue);

    }

    public static void queueUsingStacks(){
        QueueUsingStacks myQueue = new QueueUsingStacks();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println("Peek: "+ myQueue.peek());
        System.out.println("Pop: "+ myQueue.pop());
        System.out.println("Peek: "+ myQueue.peek());
        System.out.println("Pop: "+ myQueue.pop());
        System.out.println("Peek: "+ myQueue.peek());
        System.out.println("Pop: "+ myQueue.pop());
        System.out.println("Peek: "+ myQueue.peek());
    }

}
