package Strings;

public class ReverseString {
    public static void main(String []args){
//        String text = "Hello";
//        String newText = reverseString(text);
//        System.out.print(newText);
        int [] arr1 = new int[] {1,2,3,6,9};
        int [] arr2 = new int[] {2,3,4,5};
        int [] arr3 = mergeSorted(arr1,arr2);
        for (int i =0;i<arr3.length;i++){
            System.out.print(arr3[i]+", ");
        }

    }

    public static String reverseString(String text) {
        if (text.length()<2) return text;
        String newText = "";
        for (int i=text.length()-1;i>=0;i--){
//            System.out.print(text.charAt(i));
            newText += text.charAt(i);
        }
        return newText;
    }

    //assume no duplication
    public static int [] mergeSorted(int [] arr1, int [] arr2){
        if (arr1.length==0) {
            return arr2;
        }
        if (arr2.length==0) return arr1;

        int [] mergedArr = new int [arr1.length+arr2.length];
        int pointer1 =0, pointer2 =0;
        int count = 0;
        while (pointer1<arr1.length && pointer2<arr2.length){
            if (arr1[pointer1]>arr2[pointer2]){
                mergedArr[count] = arr2[pointer2];
                pointer2++;
            } else if (arr1[pointer1]==arr2[pointer2]) {
                mergedArr[count] = arr2[pointer2];
                pointer2++;
                pointer1++;
            }
            else {
                mergedArr[count] = arr1[pointer1];
                pointer1++;
            }
            count++;
        }

        if (pointer1==arr1.length){
            for (;pointer2<arr2.length;pointer2++){
                mergedArr[count]=arr2[pointer2];
                count++;
            }
        }
        if (pointer2 == arr2.length) {
            for (;pointer1<arr1.length;pointer1++){
                mergedArr[count]=arr1[pointer1];
                count++;
            }
        }


        return mergedArr;
    }
}
