import java.io.*;
import java.util.*;

public class D_Matryoshkas{
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
        while(t-->0){
            int n=in.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            Arrays.sort(arr);
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                if(!map.containsKey(arr[i])){
                    map.put(arr[i],0);
                }
                map.put(arr[i],map.get(arr[i])+1);
            } 
            ArrayList<Integer> list=new ArrayList<>(map.keySet());
            Collections.sort(list);
            long result=map.get(list.get(0));
            for(int i=1;i<list.size();i++){
                if(list.get(i)-list.get(i-1)>1){
                    result+=map.get(list.get(i));
                }else{
                    if(map.get(list.get(i))>map.get(list.get(i-1))){
                        result+=(map.get(list.get(i))-map.get(list.get(i-1)));
                    }
                }
            }
            System.out.println(result);

        }


        out.close();
    }
}