import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class C_Kanade_s_Perfect_Multiples{
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

            int[] arr=new int[n];
            ArrayList<Integer> list=new ArrayList<>();
            HashSet<Integer> set=new HashSet<>();
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                if(!set.contains(arr[i])){
                    list.add(arr[i]);
                }
                set.add(arr[i]);
            }
            Collections.sort(list);
            int[] visited=new int[list.size()];
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<list.size();i++){
                map.put(list.get(i),i);
            }
            int count=0;
            for(int i=0;i<list.size();i++){
                if(visited[i]!=1){
                    count++;
                    int val=list.get(i);
                    for(int j=2;j<=k;j++){
                        int temp=val*j;
                        if(temp<=k && map.containsKey(temp)){
                            int v=map.get(temp);
                            visited[v]=1;
                        }else if(temp>k){
                            break;
                        }else{
                            System.out.println(-1);
                            continue testcase;
                        }
                    }
                }
            }
            System.out.println(count);
            for(int i=0;i<list.size();i++){
                if(visited[i]!=1)
                    System.out.print(list.get(i)+" ");
            }
            System.out.println();

            
        }
        out.close();
    }
}