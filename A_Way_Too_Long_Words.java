import java.io.*;
import java.util.*;

public class A_Way_Too_Long_Words{
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
            String s=in.nextLine();
            if(s.length()<=10){
                System.out.println(s);
                continue;
            }
            long internalStringLength=s.length()-2;
            System.out.println(s.charAt(0)+""+internalStringLength+""+s.charAt(s.length()-1));
        }


        out.close();
    }
}