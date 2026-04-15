import java.io.*;
import java.util.*;

public class D_Flip_the_Bit_Hard_Version{
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
            int[] ind=new int[k];

            for(int i=0;i<k;i++){
                ind[i]=in.nextInt()-1;
            }

            int val=arr[ind[0]];

            int[] visited=new int[n];

            Arrays.sort(ind);
            int last=0;
            int j=0;
            for(int i=0;i<k;i++){
                int left=0;
                int right=0;
                for(j=last;j<ind[i];j++){
                    if((val^1)==arr[j] && (j==0 || arr[j-1]!=arr[j])){
                        left++;
                    }
                }
                for(j=ind[i]+1;j<n;j++){
                    if(arr[j]==1)
                    if((val^1)==arr[j] && (j==0 || arr[j-1]!=arr[j])){
                        left++;
                    }
                }
                last=j+1;
            }


            int two=Math.min(left,right);
            int one=Math.abs(left-right);

            System.out.println(one*2+two*2);
        }


        out.close();
    }
}