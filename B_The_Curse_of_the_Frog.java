import java.io.*;
import java.util.*;

public class B_The_Curse_of_the_Frog{
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
            long x=in.nextLong();

            long[] a=new long[n];
            long[] b=new long[n];
            long[] c=new long[n];
            for(int i=0;i<n;i++){
                a[i]=in.nextInt();
                b[i]=in.nextInt();
                c[i]=in.nextInt();
            }
            long sum=0;
            //HashSet<Integer> temp=new HashSet<>();
            long maxNum=0;
            for(int i=0;i<n;i++){
                maxNum=Math.max(a[i]*b[i]-c[i],maxNum);
                if(a[i]*(b[i]-(long)1)>(long)0){
                    sum+=(a[i]*(b[i]-1));
                    // temp.add(i);
                }
            }
            //System.out.println("MAxnum : " +maxNum + "Sum: "+sum);

            if(sum>=x){
                System.out.println(0);
                continue;
            }else if(maxNum==(long)0){
                System.out.println(-1);
                continue;
            }

            long rem=x-sum;
            long result = (rem + maxNum - 1) / maxNum;
            System.out.println(result);
            
        }


        out.close();
    }
}