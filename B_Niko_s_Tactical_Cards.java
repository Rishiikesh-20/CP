import java.io.*;
import java.util.*;

public class B_Niko_s_Tactical_Cards{
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
            long[] a=new long[n];
            long[] b=new long[n];

            for(int i=0;i<n;i++){
                a[i]=in.nextLong();
            }
            for(int i=0;i<n;i++){
                b[i]=in.nextLong();
            }
            long min=0,max=0;
            for(int i=0;i<n;i++){
                ArrayList<Long> list=new ArrayList<>();
                list.addAll(List.of(min-a[i],max-a[i],b[i]-max,b[i]-min));
                Collections.sort(list);
                min=list.getFirst();
                max=list.getLast();
            }
            System.out.println(max);
        }

        out.close();
    }
}