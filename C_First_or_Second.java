import java.io.*;
import java.util.*;

public class C_First_or_Second{
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
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            
            long[] preSum=new long[n];
            long[] sufSum=new long[n];
            preSum[0]=arr[0];
            sufSum[n-1]=arr[n-1];
            for(int i=1;i<n;i++){
                preSum[i]=Math.abs(arr[i])+preSum[i-1];
            }
            for(int i=n-2;i>=0;i--){
                sufSum[i]=sufSum[i+1]+arr[i];
            }

            long result=Integer.MIN_VALUE;

            for(int i=0;i<n;i++){
                long add=0;
                long sub=0;

                if(i>0){
                    add=preSum[i-1];
                }
                if(i<(n-1)){
                    sub=sufSum[i+1];
                }

                long res=add-sub;

                result=Math.max(res,result);
            }
            System.out.println(result);
        }


        out.close();
    }
}