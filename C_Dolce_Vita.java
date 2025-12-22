import java.io.*;
import java.util.*;

public class C_Dolce_Vita{
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

    public static long lowerBound(long[] preSum,int val,int ind){
        long low=1;
        long high=1_000_000_005;
        long ans=0;
        while(low<=high){
            long mid=low+(high-low)/2;
            if((preSum[ind]+((ind+1)*(mid-1)))<=val){
                low=mid+1;
                ans=mid;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        int t=in.nextInt();
        testcase: while(t-->0){
            int n=in.nextInt();
            int x=in.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++) arr[i]=in.nextInt();

            Arrays.sort(arr);

            long[] preSum=new long[n];
            preSum[0]=arr[0];
            for(int i=1;i<n;i++){
                preSum[i]=arr[i]+preSum[i-1];
            }
            long result=0;
            for(int i=0;i<n;i++){
               result+=lowerBound(preSum, x, i);
            }
            
            System.out.println(result);
        }
        out.close();
    }
}