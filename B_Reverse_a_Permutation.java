import java.io.*;
import java.util.*;

public class B_Reverse_a_Permutation{
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
            int start=-1;
            for(int i=0;i<n;i++){
                if(arr[i]!=(n-i)){
                    start=i;
                    break;
                }else{
                    System.out.print(arr[i]+" ");
                }
            }
            if(start==-1){
                System.out.println();
                continue;
            }

            int maxInd=start;
            for(int i=start;i<n;i++){
                if(arr[maxInd]<arr[i]){
                    maxInd=i;
                }
            }
            for(int i=maxInd;i>=start;i--){
                System.out.print(arr[i]+" ");
            }
            for(int i=maxInd+1;i<n;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();

        }


        out.close();
    }
}