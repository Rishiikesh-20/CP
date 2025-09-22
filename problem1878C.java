import java.util.Scanner;

public class problem1878C {
    public static void solve(long n,long k,long x){
        if(n<k){
            System.out.println("NO");
            return;
        }
        long full=n*(n+1)/2;
        long minSum=k*(k+1)/2;
        long first=(n-k)*(n-k+1)/2;

        if(minSum<=x && x<=full-first){
            System.out.println("YES");
            return;
        }
        System.out.println("NO");

    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        for(int i=0;i<num;i++){
            long n=in.nextLong();
            long k=in.nextLong();
            long x=in.nextLong();
            solve(n,k,x);
        }
    }
}

