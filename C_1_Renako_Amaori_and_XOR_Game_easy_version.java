import java.io.*;
import java.util.*;

public class C_1_Renako_Amaori_and_XOR_Game_easy_version{
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
            int[] a=new int[n];
            int[] b=new int[n];
            for(int i=0;i<n;i++){
                a[i]=in.nextInt();
            }
            for(int i=0;i<n;i++){
                b[i]=in.nextInt();
            }
            int count1=0;
            int count2=0;
            int temp=-1;
            for(int i=0;i<n;i++){
                if(a[i]!=b[i]){
                    temp=i+1;
                    if((i+1)%2==1){
                        count1++;
                    }else{
                        count2++;
                    }
                }
            }
            if((count1+count2)%2==0){
                System.out.println("Tie");
            }else {
                if(temp%2!=0){
                    System.out.println("Ajisai");
                }else{
                    System.out.println("Mai");
                }
            }
        }
        out.close();
    }
}