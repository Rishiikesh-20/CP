import java.util.Scanner;

public class contest2137B {
    public static void solve(int[] arr){
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            System.out.print(n+1-arr[i]+" ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        
        for(int i=0;i<n;i++){
            int num=in.nextInt();
            int[] arr=new int[num];
            for(int j=0;j<num;j++){
                arr[j]=in.nextInt();
            }
            solve(arr);
        }
    }
}
