import java.io.*;
import java.util.*;

public class A_String_Rotation_Game{
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
            int count=1;
            int same=0;
            for(int i=1;i<n;i++){
                if(s.charAt(i)!=s.charAt(i-1)){
                    count++;
                }else{
                    same=1;
                }
            }
            if(s.charAt(0)==s.charAt(n-1)){
                System.out.println(count);
                continue;
            }
            if(same==0){
                System.out.println(count);
            }else{
                System.out.println(count+1);
            }
        }


        out.close();
    }
}