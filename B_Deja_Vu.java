import java.io.*;
import java.util.*;

public class B_Deja_Vu{
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
            int q=in.nextInt();
            long[] a=new long[n];
            int[] x=new int[q];
            for(int i=0;i<n;i++){
                a[i]=in.nextLong();
            }
            for(int i=0;i<q;i++){
                x[i]=in.nextInt();
            }
            int min=31;
            for(int i=0;i<q;i++){
                if(x[i]>=min) continue;
                for(int j=0;j<n;j++){
                    if(a[j]%(1L<<(x[i]))==0){
                        a[j]+=(1L<<(x[i]-1));
                    }
                }
                min=Math.min(min,x[i]);
            }
            for(int i=0;i<n;i++){
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }


        out.close();
    }
}