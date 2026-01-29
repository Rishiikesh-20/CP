import java.io.*;
import java.util.*;

public class B_Impost_or_Sus{
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
            int n=s.length();
            int result=0;
            if(s.charAt(0)=='u') result++;
            if(s.charAt(n-1)=='u') result++;

            int cur=0;
            for(int i=1;i<n-1;i++){
                if(s.charAt(i)=='s'){
                    result+=(cur/2);
                    cur=0;
                }else{
                    cur++;
                }
            }
            result+=(cur/2);
            System.out.println(result);
        }


        out.close();
    }
}