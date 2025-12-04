import java.io.*;
import java.util.*;

public class B_Kill_Demodogs{
    static final long MOD=1_000_000_007;
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
    
    public static void main(String[] args) {

        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        int t=in.nextInt();
        testcase: while(t-->0){
            long n=in.nextLong();

            long part1=(n*(n+1))%MOD;
            long part2=(4*n-1)%MOD;

            long ans=(part1*part2)%MOD;
            ans=(ans*337)%MOD;
            
            
            System.out.println(ans);
        }
        out.close();
    }
}