package Sorting;

import static Sorting.Print.print;

public class BubbleSort {

    public static int [] BubbleSort(int [] arr){
        print(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                int temp=arr[j];
                if(temp>arr[j+1]){
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            print(arr);
        }
        return arr;
    }
}
