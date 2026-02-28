import java.io.*;
import java.util.*;

public class D_Divide_and_Equalize{
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

    public static void findFactors(HashMap<Integer,Integer> map,int n){
        for(int i=2;i<=Math.sqrt((double)n);i++){
            while(n%i==0){
                if(!map.containsKey(i)){
                    map.put(i,0);
                }
                map.put(i,map.get(i)+1);
                n=n/i;
            }
        }
        if(n>1){
            map.put(n,map.getOrDefault(n, 0)+1);
        }
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
                findFactors(map, arr[i]);
            }

            for(Integer i: map.keySet()){
                if(map.get(i)%n!=0){
                    //System.out.println("print : "+map.get(i));
                    System.out.println("NO");
                    continue testcase;
                }
            }
            System.out.println("YES");

        }
        out.close();
    }
}