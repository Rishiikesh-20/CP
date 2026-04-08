import java.io.*;
import java.util.*;

public class B_Gardener_and_the_Array{
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
            ArrayList<ArrayList<Integer>> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                int m=in.nextInt();
                list.add(new ArrayList<>());
                for(int j=0;j<m;j++){
                    list.get(list.size()-1).add(in.nextInt());
                }
            }

            HashMap<Integer,Integer> map=new HashMap<>();

            for(int i=0;i<n;i++){
                for(int val:list.get(i)){
                    if(!map.containsKey(val)){
                        map.put(val,0);
                    }
                    map.put(val,map.get(val)+1);
                }
            }

            for(int i=0;i<n;i++){
                boolean flag=false;
                for(int val:list.get(i)){
                   if(map.get(val)<=1){
                        flag=true;
                        break;
                   }
                }
                if(flag==false){
                    System.out.println("Yes");
                    continue testcase;
                }
            }

            System.out.println("No");
        }


        out.close();
    }
}