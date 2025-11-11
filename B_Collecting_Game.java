import java.io.*;
import java.util.*;

public class B_Collecting_Game{
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
            
            HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                if(!map.containsKey(arr[i])){
                    map.put(arr[i],new ArrayList<>());
                }
                map.get(arr[i]).add(i);
            }
            if(n==1){
                System.out.println(0);
                continue testcase;
            }
            Arrays.sort(arr);
            long[] prefixSum=new long[n];
            prefixSum[0]=arr[0];
            for(int i=1;i<n;i++){
                prefixSum[i]=arr[i]+prefixSum[i-1];
            }
            long[] result=new long[n];
            ArrayList<Integer> list=map.get(arr[n-1]);
            for(Integer i:list){
                result[i]=n-1;
            }
            long prev=n-1;
            for(int i=n-2;i>=0;i--){
                if(!map.containsKey(arr[i])) continue;
                list=map.get(arr[i]);
                if(prefixSum[i]>=arr[i+1]){
                    for(Integer j:list){
                        result[j]=prev;
                    }
                    map.remove(Integer.valueOf(arr[i]));
                }else{
                    for(Integer j:list){
                        result[j]=i;
                    }
                    prev=i;
                    map.remove(Integer.valueOf(arr[i]));
                }   
            }
            for(int i=0;i<n;i++){
                System.out.print(result[i]+" ");
            }
            System.out.println();
        }


        out.close();
    }
}