import java.io.*;
import java.util.*;

public class A_Notelock{
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
        while(t-->0){
            int n=in.nextInt();
            int k=in.nextInt();
            String s=in.next();
            int lastIndex=-1;
            int sum=0;
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='1'){
                    if(i-(k-1)<=lastIndex && lastIndex!=-1){
                        lastIndex=i;
                    }else{
                        sum+=1;
                        lastIndex=i;
                    }
                }
            }
            System.out.println(sum);
        }
        out.close();
    }
}