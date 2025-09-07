import java.util.Scanner;

public class problem1873C {
    public static void solve(String[] arr){
        int sum=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(arr[i].charAt(j)=='X'){
                    int val=Math.min(Math.min(i,j),Math.min(9-i,9-j));
                    sum+=(val+1);
                }
            }
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++){
            String[] arr=new String[10];
            for(int j=0;j<10;j++){
               arr[j]=in.nextLine();
            } 
            solve(arr);
        }
    }
}
