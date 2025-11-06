import java.io.*;
import java.util.*;

public class D_Three_Activities{
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

    public static int[] getMax3(int[] a){
        int m1=-1,m2=-1,m3=-1;
        int n=a.length;
        for(int i=0;i<n;i++){
            if((m1==-1) || (a[i]>a[m1])){
                int temp1=m1;
                int temp2=m2;
                m1=i;
                m2=temp1;
                m3=temp2;

            }else if(m2==-1 || a[i]>a[m2]){
                int temp=m2;
                m2=i;
                m3=temp;
            }else if(m3==-1 || a[i]>a[m3]){
                m3=i;
            }
        }
        return new int[]{m1,m2,m3};
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            int[] a=new int[n];
            int[] b=new int[n];
            int[] c=new int[n];
            for(int i=0;i<n;i++){
                a[i]=in.nextInt();
            }
            for(int i=0;i<n;i++){
                b[i]=in.nextInt();
            }
            for(int i=0;i<n;i++){
                c[i]=in.nextInt();
            } 

            int[] maxiA=getMax3(a);
            int[] maxiB=getMax3(b);
            int[] maxiC=getMax3(c);
            
            int result=0;
            for(int i=0;i<3;i++){
                int x=maxiA[i];
                for(int j=0;j<3;j++){
                    int y=maxiB[j];
                    for(int k=0;k<3;k++){
                        int z=maxiC[k];
                        if(x!=y && y!=z && x!=z){
                            result=Math.max(result,a[x]+b[y]+c[z]);
                        }
                    }
                }
            }

            System.out.println(result);
        }
        out.close();
    }
}