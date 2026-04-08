import java.io.*;
import java.util.*;

public class C_The_67_th_Permutation_Problem{
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
            int total=n*3;

            int k=n+1;
            int i=1;
            int[] ans=new int[n*3];
            for(int j=0;j<n;j++){
                ans[j*3]=i;
                ans[j*3+1]=k;
                ans[j*3+2]=k+1;
                k+=2;
                i++;
            }

            for(int j=0;j<3*n;j++){
                System.out.print(ans[j]+" ");
            }
            System.out.println();
        }


        out.close();
    }
}