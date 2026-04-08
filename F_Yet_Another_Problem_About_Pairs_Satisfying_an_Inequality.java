import java.io.*;
import java.util.*;

public class F_Yet_Another_Problem_About_Pairs_Satisfying_an_Inequality{
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

            TreeSet<Integer> set=new TreeSet<>();
            long result=0;

            HashMap<Integer,Integer> map=new HashMap<>();
            int count=0;

            for(int i=0;i<n;i++){
                boolean flag=(i+1)>arr[i];
                //System.out.println("Flag: "+flag+" i+1:"+i+"arr[i]: "+arr[i]);
                if(flag){
                    count++;
                    Integer val=set.lower(arr[i]);
                    if(val!=null){
                        result+=map.get(val);
                    }
                    set.add(i+1);
                    map.put(i+1,count);
                }
            }
            System.out.println(result);
        }


        out.close();
    }
}