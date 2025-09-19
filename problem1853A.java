import java.util.Scanner;

public class problem1853A {
    public static void solve(int[] arr){
        // a1,a2,a3,a4 1 2 3 4  1 2 3 4 5    1 2 3 6 7
        int min=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            min=Math.min(min,arr[i]-arr[i-1]);
        } 
        if(min<0) {System.out.println(0);return;}
        if(min==0){
            System.out.println(1);
            return;
        }
        System.out.println(min/2 + 1);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        for(int i=0;i<num;i++){
            int n=in.nextInt();
            int[] arr=new int[n];
            for(int j=0;j<n;j++){
                arr[j]=in.nextInt();
            }
            solve(arr);
        }
    }   
}
