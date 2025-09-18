import java.util.Scanner;

public class contest2148B {
    public static void solve(int x,int y,int n,int m,int[] a,int[] b){
         System.out.println(a.length+b.length);   
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        for(int i=0;i<num;i++){
            int n=in.nextInt();
            int m=in.nextInt();
            int x=in.nextInt();
            int y=in.nextInt();
            int[] a=new int[n];
            int[] b=new int[m];
            for(int j=0;j<n;j++){
                a[j]=in.nextInt();
            }
            for(int j=0;j<m;j++){
                b[j]=in.nextInt();
            }
            solve(x,y,n,m,a,b);
        }
    }
}
