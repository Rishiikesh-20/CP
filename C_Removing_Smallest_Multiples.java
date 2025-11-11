import java.io.*;
import java.util.*;

public class C_Removing_Smallest_Multiples{
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
            String s=in.next();
            HashSet<Integer> list=new HashSet<>();

            for(int i=0;i<n;i++){
                if(s.charAt(i)=='0'){
                    list.add(i+1);
                }  
            }

            long result=0;
            for(int k=1;k<=n;k++){
                for(int j=k;j<=n;j+=k){
                    if(s.charAt(j-1)=='1'){
                        break;
                    }else if(s.charAt(j-1)=='0' && list.contains(j)){
                        list.remove(Integer.valueOf(j));
                        result+=k;
                    }
                    if(list.size()==0){
                        System.out.println(result);
                        continue testcase;
                    }
                }      
            }
            System.out.println(result);
        }


        out.close();
    }
}