import java.util.ArrayList;
import java.util.Scanner;

public class problem1862B {
    public static void solve(int[] arr){
        int m=arr.length;
        if(m==1) {
            System.out.println(m);
            System.out.println(arr[0]);
            return;
        }
        
        ArrayList<Integer> arr1=new ArrayList<>();
        arr1.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                m+=1;
                arr1.add(arr[i]);
            }
            arr1.add(arr[i]);
        }
        System.out.println(m);
        for(Integer i:arr1){
            System.out.print(i+" ");
        }
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
