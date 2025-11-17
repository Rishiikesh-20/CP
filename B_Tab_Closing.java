import java.io.*;
import java.util.*;

public class B_Tab_Closing{
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
            long a=in.nextLong();
            long b=in.nextLong();
            long n=in.nextLong();

            if(a==b || b<=a/n){
                System.out.println(1);
                continue testcase;
            }
            //int count=1;
            //long pos=a/n;
            // for(int i=1;i<n;i++){
            //     pos=pos+a/(n-i);
            //     if(pos<b){
            //        continue;
            //     }else{
            //         count++;
            //         break;
            //     }
            // }

            if(a>b){
                System.out.println(2);
            }else{
                System.out.println(1);
            }
            //System.out.println(count);
        }


        out.close();
    }
}