import java.io.*;
import java.util.*;

public class E_1_Rudolf_and_Snowflakes_simple_version{
    static int MAX_ELE=1_000_000;
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
        boolean[] isPossible=new boolean[MAX_ELE+1];

        for(int i=2;1+i+i*i<=MAX_ELE;i++){
            long cur=i*i*i;
            long cur1=(cur-1)/(i-1);

            while(cur1<=MAX_ELE){
                isPossible[(int)cur1]=true;
                cur*=i;
                cur1=(cur-1)/(i-1);
            }
        }
        testcase: while(t-->0){
            int n=in.nextInt();
            if(isPossible[n]==true){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }


        out.close();
    }
}