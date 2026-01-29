import java.io.*;
import java.util.*;

public class C_Huge_Pile{
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
            //System.out.println("NEW");
            long n=in.nextLong();
            long k=in.nextLong();
            long result=-1;
            int count=0;
            if(n==k){
                System.out.println(count);
                continue testcase;
            }
            while(n>1){
                //System.out.println("N: "+n);
                count++;
                long min=n/(long)(Math.pow(2,count));
                long max=(long)Math.ceil((double)n/Math.pow(2,count));

                if(max==k || min==k){
                    System.out.println(count);
                    continue testcase;
                }
                if(max<k){
                    break;
                }

            }
            System.out.println(result);
        }


        out.close();
    }
}