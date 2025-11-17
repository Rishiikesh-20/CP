import java.io.*;
import java.util.*;

public class C_Range_Operation{
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
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            long[] pSum=new long[n+1];
            for(int i=1;i<=n;i++){
                pSum[i]=pSum[i-1]+arr[i-1];
            }
            long left_best=0;
            long result=0;
            for(int i=1;i<=n;i++){
                long left=pSum[i-1] - (long)i*(i-1);
                left_best=Math.max(left,left_best);
                long right=(long)i*(i+1)-pSum[i];
                result=Math.max(result,left_best+right);
            }
            System.out.println(result+pSum[n]);
        }
        out.close();
    }
}