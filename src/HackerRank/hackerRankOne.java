import java.util.ArrayList;
import java.util.List;

public class hackerRankOne {
    public static void main(String []args){
        timeConversion("07:05:45PM");

    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        // Write your code here
        List<Integer> scores = new ArrayList<Integer>();
        scores.add(0);
        scores.add(0);
        if (a.size() == b.size()){
            for (int index=0; index<a.size();index++){
                if(a.get(index)>b.get(index)){
                    int count = scores.get(0) + 1;
                    scores.set(0, count);
                }
                if (a.get(index)<b.get(index)){
                    int count = scores.get(1) + 1;
                    scores.set(1, count);
                }
            }
        }
        return scores;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int primaryDia = 0;
        int secondaryDia = 0;
        for (int i=0; i<arr.size();i++ ){
            primaryDia+=arr.get(i).get(i);
            secondaryDia+=arr.get(i).get(arr.get(i).size()-1-i);

        }
        return Math.abs(primaryDia-secondaryDia);
    }

    public static void callDiagonalDifference(){
        List<List<Integer>> arr= new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr2.add(3);
        arr2.add(7);
        arr.add(arr1);
        arr.add(arr2);
        int result = diagonalDifference(arr);
        System.out.println(result);
    }

    public static void ReverseStaircase(int n) {
        // Write your code here
        int counter=1;
        for(int i=0; i<n;i++)
        {
            for(int k=n-1; k> i;k--)
            {
                System.out.print(" ");
            }
            for(int j=0; j<counter;j++)
            {
                System.out.print("#");
            }
            System.out.println();
            counter++;
        }
    }

    public static void staircase(int n) {
        // Write your code here
        int counter=0;
        for(int i=0; i<n;i++)
        {
            for (int j=0;j<=counter;j++){
                System.out.print("#");
            }
            System.out.println();
            counter++;
        }
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code
        //minSum=total-max
        //maxSum=total-min
        long max,sum,min,minSum,maxSum;
        max=min=sum = arr.get(0);

        for (int i=1;i<arr.size();i++){
            int num = arr.get(i);
            if(min>num){
                min=num;
            }
            if(max<num){
                max=num;
            }
            sum+=num;
        }
        minSum=sum-max;
        maxSum=sum-min;

        System.out.print(minSum+" " + maxSum);
    }


    public static String timeConversion(String s) {
        // Write your code here
        int hour = Integer.parseInt(s.substring(0,2))%12;
        int test = 7%12;
        if(s.contains("PM")){
            hour += 12;
        }
        String time = Math.round(hour) + s.substring(2,8);
        return time;
    }
}
