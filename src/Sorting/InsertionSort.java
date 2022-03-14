package Sorting;

import java.util.LinkedList;
import static Sorting.Print.print;

public class InsertionSort {
    public static void insertSort(int[] arr) {
        print(arr);
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
            print(arr);
        }

    }

    public static void sort(int[] arr) {
        print(arr);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            print(arr);
        }
    }


    //JS
    //insertion sort
//      const arr = [6,5,3,1,8,7,2,4];
//
//      const InsertionSort=(arr)=>{
//        for(let i=1;i<arr.length;i++){
//            for(let j=0;j<i;j++){
//                if(arr[i]<arr[j]){
//                    let temp = arr[j];
//                    arr[j]=arr[i];
//                    arr[i]=temp;
//                }
//            }
//            console.log(arr);
//        }
//
//        console.log(arr);
//    };
//    InsertionSort(arr);
}
