import java.io.*;
import java.util.*;

public class C_Triple_Removal{
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
            int q=in.nextInt();

            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            int sum=0;
            int sum1=0;
            int[] preSum=new int[n];
            int[] diffSum=new int[n];
            for(int i=0;i<n;i++){
                sum+=arr[i];
                preSum[i]=sum;

                if(i!=n-1){
                    sum1+=arr[i]==arr[i+1]?1:0;
                    diffSum[i]=sum1;
                }
            }
            if(n>1){
                diffSum[n-1]=diffSum[n-2];
            }
            while(q-->0){
                int l=in.nextInt();
                int r=in.nextInt();
                int found=0;
                if((r-l+1)%3!=0){
                    System.out.println(-1);
                    continue;
                }
                int s=preSum[r-1]-preSum[l-1]+arr[l-1];
                int temp=0;
                if(r<n && arr[r-1]==arr[r]){
                    temp=1;
                }
                found=(diffSum[r-1]-diffSum[l-1]-temp)>0?1:0;

                if(s%3!=0){
                    System.out.println(-1);
                    continue;
                }
                int result=(r-l+1)/3;
                if(found==1){
                    System.out.println(result);
                    continue;
                }else{
                    System.out.println(result+1);
                    continue;
                }
            }
        }


        out.close();
    }
}