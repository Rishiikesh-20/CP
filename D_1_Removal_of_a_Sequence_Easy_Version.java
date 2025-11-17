import java.io.*;
import java.util.*;

public class D_1_Removal_of_a_Sequence_Easy_Version{
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

    public static long countSurvived(long n,long x,long y){
        for(int i=0;i<x;i++){
            n=n-n/y;
        }
        return n;
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        int t=in.nextInt();
        testcase: while(t-->0){
            long x=in.nextLong();
            long y=in.nextLong();
            long k=in.nextLong();

            long n=(long)1e12;

            long temp=countSurvived(n, x,y);
            if(temp<k){
                System.out.println(-1);
                continue testcase;
            }

            long low=1;
            long high=n;
            long ans=Long.MAX_VALUE;
            while(low<=high){
                long mid=(low+high)/2;
                temp=countSurvived(mid, x,y);
                if(temp>=k){
                    ans=mid;
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            System.out.println(ans);
        }
        out.close();
    }
}