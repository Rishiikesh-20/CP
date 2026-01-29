import java.io.*;
import java.util.*;

public class B_M_arrays{
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
            int m=in.nextInt();

            int[] arr=new int[n];

            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }

            HashMap<Integer,Integer> map=new HashMap<>();

            for(int i=0;i<n;i++){
                int rem=arr[i]%m;
                if(!map.containsKey(rem)){
                    map.put(rem,0);
                }
                map.put(rem,map.get(rem)+1);
            }
            HashSet<Integer> visited=new HashSet<>();
            int result=0;
            for(Integer key : map.keySet()){
                if(visited.contains(key)) continue;
                
                if(key==(m-key) || key==0){
                    result++;
                    visited.add(key);
                }else{
                    int count1=map.get(key);
                    if(!map.containsKey(m-key)){
                        result+=count1;
                        visited.add(key);
                    }else{
                        int count2=map.get(m-key);
                        result++;
                        int rem=Math.abs(count1-count2)-1;
                        result+=(Math.max(rem,0));
                        visited.add(key);
                        visited.add(m-key);
                    }
                }

            }
            System.out.println(result);
        }


        out.close();
    }
}