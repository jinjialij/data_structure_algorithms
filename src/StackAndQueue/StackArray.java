package StackAndQueue;

import java.util.ArrayList;

public class StackArray {
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public void push(int element){
        arrayList.add(element);
    }

    public int peek(){
        return arrayList.get(arrayList.size()-1);
    }

    public int pop(){
        return arrayList.remove(arrayList.size()-1);
    }

    public boolean isEmpty(){
        return arrayList.isEmpty();
    }

    public String toString(){
        String result = "";
        for (int element:arrayList){
            result+=element+"\t";
        }
        return result;
    }
}
