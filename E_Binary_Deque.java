import java.io.*;
import java.util.*;

public class E_Binary_Deque{
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
            int s=in.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            HashMap<Integer,Integer> map=new HashMap<>();
            int len=-1;
            map.put(0,-1);
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=arr[i];
                if(map.containsKey(sum-s)){
                    //System.out.println("Here 1 "+(s-sum));
                    len=Math.max(len,i-map.get(sum-s));
                }
                //System.out.println("Here 2 "+(len));

                if(!map.containsKey(sum)){
                   // System.out.println("Here 3 "+(sum)+" ind"+i);
                    map.put(sum,i);
                }
            }
            if(len==-1){
                System.out.println(-1);
            }else{
                System.out.println(n-len);
            }
        }


        out.close();
    }
}