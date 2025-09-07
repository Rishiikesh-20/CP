import java.util.Scanner;

public class problem1877A {
    public static void solve(int[] arr,int num){
        int sum=0;
        for(int i=0;i<num-1;i++){
            sum=sum+arr[i];
        }
        sum=sum*-1;
        System.out.println(sum);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        
        for(int i=0;i<n;i++){
            int num=in.nextInt();
            int[] arr=new int[num-1];
            for(int j=0;j<num-1;j++){
                arr[j]=in.nextInt();
            }
            solve(arr,num);
        }
    }
}
