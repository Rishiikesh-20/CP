import java.util.Scanner;

public class contest2160A {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
         int t =in.nextInt();
        for (int test = 0; test < t; test++) {
            int n=in.nextInt();
            int[] arr=new int[101];
            for(int i=0;i<n;i++){
                int val=in.nextInt();
                arr[val]++;
            }
            for(int i=0;i<=100;i++){
                if(arr[i]==0){
                    System.out.println(i+"");
                    break;
                }
            }
        }
    }
}
