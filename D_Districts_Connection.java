import java.io.*;
import java.util.*;

public class D_Districts_Connection{
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
            HashSet<Integer> set=new HashSet<>();
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                set.add(arr[i]);
            }
            if(set.size()==1){
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
            int temp=0;
            for(int i=1;i<n;i++){
                if(arr[i]!=arr[0]) {
                    System.out.println(1+" "+(i+1));temp=i+1;
                }
            }
            for(int i=1;i<n;i++){
                if(arr[i]==arr[0]) {
                    System.out.println(temp+" "+(i+1));
                }
            }

        }


        out.close();
    }
}