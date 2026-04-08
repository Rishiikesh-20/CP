import java.io.*;
import java.util.*;

public class D_Strong_Vertices{
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
                a[i]=a[i]-in.nextInt();
            }
            int max=Integer.MIN_VALUE;

            ArrayList<Integer> ans=new ArrayList<>();
            int ind=-1;
            for(int i=0;i<n;i++){
                if(max<a[i]){
                    max=a[i];
                    ind=i;
                }
            }

            ans.add(ind+1);

            for(int i=0;i<n;i++){
                if(ind!=i && a[i]==max){
                    ans.add(i+1);
                }
            }
            System.out.println(ans.size());
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
        out.close();
    }
}