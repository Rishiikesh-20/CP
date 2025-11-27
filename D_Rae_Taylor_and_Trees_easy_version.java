import java.io.*;
import java.util.*;

public class D_Rae_Taylor_and_Trees_easy_version{
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
            int[] preMin=new int[n];
            int[] sufMax=new int[n];
            preMin[0]=arr[0];
            sufMax[n-1]=arr[n-1];
            for(int i=1;i<n;i++){
                preMin[i]=Math.min(arr[i],preMin[i-1]);
            }
            for(int i=n-2;i>=0;i--){
                sufMax[i]=Math.max(arr[i],sufMax[i+1]);
            }

            for(int i=0;i<n-1;i++){
                if(preMin[i]>sufMax[i+1]){
                    System.out.println("No");
                    continue testcase;
                }
            }
            System.out.println("Yes");
        }


        out.close();
    }
}