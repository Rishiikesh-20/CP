import java.io.*;
import java.util.*;

public class D_Friends_and_the_Restaurant{
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
            int[] x=new int[n];
            int[] y=new int[n];

            for(int i=0;i<n;i++){
                x[i]=in.nextInt();
            }
            TreeMap<Integer,Integer> map=new TreeMap<>();
            for(int i=0;i<n;i++){
                y[i]=in.nextInt();
                map.put(y[i]-x[i],map.getOrDefault(y[i]-x[i], 0)+1);
            }
            int ans=0;
            while(map.size()>0){
                int val=map.firstKey();
                int freq=map.get(val);
                if(freq==1){
                    map.remove(val);
                }else{
                    map.put(val,freq-1);
                }

                Integer ele=map.ceilingKey(-val);
                if(ele!=null){
                    ans++;
                    int f=map.get(ele);
                    if(f==1){
                        map.remove(ele);
                    }else{
                        map.put(ele,f-1);
                    } 
                }
            }
            System.out.println(ans);
        }


        out.close();
    }
}