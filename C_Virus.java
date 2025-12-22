import java.io.*;
import java.util.*;

public class C_Virus{
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
            int[] arr=new int[m];
            for(int i=0;i<m;i++){
                arr[i]=in.nextInt();
            }
            Arrays.sort(arr);
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<m-1;i++){
                int ele=arr[i+1]-arr[i]-1;
                list.add(ele);
            }
            int lastGap = n - arr[m - 1] + arr[0] - 1;
            list.add(lastGap);
            int days=0;
            int saved=0;
            Collections.sort(list,Collections.reverseOrder());
            for(Integer gap:list){
                int res=2*days;
                int curr=gap-res;
                if(curr<=0) continue;
                if(curr==1 || curr==2){
                    saved++;
                    days++;
                }else{
                    saved+=(curr-1);
                    days+=2;
                }
                
            }
            System.out.println(n-saved);
        }


        out.close();
    }
}