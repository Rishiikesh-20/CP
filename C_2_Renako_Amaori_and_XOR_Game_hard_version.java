import java.io.*;
import java.util.*;

public class C_2_Renako_Amaori_and_XOR_Game_hard_version{
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
            int[] a=new int[n];
            int[] b=new int[n];
            for(int i=0;i<n;i++){
                a[i]=in.nextInt();
            }
            for(int i=0;i<n;i++){
                b[i]=in.nextInt();
            }
            
            long xorSum=0;
            for(int i=0;i<n;i++){
                xorSum^=(a[i]^b[i]);
            }
            if(xorSum==0){
                out.println("Tie");
                continue testcase;
            }

            for(int i=20;i>=0;i--){
                int count=0;
                int last=-1;
                for(int j=0;j<n;j++){
                    int r1=(a[j]>>i)&1;
                    int r2=(b[j]>>i)&1;
                    if(r1!=r2){
                        count++;
                        last=j;
                    }
                }
                if(count%2!=0){
                    if(last%2==0){
                        out.println("Ajisai");
                        continue testcase;
                    }else{
                        out.println("Mai");
                        continue testcase;
                    }
                }
            }
        }


        out.close();
    }
}