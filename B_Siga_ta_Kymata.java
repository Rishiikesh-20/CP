import java.io.*;
import java.util.*;

public class B_Siga_ta_Kymata{
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
            int maxInd=-1;
            int minInd=-1;
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                if(arr[i]==1) minInd=i;
                if(arr[i]==n) maxInd=i;
            }
            String s=in.next();
            if(s.charAt(0)=='1' || s.charAt(n-1)=='1' || s.charAt(minInd)=='1' || s.charAt(maxInd)=='1'){
                out.println("-1");
                continue testcase;
            }
            int x=1;
            int y=n;
            maxInd++;
            minInd++;
            out.println(5);
            out.println(x+" "+y);
            out.println(x+" "+maxInd);
            out.println(maxInd+" "+y);
            out.println(x+" "+minInd);
            out.println(minInd+" "+y);
        }


        out.close();
    }
}