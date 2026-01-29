import java.io.*;
import java.util.*;

public class B_Hourglass{
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
            int s=in.nextInt();
            int k=in.nextInt();
            int m=in.nextInt();

            int val=m/k;
            int r=m%k;

            if(s>k){
                if(val%2!=0){
                    s=k;
                }
            }
            System.out.println(Math.max(0,s-r));
        }


        out.close();
    }
}