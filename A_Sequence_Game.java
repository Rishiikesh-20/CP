import java.io.*;
import java.util.*;

public class A_Sequence_Game{
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
            long[] arr=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextLong();
            }
            long x=in.nextLong();
            long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
            for(int i=0;i<n;i++){
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }
            if (x >= min && x <= max)
                out.println("YES");
            else
                out.println("NO");
        }


        out.close();
    }
}