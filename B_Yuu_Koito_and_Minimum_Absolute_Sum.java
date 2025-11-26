import java.io.*;
import java.util.*;

public class B_Yuu_Koito_and_Minimum_Absolute_Sum{
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
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            int ans=0;
            if(arr[0]==-1 && arr[n-1]==-1){
                ans=0;
                arr[0]=0;
                arr[n-1]=0;
            }else if(arr[0]==-1){
                ans=0;
                arr[0]=arr[n-1];
            }else if(arr[n-1]==-1){
                ans=0;
                arr[n-1]=arr[0];
            }else{
                ans=Math.abs(arr[n-1]-arr[0]);
            }
            System.out.println(ans);
            for(int i=0;i<n;i++){
                if(arr[i]==-1){
                    System.out.print(0+" ");
                }else{
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();

        }


        out.close();
    }
}