import java.io.*;
import java.util.*;

public class C_Isamatdin_and_His_Magic_Wand{
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
            int odd=0;
            int even=0;
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                if((arr[i]&1)==0){
                    odd+=1;
                }else{
                    even+=1;
                }
            }

            if(even==0 || odd==0){
                for(int i=0;i<n;i++){
                    System.out.print(arr[i]+" ");
                }
            }else{
                Arrays.sort(arr);
                for(int i=0;i<n;i++){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();


        }


        out.close();
    }
}