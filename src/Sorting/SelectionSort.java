package Sorting;

import static Sorting.Print.print;

public class SelectionSort {
    //loop the arr
    //in each loop, find the smallest
    //exchange the smallest one with the ith one
    //continue the process until the entire arr has been looped

    public static void SelectionSort(int [] arr){
        print(arr);
        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            int hold = arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=hold;
            print(arr);
        }
    }
}
