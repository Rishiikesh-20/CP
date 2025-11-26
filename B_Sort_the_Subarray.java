import java.io.*;
import java.util.*;

public class B_Sort_the_Subarray{
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
            long[] arr1=new long[n];
            long[] arr2=new long[n];
            for(int i=0;i<n;i++){
                arr1[i]=in.nextLong();
            }
            for(int i=0;i<n;i++){
                arr2[i]=in.nextLong();
            }
            int l=0;
            int r=0;
            for(int i=0;i<n;i++){
                if(arr1[i]!=arr2[i]){
                    l=i;
                }
            }

            for(int i=n-1;i>=0;i--){
                if(arr1[i]!=arr2[i]){
                    r=i;
                }
            }
            while(l>0 && arr2[l]>=arr2[l-1]){
                l--;
            }
            while(r<n-1 && arr2[r]<=arr2[r+1]){
                r++;
            }
            System.out.println((l+1)+" "+(r+1));
        }


        out.close();
    }
    
}
class Pair{
    int l;
    int r;
    Pair(int l,int r){
        this.l=l;
        this.r=r;
    }
    int len(){
        return this.r-this.l+1;
    }
}