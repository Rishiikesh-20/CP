import java.io.*;
import java.util.*;

public class C_Cyclic_Merging{
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
            long ans=0;
            int max=0;
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                if(arr[i]>arr[max]){
                    max=i;
                }
            }
            if(n==2){
                System.out.println(Math.max(arr[0],arr[1]));
                continue testcase;
            }
            for(int i=0;i<n-1;i++){
                ans+=Math.max(arr[i],arr[i+1]);
                if(i==0){
                    ans+=Math.max(arr[i],arr[n-1]);
                }
            }
            ans-=arr[max];
            System.out.println(ans);   
        }


        out.close();
    }
}