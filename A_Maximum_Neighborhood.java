import java.io.*;
import java.util.*;

public class A_Maximum_Neighborhood{
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
            int n=in.nextInt();
            
            if(n==1){
                System.out.println(1);
                continue;
            }
            if(n==2){
                System.out.println(9);
                continue;
            }
            // last row - 4n^2 - n - 4
            // last - 1 row - 5^n2 - 5^n - 5

            long result=Math.max(4*n*n-n-4,5*n*n-5*n-5);
            System.out.println(result);
             
        }


        out.close();
    }
}