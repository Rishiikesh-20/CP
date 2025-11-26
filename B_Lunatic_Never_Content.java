import java.io.*;
import java.util.*;

public class B_Lunatic_Never_Content{
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
    public static long gcd(long a,long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        int t=in.nextInt();
        testcase: while(t-->0){
            int n=in.nextInt();
            long[] arr=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextLong();
            }
            if(n==1){
                System.out.println(0);
                continue testcase;
            }
            long gcd=0;
            for(int i=0;i<n/2;i++){
                long val=Math.abs(arr[i]-arr[n-i-1]);
                gcd=gcd(gcd,val);
            }
            System.out.println(gcd);
        }


        out.close();
    }
}