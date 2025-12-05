import java.io.*;
import java.util.*;

public class B_Fun_with_Even_Subarrays{
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
            int lastEle=arr[n-1];
            int l=0;
            int r=n-1;
            for(int i=0;i<n;i++){
                if(arr[i]==lastEle){
                    l++;
                }else{
                    break;
                }
            }
            if(l==n-1){
                System.out.println(0);
                continue testcase;
            }
            for(int i=n-1;i>=0;i--){
                if(arr[i]==lastEle){
                    r--;
                }else{
                    break;
                }
            }
            int count=0;
            while(r>=l){
                count++;
                r-=(n-r-1);

                while(r>=l && arr[r]==lastEle){
                    r--;
                }
            }
            System.out.println(count);
        }
        out.close();
    }
}