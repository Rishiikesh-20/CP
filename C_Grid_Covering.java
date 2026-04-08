import java.io.*;
import java.util.*;

public class C_Grid_Covering{
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
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public static long lcm(long a,long b){
        return Math.abs(a*b)/gcd(a,b);
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        int t=in.nextInt();
        testcase: while(t-->0){
            long n=in.nextLong();
            long m=in.nextLong();
            long a=in.nextLong();
            long b=in.nextLong();

            // n=> a   m => b

            long row=lcm(n,a)/a;
            long col=lcm(m,b)/b;
            long total=lcm(row,col);

            if(row>=n && col>=m && 2*total>=(n*m)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        out.close();
    }
}