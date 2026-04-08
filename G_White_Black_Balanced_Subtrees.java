import java.io.*;
import java.util.*;

public class G_White_Black_Balanced_Subtrees{
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

    public static long recur(HashMap<Integer,ArrayList<Integer>> map,int i,String s,long[] arr){
        if(!map.containsKey(i)){
            return s.charAt(i-1)=='W'?1:-1;
        }
        ArrayList<Integer> list=map.get(i);
        long result=0;
        for(int val:list){
            result+=recur(map,val,s,arr);
        }
        result+=s.charAt(i-1)=='W'?1:-1;
        if(result==0){
            arr[0]+=1;
        }
        return result;
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        int t=in.nextInt();
        testcase: while(t-->0){
            int n=in.nextInt();
            int[] arr=new int[n-1];
            for(int i=0;i<n-1;i++){
                arr[i]=in.nextInt();
            }
            String s=in.next();
            HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();

            for(int i=0;i<n-1;i++){
                if(!map.containsKey(arr[i])){
                    map.put(arr[i],new ArrayList<>());
                }
                map.get(arr[i]).add(i+2);
            }

            long[] result=new long[1];

            long ans=recur(map, 1, s, result);
            System.out.println(result[0]);
        }


        out.close();
    }
}