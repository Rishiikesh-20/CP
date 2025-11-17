import java.io.*;
import java.util.*;

public class B_Tenzing_and_Books{
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
            int x=in.nextInt();
            int[] s=new int[n];
            int result=0;
            
            for(int i=0;i<3;i++){
                for(int j=0;j<n;j++){
                    s[j]=in.nextInt();
                }
                for(int j=0;j<n;j++){
                    if((s[j]|x)!=x){
                        break;
                    }
                    result=result|s[j];
                }
            }
            if(result==x){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }    
        }
        out.close();
    }
}