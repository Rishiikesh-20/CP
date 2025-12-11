import java.io.*;
import java.util.*;

public class A_Sleeping_Through_Classes{
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
            int k=in.nextInt();
            String s=in.next();
            int count=0;
            int lastOne=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                char ch=s.charAt(i);
                if(ch=='0' && lastOne<=i-k-1){
                    count++;
                }else if(ch=='1'){
                    lastOne=i;
                }
            }
            System.out.println(count);
        }


        out.close();
    }
}