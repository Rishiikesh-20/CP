import java.io.*;
import java.util.*;

public class C_Paint_the_Array{
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
    public static long gcd(long a,long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        int t=in.nextInt();
        testcase: while(t-->0){
            int n=in.nextInt();
            long[] arr=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextLong();
            }
            long gcdOdd=arr[1];
            long gcdEven=arr[0];
            for(int i=2;i<n;i++){
                if(i%2==0) gcdEven=gcd(gcdEven,arr[i]);
                else gcdOdd=gcd(gcdOdd,arr[i]);
            }
            int odd=gcdOdd==1?1:0;
            int even=gcdEven==1?1:0;
            for(int i=0;i<n;i++){
                if(i%2==0 && odd==0){
                    if(arr[i]%gcdOdd==0) odd=1;
                }
                else{
                    if(i%2==1 && even==0){
                        if(arr[i]%gcdEven==0) even=1;
                    }
                }
            }
            if(odd==0){
                System.out.println(gcdOdd);
            }else if(even==0){
                System.out.println(gcdEven);
            }else{
                System.out.println(0);
            }

        }


        out.close();
    }
}