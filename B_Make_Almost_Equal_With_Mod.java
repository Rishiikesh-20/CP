import java.io.*;
import java.util.*;

public class B_Make_Almost_Equal_With_Mod{
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
            long[] arr=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextLong();;
            }
            long d=1;
            for(int i=1;i<=57;i++){
                d=d*2;
                long rem1=-1;
                long rem2=-1;
                int flag=0;
                for(int j=0;j<n;j++){
                    long rem=arr[j]%d;
                    if(rem1==-1 || rem==rem1){
                        rem1=rem;
                    }else if(rem2==-1 || rem==rem2){
                        rem2=rem;
                    }else{
                        flag=1;
                        break;
                    }
                }
                if(rem1==-1 || rem2==-1 || flag==1){
                    continue;
                }else{
                    System.out.println(d);
                    break;
                }
            }
        }
        out.close();
    }
}