import java.io.*;
import java.util.*;

public class E_Mirror_Grid{
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
            char[][] grid=new char[n][n];

            for(int i=0;i<n;i++){
                String s=in.next();
                grid[i]=s.toCharArray();
                
            }
            int result=0;
            for(int i=0;i<(n+1)/2;i++){
                for(int j=0;j<n/2;j++){
                    int val1=grid[j][n-i-1]=='0'?0:1;
                    int val2=grid[n-i-1][n-j-1]=='0'?0:1;
                    int val3=grid[n-j-1][i]=='0'?0:1;
                    int sum=val1+val2+val3+(grid[i][j]=='0'?0:1);
                    //System.out.println("Here 1 "+sum);
                    if(sum==4 || sum==0)continue;
                    //System.out.println("Here 2");
                    int min=Math.min(sum,4-sum);
                    result+=min;
                }
            }
            System.out.println(result);
        }


        out.close();
    }
}