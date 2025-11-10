import java.io.*;
import java.util.*;

public class C_Dora_and_Search{
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
            int min=1;
            int max=n;
            int i=0,j=n-1;
            while(j-i+1>=4){
                if(arr[i]!=min && arr[j]!=max && arr[i]!=max && arr[j]!=min){
                    System.out.println((i+1)+" "+(j+1));
                    continue testcase;
                }else{
                    if(arr[i]==min){
                        i++;
                        min++;
                    }else if(arr[i]==max){
                        i++;
                        max--;
                    }else if(arr[j]==min){
                        j--;
                        min++;
                    }else{
                        j--;
                        max--;
                    }
                }
            }
            System.out.println(-1+"");
            
        }
        out.close();
    }
}