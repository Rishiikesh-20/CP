import java.io.*;
import java.util.*;

public class B_Maximum_Sum{
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
            int k=in.nextInt();

            long[] arr=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextLong();
            }

            Arrays.sort(arr);

            long max=0;
            long[] pSum=new long[n+1];
            for(int i=1;i<=n;i++){
                pSum[i]=pSum[i-1]+arr[i-1];
            }
            for(int i=0;i<=k;i++){
                int ind1=2*i;
                int ind2=k-i;
                max=Math.max(max,pSum[n-ind2]-pSum[ind1]);
            }
            System.out.println(max);
        }

        out.close();
    }
}