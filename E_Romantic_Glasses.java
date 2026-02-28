import java.io.*;
import java.util.*;

public class E_Romantic_Glasses{
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
            if(n==1){
                System.out.println("NO");
                continue;
            }
            long[] preSum=new long[n];
            preSum[0]=arr[0];
            for(int i=1;i<n;i++){
                if(i%2==0){
                    //odd
                    preSum[i]=preSum[i-1]+arr[i];
                }else{
                    preSum[i]=preSum[i-1]-arr[i];
                }
            }
            // System.out.println(Arrays.toString(preSum));
            HashSet<Long> hash=new HashSet<>();
            hash.add((long)0);
            for(int i=0;i<n;i++){
                if(hash.contains(preSum[i])){
                    System.out.println("YES");
                    continue testcase;
                }
                hash.add(preSum[i]);
            }
            System.out.println("NO");

        }


        out.close();
    }
}