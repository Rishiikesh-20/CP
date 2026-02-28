import java.io.*;
import java.util.*;

public class D_Divisible_Pairs{
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
            int x=in.nextInt();
            int y=in.nextInt();

            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }

            HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();

            long result=0;
            for(int i=0;i<n;i++){
                if(!map.containsKey(arr[i]%y)){
                    map.put(arr[i]%y,new ArrayList<>());
                }
                map.get(arr[i]%y).add(arr[i]);
            }

            for(ArrayList<Integer> list:map.values()){
                HashMap<Integer,Integer> map1=new HashMap<>();
                for(Integer val:list){
                    if(map1.containsKey(x-val%x)){
                        result+=map1.get(x-val%x);
                    }else if(map1.containsKey(0) && val%x==0){
                        result+=map1.get(0);
                    }
                    if(!map1.containsKey(val%x)){
                        map1.put(val%x,0);
                    }
                    map1.put(val%x,map1.get(val%x)+1);
                }
            }
            System.out.println(result);

        }


        out.close();
    }
}