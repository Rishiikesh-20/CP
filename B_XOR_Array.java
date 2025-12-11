import java.io.*;
import java.util.*;

public class B_XOR_Array{
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
            int l=in.nextInt();
            int r=in.nextInt();

            int[] preXor=new int[n+1];
            for(int i=0;i<=n;i++){
                if(i==r){
                    preXor[i]=l-1;
                }else{
                    preXor[i]=i;
                }
            }
            for(int i=1;i<=n;i++){
                System.out.print((preXor[i]^preXor[i-1])+" ");
            }
            System.out.println();
        }


        out.close();
    }
}