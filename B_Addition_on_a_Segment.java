import java.io.*;
import java.util.*;

public class B_Addition_on_a_Segment{
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
            int[] arr=new int[n];
            long nonZeros=0;
            long totalSum=0;
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                if(arr[i]!=0){
                    nonZeros++;
                }
                totalSum+=arr[i];
            }

            for(long i=nonZeros;i>=1;i--){
                long diff=totalSum-i;
                if(diff>=n-1){
                    System.out.println(i);
                    continue testcase;
                }
            }
        }


        out.close();
    }
}