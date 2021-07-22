import java.util.ArrayList;
import java.util.List;

public class hackerRankTwo {
    public static void main(String []args){

    }

    public static int[] rotLeft(int[] arr, int d){
        int[] arr2 = new int[arr.length];
        int N = arr.length;
        for (int i = 0 ; i < N;  i++){
            arr[i] = arr[(i+d)%N];
        }
        return arr ;
    }

    public static int minSwap(int [] a){
        int swap=0;
        for(int i=0;i<a.length;i++){
            if(i+1!=a[i]){
                int t=i;
                while(a[t]!=i+1){
                    t++;
                }
                int temp=a[t];
                a[t]=a[i];
                a[i]=temp;
                swap++;
            }
        }
        return swap;
    }

    public static void chaos(int[] q){
        int swaps = 0;
        for(int i=q.length-1;i>0;i--){
            if(q[i]!=i+1){
                if((i-1)>0 && q[i-1]==i+1){//check boundary
                    //swap
                    int temp = q[i-1];
                    q[i-1]=q[i];
                    q[i]=temp;
                }
            } else if ((i-2) >=0 && q[i-2] == i+1){
                q[i-2]=q[i-1];
                q[i-1]=q[i];
                q[i]=q[i-2];
                swaps+=2;
            } else{
                System.out.print("Too Chaotic");
                return;
            }
        }
        System.out.print(swaps);
    }
}
