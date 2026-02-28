import java.io.*;
import java.util.*;

public class B_Offshores{
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
            int x=in.nextInt();
            int y=in.nextInt();

            int[] arr=new int[n];
            long total=0;
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                total+=arr[i];
            }
            long max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                int val=arr[i]/x;
                long temp=val*(x-y)+arr[i]-val*x;
                max=Math.max(temp,max);
                total-=temp;
            }
            total+=max;
            System.out.println(total);
            

        }

        out.close();
    }
}