import java.io.*;
import java.util.*;

public class C_All_in_one_Gun{
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
            long h=in.nextInt();
            int k=in.nextInt();

            int[] arr=new int[n];   
            long total=0;
            long max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                total+=arr[i];
                max=Math.max(max,arr[i]);
            }

            int[] sufMax=new int[n];
            sufMax[n-1]=arr[n-1];
            for(int i=n-2;i>=0;i--){
                sufMax[i]=Math.max(arr[i], sufMax[i+1]);
            }
            long fact=(h-1)/total;
            long result=0;
            long rem=0;
            if(fact>0){
                if(h!=0) {result=n*fact+k*fact;}
                else {out.println(n*fact+k*(fact-1));
                    continue testcase;
                };
            }
            rem=h-(fact*total);
            //System.out.println("Result: "+result);
            int small=Integer.MAX_VALUE;
            long sum=0;
            for(int i=0;i<n;i++){
                //System.out.println("Hello");
                sum+=arr[i];
                small=Math.min(small,arr[i]);
                long bestDamage=sum;
                if(i<n-1){
                    int big=sufMax[i+1];
                    bestDamage=Math.max(bestDamage,sum-small+big);
                }
                if(bestDamage>=rem){
                    result+=(i+1);
                    break;
                }
            }
            out.println(result);
        }


        out.close();
    }
}