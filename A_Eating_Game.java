import java.io.*;
import java.util.*;

public class A_Eating_Game{
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
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }

            PriorityQueue<Integer> queue=new PriorityQueue<>();
            HashMap<Integer,Integer> map=new HashMap<>();
            int big=arr[0];
            for(int i=0;i<n;i++){
                if(big<arr[i]){
                    big=arr[i];
                }
                if(!map.containsKey(arr[i])){
                    map.put(arr[i],0);
                }
                map.put(arr[i],map.get(arr[i])+1);
            }
            System.out.println(map.get(big));
        }


        out.close();
    }
}