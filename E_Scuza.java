import java.io.*;
import java.util.*;

public class E_Scuza{
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
            int q=in.nextInt();

            // int[] a=new int[n];
            // int[] b=new int[q];
            long[] prefixSum=new long[n];
            long sum=0;
            int[] prefixMax=new int[n];
            int prev=0;
            for(int i=0;i<n;i++){
                int val=in.nextInt();
                sum+=val;
                prefixSum[i]=sum;
                prefixMax[i]=Math.max(val,prev);
                prev=prefixMax[i];
            }
            for(int i=0;i<q;i++){
                int val=in.nextInt();
                int ind=binarySearch(prefixMax, val);
                if(ind==0){
                    System.out.print(0+" ");
                    continue;
                }
                System.out.print(prefixSum[ind-1]+" ");
            }
            System.out.println();
        }


        out.close();
    }

    public static int binarySearch(int[] pMax,int k){
        int low=0,high=pMax.length;
        while(low<high){
            int mid=(low+high)/2;
            if(pMax[mid]<=k){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
}