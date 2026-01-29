import java.io.*;
import java.util.*;

public class D_Monster_Game{
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
            long[] a=new long[n];
            long[] b=new long[n];

            for(int i=0;i<n;i++){
                a[i]=in.nextInt();
            }
            for(int i=0;i<n;i++){
                b[i]=in.nextInt();
            }
            Arrays.sort(a);
            long[] prefixSum=new long[n];
            prefixSum[0]=b[0];
            for(int i=1;i<n;i++){
                prefixSum[i]=prefixSum[i-1]+b[i];
            }
            long max=0;
            for(int i=0;i<n;i++){
                long ind=n-prefixSum[i];
                if(ind<0){
                    break;
                }
                int x=(int)a[(int)ind];
                //System.out.println("i: "+i+" x: "+x+" level : "+(i+1));
                max=Math.max(x*(long)(i+1),max);
                //System.out.println("Max: "+max);
            }
            System.out.println(max);
        }


        out.close();
    }
}