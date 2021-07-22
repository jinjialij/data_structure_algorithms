package StackAndQueue;

import java.util.Stack;

public class QueueUsingStacks {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    /** Initialize your data structure here. */
    public QueueUsingStacks() {
        this.pushStack = new Stack();
        this.popStack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (empty()) return popStack.pop();
        if (!empty()&&popStack.empty()){
            while (!pushStack.empty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (empty()) return popStack.peek();
        if (!empty()&&popStack.empty()){
            while (!pushStack.empty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return popStack.empty()&&pushStack.empty();
    }

}
