import java.io.*;
import java.util.*;

public class A_Shizuku_Hoshikawa_and_Farm_Legs{
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
            if(n%2==1) {
                System.out.println(0);
                continue testcase;
            }
            int count=0;
            for(int i=0;i<=n;i+=2){
                if((n-i)%4==0) count++;
            }
            System.out.println(count);
        }


        out.close();
    }
}