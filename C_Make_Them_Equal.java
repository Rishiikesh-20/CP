import java.io.*;
import java.util.*;

public class C_Make_Them_Equal{
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
            String str=in.next();
            char c=str.charAt(0);
            String s=in.next();

            int odd=0;
            int even=0;
            int ind=-1;
            for(int i=0;i<n;i++){
                if(i>=n/2 && s.charAt(i)==c){
                    ind=i+1;
                }
                if(((i+1)&1)==0 && s.charAt(i)!=c){
                    even++;
                }else if(s.charAt(i)!=c){
                    odd++;
                }
            }
            
            if(odd==0 && even==0){
                System.out.println(0);
                continue;
            }
            if(ind!=-1){
                System.out.println(1);
                System.out.println(ind);
                continue;
            }else{
                System.out.println(2);
                System.out.println((n-1)+" "+(n));
                continue;
            }
        }
        out.close();
    }
}