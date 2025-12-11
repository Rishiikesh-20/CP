import java.io.*;
import java.util.*;

public class E_Negatives_and_Positives{
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
            int count=0;
            long sum=0;
            int flag=0;
            int min=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                if(arr[i]<0) count++;
                sum+=Math.abs(arr[i]);
                if(arr[i]==0) flag=1;
                min=Math.min(min,Math.abs(arr[i]));
            }

            if(count%2==0 || flag==1){
                System.out.println(sum);
                continue testcase;
            }
            System.out.println(sum-2*min);
            
        }


        out.close();
    }
}