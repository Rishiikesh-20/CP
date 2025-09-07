import java.util.Scanner;

public class problem1878A {
    public static void solve(int[] arr ,int k){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==k){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
        return;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        
        for(int i=0;i<n;i++){
            int num=in.nextInt();
            int k=in.nextInt();
            int[] arr=new int[num];
            for(int j=0;j<num;j++){
                arr[j]=in.nextInt();
            }
            solve(arr,k);
        }
    }
}
