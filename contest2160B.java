import java.util.Scanner;

public class contest2160B {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
       
        while(t-->0){
            int n=in.nextInt();
            long[] arr=new long[n];
            int[] result=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextLong();  
            }
            if(n==1){
                System.out.println(1);
                continue;
            }
            result[0]=1;
            for(int i=1;i<n;i++){
                int diff=(int)(arr[i]-arr[i-1]);
                if(diff-i==1){
                    result[i]=diff;
                }else{
                    result[i]=result[i-diff];
                }
            }
            for(int i=0;i<n;i++){
                System.out.print(result[i]+" ");
            }
            System.out.println("");
        }
    }
}
