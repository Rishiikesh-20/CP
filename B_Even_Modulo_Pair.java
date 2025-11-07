import java.io.*;
import java.util.*;

public class B_Even_Modulo_Pair{
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
        testcase:
        while(t-->0){
            int n=in.nextInt();
            long[] arr=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextLong();
            }
            if(arr[0]==1){
                System.out.println(arr[0]+" "+arr[1]);
                continue testcase;
            }
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if((arr[j]%arr[i])%2==0){
                        System.out.println(arr[i]+" "+arr[j]);
                        continue testcase;
                    }
                }
            }
            System.out.println(-1);    
        }


        out.close();
    }
}