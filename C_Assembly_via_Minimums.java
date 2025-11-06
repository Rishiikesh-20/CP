import java.io.*;
import java.util.*;

public class C_Assembly_via_Minimums{
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
            int size=n*(n-1)/2; 
            long[] arr=new long[size];
            for(int i=0;i<size;i++){
                arr[i]=in.nextLong();
            }
            Arrays.sort(arr);
            int ind=0;
            for(int i=1;i<n;i++){
                System.out.print(arr[ind]+" ");
                ind+=(n-i);
            }
            System.out.println(arr[size-1]);
        }
        out.close();
    }
}