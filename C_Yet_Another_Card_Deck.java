import java.io.*;
import java.util.*;

public class C_Yet_Another_Card_Deck{
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

       
        int n=in.nextInt();
        int q=in.nextInt();

        HashMap<Integer,Integer> map=new HashMap<>();
        int[] queries=new int[q];
        for(int i=0;i<n;i++){
            int val=in.nextInt();
            if(!map.containsKey(val)){
                map.put(val,i+1);
            }
        }
        for(int i=0;i<q;i++){
            queries[i]=in.nextInt();
        }

        for(int i=0;i<q;i++){
            int query=queries[i];

            int pos=map.get(query);
            System.out.print(pos+" ");
            for(Integer val:map.keySet()){
                if(map.get(val)<pos){
                    map.put(val,map.get(val)+1);
                }
            }
            map.put(query,1);
        }

        System.out.println();
        out.close();
    }
}