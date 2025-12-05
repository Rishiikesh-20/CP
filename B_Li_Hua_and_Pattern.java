import java.io.*;
import java.util.*;

public class B_Li_Hua_and_Pattern{
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
            int[][] arr=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=in.nextInt();
                }
            }
            if(n==1){
                System.out.println("YES");
                continue testcase;
            }
            int count=0;
            for(int i=0;i<n-1;i++){
                for(int j=0;j<n-i-1;j++){
                    int id=n-i-1;
                    int jd=n-j-1;

                    if(arr[i][j]!=arr[id][jd]){
                        count++;
                    }
                }
            }
            for(int i=0;i<n/2;i++){
                int j=n-i-1;
                
                int id=n-i-1;
                int jd=n-j-1;

                if(arr[i][j]!=arr[id][jd]){
                    count++;
                }
            }

            if(count>k){
                System.out.println("NO");
            }else if(n%2!=0){
                System.out.println("YES");
            }else{
                int diff=k-count;
                if(diff%2==0){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }


        out.close();
    }
}