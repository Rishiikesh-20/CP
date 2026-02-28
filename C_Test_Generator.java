import java.io.*;
import java.util.*;

public class C_Test_Generator{
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
            long s=in.nextLong();
            long m=in.nextLong();

            long copyS=s;
            long copyM=m;
            int count=0;
            long sum=0;
            long num=s&m;
            sum+=num;
            //System.out.println("Sum= :"+sum);
            s-=num;
            while(s>0){
                s=s/2;
                count++;
                num=s&m;
               // System.out.println("Num: "+num);
                sum+=(num*Math.pow(2,count));
                //System.out.println("Sum: "+sum);
                s-=num;
            }
            //System.out.println("CopyS : "+copyS+" sum: "+sum);
            if(sum!=copyS){
                System.out.println(-1);
            }else{
                System.out.println(Math.pow(2,count)+1);
            }
        }


        out.close();
    }
}