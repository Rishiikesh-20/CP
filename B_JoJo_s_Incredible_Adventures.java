import java.io.*;
import java.util.*;

public class B_JoJo_s_Incredible_Adventures{
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
            long n=s.length();
            String ss=s+s;
            long max=0;
            long curr=0;
            for(int i=0;i<ss.length();i++){
                if(ss.charAt(i)=='1'){
                    curr++;
                }else{
                    curr=0;
                }
                max=Math.max(max,curr);
            }
            if(max>n){
                System.out.println(n*n);
                continue testcase;
            }else{
                long side1=(max+1)/2;
                long side2=(max+2)/2;
                System.out.println(side1*side2);
            }

        }


        out.close();
    }
}