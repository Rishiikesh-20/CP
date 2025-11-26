import java.io.*;
import java.util.*;

public class A_Counting_Orders{
    static long MOD=1_000_000_007;
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
        while(t-->0){
            int n=in.nextInt();
            int[] a=new int[n];
            int[] b=new int[n];

            for(int i=0;i<n;i++){
                a[i]=in.nextInt();
            }

            for(int i=0;i<n;i++){
                b[i]=in.nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(b);

            long ans = 1;
            int ptr = 0;
            for (int i = 0; i < n; i++) {
                while (ptr < n && a[ptr] <= b[i]) ptr++;
                long available = (n - ptr) - ((n - 1) - i);
                if (available <= 0) {
                    ans = 0;
                    break;
                }
                ans = ans * available % MOD;
            }
            System.out.println(ans);

        }


        out.close();
    }
}