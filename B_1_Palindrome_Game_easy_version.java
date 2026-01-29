import java.io.*;
import java.util.*;

public class B_1_Palindrome_Game_easy_version{
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
            String s=in.next();

            int count=0;
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='0'){
                    count++;
                }
            }
            if(count%2==0){
                System.out.println("BOB");
            }else{
               if(count>1){
                 System.out.println("ALICE");
               }else{
                System.out.println("BOB");
               }
            }
        }


        out.close();
    }
}