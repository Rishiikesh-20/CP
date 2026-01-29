import java.io.*;
import java.util.*;

public class C_Blackslex_and_Number_Theory{
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
            Arrays.sort(arr);

            int temp=Math.max(0,arr[1]-2*arr[0]);
            int pos=arr[0]+temp;
            System.out.println(pos);
        }


        out.close();
    }
}