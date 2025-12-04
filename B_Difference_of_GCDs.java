import java.io.*;
import java.util.*;

public class B_Difference_of_GCDs{
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
            int l=in.nextInt();
            int r=in.nextInt();
            ArrayList<Integer> arr=new ArrayList<>();

            for(int i=1;i<=n;i++){
                int val=(l/i)*i;
                if(val<l){
                    val+=i;
                }
                if(val>r){
                    System.out.println("NO");
                    continue testcase;
                }
                arr.add(val);
            }
            System.out.println("YES");
            for(Integer i:arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }


        out.close();
    }
}