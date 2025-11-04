import java.io.*;
import java.util.*;

public class B_Make_it_Zigzag{
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
            int[] arr=new int[n];
            int[] maxArr=new int[n];
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                if(arr[i]>max){
                    max=arr[i];
                }
                maxArr[i]=max;
            }
            int result=0;
            for(int i=0;i<n;i++){
                if(i%2==0){
                    // odd
                    if(i-1>=0){
                        arr[i-1]=maxArr[i-1];
                        if(arr[i]>=arr[i-1]){
                            int diff=arr[i]-arr[i-1]+1;
                            arr[i]=arr[i]-diff;
                            result+=diff;
                        }
                    }
                    if(i+1<n){
                        arr[i+1]=maxArr[i+1];
                        if(arr[i]>=arr[i+1]){
                            int diff=arr[i]-arr[i+1]+1;
                            arr[i]=arr[i]-diff;
                            result+=diff;
                        }
                    }  
                }else{
                    arr[i]=maxArr[i];
                    if(i-1>=0){
                        if(arr[i]<=arr[i-1]){
                            int diff=arr[i-1]-arr[i]+1;
                            arr[i-1]=arr[i-1]-diff;
                            result+=diff;
                        }
                    }
                    if(i+1<n){
                        if(arr[i]<=arr[i+1]){
                            int diff=arr[i+1]-arr[i]+1;
                            arr[i+1]=arr[i+1]-diff;
                            result+=diff;
                        }
                    }  
                }
            }
            System.out.println(result);
            
        }


        out.close();
    }
}