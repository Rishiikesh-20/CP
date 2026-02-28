import java.io.*;
import java.util.*;

public class C_Restricted_Sorting{
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
            int[] copy=new int[n];
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                copy[i]=arr[i];
                min=Math.min(min,arr[i]);
                max=Math.max(max,arr[i]);
            }
            Arrays.sort(copy);
            int result=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(arr[i]!=copy[i]){
                    int val=Math.max(Math.abs(arr[i]-min),Math.abs(arr[i]-max));
                    result=Math.min(val,result);
                } 
            }
            if(result==Integer.MAX_VALUE){
                System.out.println(-1);
                continue;
            }
            System.out.println(result);
        }


        out.close();
    }
}