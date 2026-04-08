import java.io.*;
import java.util.*;

public class C_Scoring_Subsequences{
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
            
            for(int k=0;k<n;k++){
                // int[] suffProduct=new int[k+1];
                // suffProduct[k]=arr[k];
                // for (int i=k-1;i>=0;i--){
                //     suffProduct[i]=suffProduct[i+1]*arr[i]/(k-i+1);
                // }

                int low=0;
                int high=k;
                int ans=-1;
                while(low<=high){
                    int mid=low+(high-low)/2;
                    int val=arr[mid]/(k-mid+1);
                    // System.out.println(
                    //     "Mid: "+mid+" Val: "+val
                    // );
                    if(val<1){
                        low=mid+1;
                    }else{
                        ans=mid;
                        high=mid-1;
                    }
                }
                // System.out.println("Ans:" + ans);
                System.out.print((k-ans+1)+" ");
            }
            System.out.println();
        }


        out.close();
    }
}