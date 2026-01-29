import java.io.*;
import java.util.*;

public class B_Rock_and_Lever{
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
    public static long bitIndex(long num){
        long bit=-1;
        int i=31;
        while(num>0){
            if(((num>>i)&1)==1){
                bit=i;
                break;
            }
            i--;
        }
        return bit;
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        int t=in.nextInt();
        testcase: while(t-->0){
            int n=in.nextInt();
            long[] arr=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }

            HashMap<Long,Long> map=new HashMap<>();
            for(int i=0;i<n;i++){
                long bit=bitIndex(arr[i]);
                //System.out.println("Bit: "+bit+" arr[i]: "+arr[i]);
                if(!map.containsKey(bit)){
                    map.put(bit,(long)0);
                }
                map.put(bit,map.get(bit)+1);
            }
            long result=0;
            //System.out.println(map.values());
            for(Long val:map.values()){
                result+=(val*(val-1)/2);
            }
            System.out.println(result);

        }


        out.close();
    }
}