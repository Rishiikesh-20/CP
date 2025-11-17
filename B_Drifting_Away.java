import java.io.*;
import java.util.*;

public class B_Drifting_Away{
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
            int max=0;
            int cur=1;
            char prev=s.charAt(0);
            if(prev=='*'){
                cur=0;
            }
            if(n==1){
                System.out.println(1);
                continue testcase;
            }
            for(int i=1;i<n;i++){
                if(prev=='>' && (s.charAt(i)=='*' || s.charAt(i)=='<')){
                    System.out.println(-1);
                    continue testcase;
                }else if(prev=='*' && (s.charAt(i)=='*' || s.charAt(i)=='<')){
                    System.out.println(-1);
                    continue testcase;
                }else{
                    if(prev==s.charAt(i)){
                        cur++;
                        max=Math.max(cur,max);
                        prev=s.charAt(i);
                    }else{
                        if(s.charAt(i)=='*'){
                            cur++;
                            max=Math.max(cur,max);
                            cur=0;
                            prev=s.charAt(i);
                        }else if(prev=='*'){
                            cur=2;
                            max=Math.max(cur,max);
                            prev=s.charAt(i);
                        }else{
                            cur=1;
                            max=Math.max(cur,max);
                            prev=s.charAt(i);
                        }
                    }
                }
            }
            System.out.println(max);
        }


        out.close();
    }
}