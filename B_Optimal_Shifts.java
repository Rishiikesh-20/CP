import java.io.*;
import java.util.*;

public class B_Optimal_Shifts{
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
            String s=in.next();
            s=s+s;
            int max=0;
            int cur=0;
            for(int i=0;i<2*n;i++){
                if(s.charAt(i)=='0'){
                    cur++;
                    max=Math.max(cur,max);
                }else{
                    cur=0;
                }
            }
            System.out.println(max);
        }


        out.close();
    }
}