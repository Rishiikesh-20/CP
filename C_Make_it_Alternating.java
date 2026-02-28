import java.io.*;
import java.util.*;

public class C_Make_it_Alternating{
    static Long MOD=(long)998244353;
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
    public static long factorial(long n){
        if(n==1 || n==0){
            return 1;
        }
        return (n*factorial(n-1))%MOD;
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        int t=in.nextInt();
        testcase: while(t-->0){
            String s=in.next();
            int n=s.length();
            char[] arr=s.toCharArray();
            int cur=1;
            long total=1;
            long count=0;
            for(int i=1;i<n;i++){
                if(arr[i]==arr[i-1]){
                    cur++;
                }else{
                    if(cur==1){
                        continue;
                    }
                    count+=(cur-1)%MOD;
                    total=(total*cur)%MOD;
                    cur=1;
                }
            }
            if(cur>1){
               count+=(cur-1)%MOD;
                total=(total*cur)%MOD;
            }else{
                if(total==0){
                    System.out.println(0+" "+1);
                    continue testcase;
                }
            }
            long second=(total*factorial(count))%MOD;
            System.out.println(count+" "+second);
        }


        out.close();
    }
}