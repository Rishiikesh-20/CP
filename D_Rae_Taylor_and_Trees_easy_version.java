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
            int[] preSum=new int[n];
            int ind=-1;
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                if(arr[i]==1){
                    ind=i;
                }
            }
            if(arr[0]==1){
                System.out.println("Yes");
                continue testcase;
            }else if(arr[0]==n){
                System.out.println("No");
                continue testcase;
            }
            preSum[0]=arr[0];
            for(int i=1;i<n;i++){
                preSum[i]=preSum[i-1]+arr[i];
            }
            int diff=preSum[n-1]-preSum[ind-1];
            int len=n-ind;
            int actual=len*(len+1)/2;
            if(diff==actual){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }


        out.close();
    }
}