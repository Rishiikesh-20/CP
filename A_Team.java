import java.io.*;
import java.util.*;

public class A_Team{
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
        int count=0;
        
        for(int i=0;i<n;i++){
            
            int a=in.nextInt();
            int b=in.nextInt();
            int c=in.nextInt();
            if(a+b+c>=2) count++;
        }
        System.out.println(count);

        


        out.close();
    }
}