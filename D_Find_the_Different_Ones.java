import java.io.*;
import java.util.*;

public class D_Find_the_Different_Ones{
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
            int q=in.nextInt();
            int[][] queries=new int[q][2];

            for(int i=0;i<q;i++){
                for(int j=0;j<2;j++){
                    queries[i][j]=in.nextInt();
                }
            }

            int[] lastDiff=new int[n];
            lastDiff[0]=-1;
            for(int i=1;i<n;i++){
                if(arr[i-1]==arr[i]){
                    lastDiff[i]=lastDiff[i-1];
                }else{
                    lastDiff[i]=i-1;
                }
            }

            for(int i=0;i<q;i++){
                int l=queries[i][0];
                int r=queries[i][1];

                if(lastDiff[l-1]==lastDiff[r-1]){
                    System.out.println("-1 -1");
                }else{
                    System.out.println((lastDiff[r-1]+1)+" "+r);
                }
            }
            System.out.println();
        }


        out.close();
    }
}