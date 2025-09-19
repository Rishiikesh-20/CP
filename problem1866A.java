import java.util.Scanner;

public class problem1866A {
    public static void solve(int[] arr){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(Math.abs(arr[i])<min){
                min=Math.abs(arr[i]);
            }
        }
        System.out.println(min);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        int[] arr=new int[num];
        for(int i=0;i<num;i++){
            arr[i]=in.nextInt();
        }
        solve(arr);
         
    }
}
