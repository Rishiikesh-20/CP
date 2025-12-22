import java.io.*;
import java.util.*;

public class B_Pleasant_Pairs{
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

    public static int compute(int[] arr,int i,int j){
        int result=(i+j)/arr[i-1];
        return result;
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
            int count=0;
            for(int i=0;i<n;i++){
                int k=(2*(i+1)/arr[i])+1;
                int j=k*arr[i]-(i+1)-1;
                //System.out.println("i: "+i+" k: "+k+" j: "+j);

                while(j<n){
                    //System.out.println("i: "+i+" k: "+k+" j: "+j);
                    int val=compute(arr,i+1,j+1);
                    if(val==arr[j]){
                        count++;
                    }
                    //System.out.println("Val: "+val);
                    k++;
                    j=k*arr[i]-(i+1)-1;
                }
            }
            System.out.println(count);
        }


        out.close();
    }
}