import java.util.*;
public class problem1901A {
    public static void solve(int[] arr,int x){
        int max=0;
        int n=arr.length;
        int prev=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]-prev);
            prev=arr[i];
        }
        max=Math.max(max,2*(x-arr[n-1]));
        System.out.println(max);
    }
     public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int num=in.nextInt();
            int x=in.nextInt();
            int[] arr=new int[num];
            for(int j=0;j<num;j++){
                arr[j]=in.nextInt();
            }
            solve(arr, x);
        }
    }
}
