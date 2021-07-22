package LeetCode.Medium;


import LinkedList.LinkedList;
import LinkedList.Node;

public class AddTwoNumberUsingLinkedList {
    public static void main(String []args){
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.addFirst(3);
        l1.addFirst(4);
        l1.addFirst(2);

        l2.addFirst(4);
        l2.addFirst(6);
        l2.addFirst(5);

        LinkedList l3 = addTwoNumber(l1,l2);
        System.out.println(l3);
    }

    public static LinkedList addTwoNumber(LinkedList l1, LinkedList l2){
        Node current = l1.getFirst();
        String sum = "";
        while (current!=null){
            sum=current.getValue()+sum;
            current=current.getNext();
        }

        long v1 = Integer.valueOf(sum);
        current=l2.getFirst();
        sum="";
        while (current!=null){
            sum=current.getValue()+sum;
            current=current.getNext();
        }
        long v2 = Integer.valueOf(sum);
        String v3 = String.valueOf(v1+v2);
        LinkedList l3 = new LinkedList();
        for (int i=0;i<v3.length();i++){
            l3.addFirst(Integer.valueOf(v3.substring(i,i+1)));
        }
        return l3;
    }
}
