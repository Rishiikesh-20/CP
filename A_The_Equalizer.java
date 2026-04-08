import java.io.*;
import java.util.*;

public class A_The_Equalizer{
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
            int k=in.nextInt();
            int[] arr=new int[n];
            long sum=0;
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                sum+=arr[i];
            }

            if(sum%2==1){
                System.out.println("YES");
                continue;
            }

            if((n*k)%2==0){
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }


        out.close();
    }
}