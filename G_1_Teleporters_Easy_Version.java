import java.io.*;
import java.util.*;

public class G_1_Teleporters_Easy_Version{
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
            int c=in.nextInt();
            long[] arr=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextLong();
                arr[i]+=(i+1);
            }
            Arrays.sort(arr);
            long result=0;
            for(int i=0;i<n;i++){
                c-=arr[i];
                if(c<0){
                    System.out.println(result);
                    continue testcase;
                }
                result++;
            }
            System.out.println(result);
        }


        out.close();
    }
}