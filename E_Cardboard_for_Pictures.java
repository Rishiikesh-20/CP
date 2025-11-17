import java.io.*;
import java.util.*;

public class E_Cardboard_for_Pictures{
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
            long c=in.nextLong();
            int[] s=new int[n];
            long square=0;
            long add=0;
            for(int i=0;i<n;i++){
                s[i]=in.nextInt();
                square+=s[i]*s[i];
                add+=s[i];
            }
            long low=0,high=2000000000L;
            while(low<high){
                long mid=low+(high-low)/2;
                long val;
                if (mid > 0 && Long.MAX_VALUE / mid / mid < n) {
                    val = Long.MAX_VALUE; 
                } else {
                    val = square;
                    val += add * 2L * mid;
                    val += n * mid * mid;
                }
                
                if(val>=c){
                    high=mid;
                }else{
                    low=mid+1;
                }
            }
            out.println(low/2);
        }

        out.close();
    }
}