import java.io.*;
import java.util.*;

public class B_A_Perfectly_Balanced_String{
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
            String s=in.next();
            int n=s.length();
            int k=0;
            HashSet<Character> hash=new HashSet<>();
            for(k=0;k<n;k++){
                if(hash.contains(s.charAt(k))){
                    break;
                }
                hash.add(s.charAt(k));
            }

            for(int i=k;i<n;i++){
                if(s.charAt(i)==s.charAt(i-k)){
                    continue;
                }
                System.out.println("NO");
                continue testcase;
            }
            System.out.println("YES");
        }
        out.close();
    }
}