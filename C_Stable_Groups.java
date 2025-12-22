import java.io.*;
import java.util.*;

public class C_Stable_Groups{
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

       
        int n=in.nextInt();
        long k=in.nextLong();
        long x=in.nextLong();


        long[] arr=new long[n];

        for(int i=0;i<n;i++){
            arr[i]=in.nextLong();
        }

        Arrays.sort(arr);

        PriorityQueue<Long> pq=new PriorityQueue<>();

        for(int i=0;i<n-1;i++){
            if(arr[i+1]-arr[i]>x){
                pq.add(arr[i+1]-arr[i]);
            }
        }
        int count=1;
        while(!pq.isEmpty()){
            long val=pq.poll();
            
            long l=(val-1)/x;
            if(l<=k){
                k-=l;
            }else{
                count++;
            }
        }
        
        System.out.println(count);

        out.close();
    }
}