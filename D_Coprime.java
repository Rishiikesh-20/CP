import java.io.*;
import java.util.*;

public class D_Coprime{
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
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        int t=in.nextInt();
        testcase: while(t-->0){
            int n=in.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                map.put(arr[i],i);
            }
            long max=Long.MIN_VALUE;
            ArrayList<Integer> list=new ArrayList<>(map.keySet());
            for(int i=0;i<list.size();i++){
                for(int j=i;j<list.size();j++){
                    int a=list.get(i);
                    int b=list.get(j);
                    if(gcd(a,b)==1){
                        max=Math.max(max,(long)map.get(a)+map.get(b)+2);
                    }
                }
            }
            if(max==Long.MIN_VALUE) System.out.println(-1);
            else System.out.println(max);
        }
        out.close();
    }
}