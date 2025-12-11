import java.io.*;
import java.util.*;

public class A_Little_Fairy_s_Painting{
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
            int count=0;
            TreeSet<Integer> set=new TreeSet<>();
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                if(!set.contains(arr[i])){
                    count++;
                }
                set.add(arr[i]);
            }
            Integer min=set.ceiling(count);
            if(min-count>=0)
                System.out.println(count+(min-count));
            else
                System.out.println(count);

        }


        out.close();
    }
}