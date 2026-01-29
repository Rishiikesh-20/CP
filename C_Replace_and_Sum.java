import java.io.*;
import java.util.*;

public class C_Replace_and_Sum{
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
            int q=in.nextInt();

            int[] a=new int[n];
            int[] b=new int[n];

            for(int i=0;i<n;i++){
                a[i]=in.nextInt();
            }
            for(int i=0;i<n;i++){
                b[i]=in.nextInt();
            }
            int[][] queries=new int[q][2];
            for(int i=0;i<q;i++){
                queries[i][0]=in.nextInt();
                queries[i][1]=in.nextInt();
            }

            for(int i=0;i<n;i++){
                a[i]=Math.max(a[i],b[i]);
            }

            for(int i=n-2;i>=0;i--){
                a[i]=Math.max(a[i],a[i+1]);
            }
            int[] prefixSum=new int[n+1];
            prefixSum[0]=0;
            for(int i=1;i<=n;i++){
                prefixSum[i]=prefixSum[i-1]+a[i-1];
            }

            for(int i=0;i<q;i++){
                int l=queries[i][0];
                int r=queries[i][1];
                
                long sum=prefixSum[r]-prefixSum[l-1];

                System.out.print(sum+" ");
            }
            System.out.println();
        }


        out.close();
    }
}