import java.io.*;
import java.util.*;

public class B_Subtract_Operation{
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
            HashSet<Integer> set=new HashSet<>();
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                set.add(arr[i]);
            }
            
            for(int i=0;i<n;i++){
                if(set.contains(arr[i]-k)){
                    System.out.println("YES");
                    continue testcase;
                }
            }
            System.out.println("NO");
        }


        out.close();
    }
}