import java.util.ArrayList;
import java.util.Scanner;

public class problem1859 {
    public static void solve(int[] arr){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }

        ArrayList<Integer> b=new ArrayList<>();
        ArrayList<Integer> c=new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(arr[i]==min){
                b.add(arr[i]);
            }else{
                c.add(arr[i]);
            }
        }
        if(c.size()==0){
            System.out.println(-1);
            return;
        }
        System.out.println(b.size()+" "+c.size());
        for(Integer i:b){
            System.out.print(i+" ");
        }
        for(Integer i:c){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int j=0;j<n;j++){
            int num=in.nextInt();
            int[] arr=new int[num];
            for(int i=0;i<num;i++){
                arr[i]=in.nextInt();
            }
            solve(arr);
        }
    }
}
