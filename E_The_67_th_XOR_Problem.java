import java.io.*;
import java.util.*;

public class E_The_67_th_XOR_Problem{
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
            int[] arr=new int[n];

            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }

            int max=0;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    max=Math.max(max,arr[i]^arr[j]);
                }
            }
            System.out.println(max);
        }


        out.close();
    }
}