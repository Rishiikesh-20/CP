import java.io.*;
import java.util.*;

public class B_The_67_th_6_7_Integer_Problem{
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
            int[] arr=new int[7];
            for(int i=0;i<7;i++){
                arr[i]=in.nextInt();
            }
            Arrays.sort(arr);
            long sum=0;
            for(int i=0;i<6;i++){
                sum+=(-1*arr[i]);
            }
            sum+=arr[6];
            System.out.println(sum);
        }


        out.close();
    }
}