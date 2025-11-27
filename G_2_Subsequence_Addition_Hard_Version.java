import java.io.*;
import java.util.*;

public class G_2_Subsequence_Addition_Hard_Version{
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
            int[] c=new int[n];

            for(int i=0;i<n;i++){
                c[i]=in.nextInt();
            }
            long sum=1;
            Arrays.sort(c);
            if(sum<c[0]){
                System.out.println("NO");
                continue testcase;
            }
            if(n==1){
                System.out.println("YES");
                continue testcase;
            }
            for(int i=1;i<n;i++){
                if(sum<c[i]){
                    System.out.println("NO");
                    continue testcase;
                }
                sum+=c[i];
            }
            System.out.println("YES");
        }


        out.close();
    }
}