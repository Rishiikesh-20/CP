import java.io.*;
import java.util.*;

public class B_Vika_and_the_Bridge{
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
            int k=in.nextInt();
            int[] c=new int[n];
            for(int i=0;i<n;i++){
                c[i]=in.nextInt();
            }
            int result=n;
            Map<Integer,ArrayList<Integer>> map=new HashMap<>();
            for(int i=0;i<n;i++){
                if(!map.containsKey(c[i])){
                    map.put(c[i],new ArrayList<>());
                }
                map.get(c[i]).add(i);
            }
            for(int i=1;i<=k;i++){
                ArrayList<Integer> list=map.get(i);
                if(list==null) continue;
                PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());
                
                int last=-1;
                for(Integer ind:list){
                    queue.add(ind-last-1);
                    last=ind;
                }
                queue.add(n-list.get(list.size()-1)-1);
                int largeGap=queue.poll();
                int newGap=largeGap/2;
                queue.add(newGap);

                int ans=queue.peek();

                if(ans==0){
                    System.out.println(0);
                    continue testcase;
                }
                result=Math.min(ans,result);
            }
            System.out.println(result);
        }


        out.close();
    }
}