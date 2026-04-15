import java.io.*;
import java.util.*;

public class D_The_67_th_OEIS_Problem{
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
            long val=3;
            System.out.print(val+" ");
            for(int i=1;i<=n-2;i++){
                long cur=2*(i+1)-1;
                long next=2*(i+2)-1;

                System.out.print(cur*next+" ");
            }
            System.out.println(2*n-1);
        }


        out.close();
    }
}