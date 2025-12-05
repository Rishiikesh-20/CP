import java.io.*;
import java.util.*;

public class B_Split{
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
            int[] arr=new int[2*n];
            HashMap<Integer,Integer> map =new HashMap<>();
            for(int i=0;i<2*n;i++){
                arr[i]=in.nextInt();
                if(!map.containsKey(arr[i])){
                    map.put(arr[i],0);
                }
                map.put(arr[i],map.get(arr[i])+1);
            }
            
            int odd=0;
            int ans=0;
            int count=0;
            for(Integer val:map.values()){
                if(val%2!=0){
                    odd++;
                    ans++;
                }else{
                    if((val&2)!=0){
                        ans+=2;
                    }else{
                        count++;
                    }
                }
            }
            
            if(odd>=2){
                System.out.println(ans+2*count);
            }else{
                System.out.println(ans+2*(count-count%2));
            }
            
        }
        out.close();
    }
}