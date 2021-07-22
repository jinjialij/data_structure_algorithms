package HashTables;

import java.util.HashMap;
import java.util.HashSet;

public class RecurringCharacter {
    public static void main(String []args){
        int [] arr = new int[]{2,5,5,3,2,4,6};
        int result = recurringChar(arr);
        System.out.print(result);

    }

    //O(n)
    public static int recurringChar(int [] arr){
        HashSet map = new HashSet();
        for (int i=0; i<arr.length; i++){
            if (map.contains(arr[i])){
                return arr[i];
            } else {
                map.add(arr[i]);
            }
        }
        return -1;
    }

    //O(n^2)
    public static int recurringChar2(int [] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]==arr[j]){
                    return arr[i];
                }
            }
        }
        return -1;
    }
}
