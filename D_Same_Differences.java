import java.io.*;
import java.util.*;

public class D_Same_Differences{
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
            long[] arr=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }

            HashMap<Long,Long> map=new HashMap<>();

            for(int i=0;i<n;i++){
                if(!map.containsKey(arr[i]-i)){
                    map.put(arr[i]-i,(long)0);
                }
                map.put(arr[i]-i,map.get(arr[i]-i)+1);
            }
            long count=0;
            for(Long val:map.values()){
                if(val<=1) continue;
                count=count+(val*(val-1)/2);
            }
            System.out.println(count);

        }


        out.close();
    }
}