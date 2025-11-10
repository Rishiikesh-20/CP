import java.io.*;
import java.util.*;

public class B_Erase_First_or_Second_Letter{
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
            String s;
            s=in.next();
            if(n==1){
                System.out.println(1);
                continue testcase;
            }
            int count=0;
            int[] arr=new int[26];

            int[] temp=new int[s.length()];

            for(int i=0;i<n;i++){
                if(arr[s.charAt(i)-97]==0){
                    arr[s.charAt(i)-97]=1;
                    count++;
                }
                temp[i]=count;
            }
            long result=0;
            for(int i=0;i<n;i++){
                result+=temp[i];
            }
            
            System.out.println(result);
        }


        out.close();
    }
}