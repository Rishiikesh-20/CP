import java.io.*;
import java.util.*;

public class C_Contrast_Value{
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
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            int contrast=0;
            Set<Integer> set =new LinkedHashSet<>();
            for(int i=0;i<n-1;i++){
                contrast+=Math.abs(arr[i]-arr[i+1]);
                set.add(arr[i]);
            }
            set.add(arr[n-1]);
            if(contrast==0){
                System.out.println(1);
                continue testcase;
            }
            int result=2;
            List<Integer> list=new ArrayList<>(set);
            int prevOp=list.get(0)-list.get(1)>0?-1:1;
            for(int i=1;i<n-1;i++){
                if(arr[i]<arr[i+1] && prevOp==-1){
                    result++;
                    prevOp=1;
                }else if(arr[i]>arr[i+1] && prevOp==1){
                    result++;
                    prevOp=-1;
                }
            }
            System.out.println(result); 
        }


        out.close();
    }
}