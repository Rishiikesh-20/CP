import java.io.*;
import java.util.*;

public class B_AND_Sorting{
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
            if(arr[0]!=0){
                System.out.println(0);
                continue testcase;
            }
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(i!=arr[i]) list.add(arr[i]);
            }
            long max=list.get(0);
            for(Integer i:list){
                max&=i;
            }
            System.out.println(max);
        }


        out.close();
    }
}