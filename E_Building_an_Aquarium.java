import java.io.*;
import java.util.*;

public class E_Building_an_Aquarium{
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
            long x=in.nextLong();
            long[] arr=new long[n];
            long max=0;
            for(int i=0;i<n;i++){
                arr[i]=in.nextLong();
                max=Math.max(max,arr[i]);
            }
            long low=1;
            long high=x+max;
            long ans=0;
            while(low<=high){
                long mid=(low+high)/2;
                long sum=0;
                for(int i=0;i<n;i++){
                    if(mid-arr[i]>0){
                        sum+=(mid-arr[i]);
                    }
                    if(sum>x){
                       break;
                    }
                }
                if(sum<=x){
                    ans=mid;
                    low=mid+1;
                }
                if(sum>x){
                    high=mid-1;
                }
            }
            out.println(ans);
            out.flush();
        }
        out.close();
    }
}