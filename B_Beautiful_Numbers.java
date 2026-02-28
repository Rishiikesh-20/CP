import java.io.*;
import java.util.*;

public class B_Beautiful_Numbers{
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

    public static long sumOfDigits(long x,PriorityQueue<Long> pq){
        long sum=0;
        while(x>0){
            long rem=x%10;
            if((x/10)==0){
                pq.add(rem-1);
                
            }else pq.add(rem);
            sum+=rem;
            x=x/10;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        int t=in.nextInt();
        testcase: while(t-->0){
            long x=in.nextLong();

            PriorityQueue<Long> pq=new PriorityQueue<>((a,b)->Long.compare(b,a));
            long sum=sumOfDigits(x,pq);

            long rem=sum-9;

            if(rem<=0){
                System.out.println(0);
                continue;
            }

            long count=0;
            while(!pq.isEmpty() ){
                long num=pq.poll();
                rem-=num;
                count++;

                if(rem<=0){
                    break;
                }
            }

            System.out.println(count);


        }


        out.close();
    }
}