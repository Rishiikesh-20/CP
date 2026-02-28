import java.io.*;
import java.util.*;

public class B_Seats{
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
            String s=in.next();

            if(n==1){
                System.out.println(1);
                continue;
            }
            int total=0;
            double cur=0;
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='0'){
                    cur++;
                }else if(s.charAt(i)=='1'){
                    total++;
                    total+=Math.ceil((cur-1)/3);
                    i++;
                    cur=0;
                }
            }
            // if(cur>0 && total>0){
            //     total+=(cur-1)/2;
            // }else if(cur>0){
            //     total+=(cur)/2;
            // }
            //System.out.println("Cur: "+cur);
            total+=Math.ceil(cur/3);
            //System.out.println("Total: "+total);
            System.out.println(total);

        }


        out.close();
    }
}