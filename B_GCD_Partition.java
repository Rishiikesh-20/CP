import java.io.*;
import java.util.*;

public class B_GCD_Partition{
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
        testcase: while(t-->0){
            int n=in.nextInt();
            int[] arr=new int[n];
            long[] preSum=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                if(i==0){
                    preSum[i]=arr[i];
                    continue;
                }
                preSum[i]=preSum[i-1]+arr[i];
            }
            long last=preSum[n-1];
            long max=1;
            for(int i=n-2;i>=0;i--){
                max=Math.max(max,gcd(preSum[i], last));
            }
            System.out.println(max);
        }


        out.close();
    }
}