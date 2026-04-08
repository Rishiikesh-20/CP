import java.io.*;
import java.util.*;

public class B_Flip_the_Bit_Easy_Version{
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
            int k=in.nextInt();

            int[] arr=new int[n];

            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            int ind=in.nextInt();

            ind-=1;

            int val=arr[ind];

            int left=0;

            for(int i=0;i<=ind-1;i++){
                if((val^1)==arr[i] && (i==0 ||  arr[i-1]!=(val^1))){
                    left++;
                }
            }

            int right=0;

            for(int i=ind+1;i<n;i++){
                if((val^1)==arr[i] && (i==0 ||  arr[i-1]!=(val^1))){
                    right++;
                }
            }

            int two=Math.min(left,right);
            int one=Math.abs(left-right);

            System.out.println(one*2+two*2);
        }


        out.close();
    }
}