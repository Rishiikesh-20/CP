import java.util.*;
public class problem1896A {
    public static void solve(int[] arr){
        int n=arr.length;
        int min=arr[0];
        for(int i=1;i<n;i++){
            if(min>arr[i]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
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
