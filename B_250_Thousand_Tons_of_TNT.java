import java.io.*;
import java.util.*;

public class B_250_Thousand_Tons_of_TNT{
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

        /*

            k -> factors of n  brute force (1 to n)

            prefix sum , 
            if it is 2 , n=6 , 3 trucks , Max(pSum[1] , pSum[3]-pSum[1] , pSum5-pSum[3] )    
         */

        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            long[] pSum=new long[n];
            pSum[0]=arr[0];
            for(int i=1;i<n;i++){
                pSum[i]=pSum[i-1]+arr[i];
            }
            long result=0;
            for(int k=1;k<n;k++){
                long max=0;
                long min=Long.MAX_VALUE;
                if(n%k==0){
                    long prev=0;
                    int prevInd=-1;
                    for(int i=0;i<n/k;i++){
                        max=Math.max(pSum[k+prevInd]-prev,max);
                        min=Math.min(pSum[k+prevInd]-prev,min);
                        prev=pSum[k+prevInd];
                        prevInd+=k;
                    }
                    result=Math.max(result, max-min);
                }
            }
            System.out.println(result);
        }


        out.close();
    }
}