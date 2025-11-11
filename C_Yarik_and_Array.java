import java.io.*;
import java.util.*;

public class C_Yarik_and_Array{
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
                System.out.println(arr[0]);
                continue testcase;
            }
            int max=Integer.MIN_VALUE;
            int curr=0;
            for(int i=0;i<n-1;i++){
                if(Math.abs(arr[i]%2)!=Math.abs(arr[i+1]%2)){
                    curr+=arr[i];
                    max=Math.max(max,curr);
                    if(curr<0){
                        curr=0;
                        continue;
                    }
                    
                }else{
                    curr+=arr[i];
                    max=Math.max(max,curr);
                    if(curr<0){
                        curr=0;
                        continue;
                    }
                    curr=0;
                }
            }
            curr+=arr[n-1];
            max=Math.max(max,curr);
            
            System.out.println(max);
        }


        out.close();
    }
}