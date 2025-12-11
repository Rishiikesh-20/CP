import java.io.*;
import java.util.*;

public class F_Eating_Candies{
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
            HashMap<Long,Long> pSum=new HashMap<>();
            long sum=0;
            for(int i=0;i<n;i++){
                sum+=arr[i];
                pSum.put(sum,(long)i);
            }
            long sufSum=0;
            long ans=0;
            for(int i=n-1;i>=0;i--){
                sum-=arr[i];
                sufSum+=arr[i];
                if(sum<sufSum){
                   break;
                }
                if(pSum.containsKey(sufSum) && pSum.get(sufSum)<i){
                    ans=Math.max(ans,pSum.get(sufSum)+n-i+1);
                }
            }
            System.out.println(ans);
        }


        out.close();
    }
}