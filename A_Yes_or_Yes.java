import java.io.*;
import java.util.*;

public class A_Yes_or_Yes{
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
            String s=in.next();

            int count=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='Y'){
                    count++;
                }
            }
            if(count>1){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }


        out.close();
    }
}