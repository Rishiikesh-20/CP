import java.io.*;
import java.util.*;

public class D_Plus_Minus_Permutation{
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {}
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }
    }
    public static long gcd(long a,long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        int t=in.nextInt();
        while(t-->0){
            long n=in.nextLong();
            long x=in.nextLong();
            long y=in.nextLong();
            long temp=n;
            long result=0;
            // for(long i=x;i<=n;i+=x){
            //     if(i%y==0){
            //         continue;
            //     }
            //     result+=temp;
            //     temp--;
            // }
            // temp=1;
            // for(long i=y;i<=n;i+=y){
            //     if(i%x==0){
            //         continue;
            //     }
            //     result-=temp;
            //     temp++;
            // }
            long gcdno=gcd(x,y);
            long lcm=x*y/gcdno;
            long xLen=n/x - n/lcm;
            long yLen=n/y - n/lcm;
            result=n*(n+1)/2 - (n-xLen)*((n-xLen)+1)/2;
            result=result-yLen*(yLen+1)/2;
            System.out.println(result);
        }


        out.close();
    }
}