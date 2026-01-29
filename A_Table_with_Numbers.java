import java.io.*;
import java.util.*;

public class A_Table_with_Numbers{
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
            int h=in.nextInt();
            int l=in.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            Arrays.sort(arr);
            int temp=Math.max(h,l);
            int ind=-1;
            for(int i=n-1;i>=0;i--){
                if(arr[i]<=temp){
                    ind=i;
                    break;
                }
            }
            if(ind==-1){
                System.out.println(0);
                continue testcase;
            }
            temp=Math.min(h,l);
            int count=0;
            for(int i=0;i<(ind+1)/2;i++){
                if(arr[i]<=temp){
                    count++;
                }else{
                    break;
                }
            }

            if(count==(ind+1)/2){
                System.out.println((ind+1)/2);
                continue testcase;
            }
            System.out.println(Math.min(count,(ind+1)/2));   
        }
        out.close();
    }

}