import java.io.*;
import java.util.*;

public class B_Playing_in_a_Casino{
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
            int n=in.nextInt();
            int m=in.nextInt();
            int[][] arr=new int[m][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[j][i]=in.nextInt();
                }
            }
            if(n==1){
                System.out.println(0);
                continue;
            }
            long result=0;

            for(int i=0;i<m;i++){
                Arrays.sort(arr[i]);
                for(int j=0;j<n;j++){
                    // min=Math.min(min,arr[i][j]);
                    // max=Math.max(max,arr[i][j]);
                    result=result+(j*(long)(arr[i][j]))-(long)((n-1-j)*((long)arr[i][j]));
                } 
            }
            System.out.println(result);
        }


        out.close();
    }
}