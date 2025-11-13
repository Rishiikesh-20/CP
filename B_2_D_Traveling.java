import java.io.*;
import java.util.*;

public class B_2_D_Traveling{
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
            int a=in.nextInt();
            int b=in.nextInt();
            
            List<Pair> list=new ArrayList<>();

            for(int i=1;i<=n;i++){
                long x=in.nextLong();
                long y=in.nextLong();
                list.add(new Pair(x,y));
            }

            if(a<=k && b<=k){
                System.out.println(0);
                continue testcase;
            }

            Pair start=list.get(a-1);
            Pair end=list.get(b-1);
            long result=Math.abs(start.x-end.x)+Math.abs(start.y-end.y);
            if(k<=1){
                System.out.println(result);
                continue testcase;
            }
            long min1=Long.MAX_VALUE;
            long min2=Long.MAX_VALUE;
            if(a<=k){
                min1=0;
            }
            if(b<=k){
                min2=0;
            }
            for(int i=0;i<k;i++){
                long val1=Math.abs(start.x-list.get(i).x)+Math.abs(start.y-list.get(i).y);
                min1=Math.min(val1,min1);

                long val2=Math.abs(end.x-list.get(i).x)+Math.abs(end.y-list.get(i).y);
                min2=Math.min(val2,min2);
            }
            result=Math.min(result,min1+min2);
            System.out.println(result);
        }


        out.close();
    }
}
class Pair{
    long x;
    long y; 
    Pair(long x,long y){
        this.x=x;
        this.y=y;
    }
}