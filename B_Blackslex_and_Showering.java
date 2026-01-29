import java.io.*;
import java.util.*;

public class B_Blackslex_and_Showering{
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
            long sum=0;
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            for(int i=1;i<n;i++){
                sum+=(Math.abs(arr[i]-arr[i-1]));
            }
            int first=Math.abs(arr[1]-arr[0]);
            int last=Math.abs(arr[n-1]-arr[n-2]);
            long max=0;
            for(int i=1;i<n-1;i++){
                long rem=Math.max(Math.abs(arr[i+1]-arr[i])+Math.abs(arr[i]-arr[i-1])-Math.abs(arr[i+1]-arr[i-1]),max);
                max=Math.max(rem,max);
            }
            sum-=(Math.max(max,Math.max(first,last)));
            System.out.println(sum);
        }


        out.close();
    }
}