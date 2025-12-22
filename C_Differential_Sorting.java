import java.io.*;
import java.util.*;

public class C_Differential_Sorting{
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
            long[] arr=new long[n];

            for(int i=0;i<n;i++){
                arr[i]=in.nextLong();
            }
            if(arr[n-1]<arr[n-2]){
                System.out.println(-1);
                continue testcase;
            }
            int z=n-1;
            int y=0;
            for(y=n-3;y>=0;y--){
              if(arr[y]>arr[y+1]){
                break;
              }
            }
            if(y==-1){
                System.out.println(0);
                continue;
            }
            int x=y;
            y=y+1;
            ArrayList<int[]> list=new ArrayList<>();
            for(int i=x;i>=0;i--){
                if(arr[i]<=arr[i+1]){
                    y=i;
                    continue;
                }
                long temp=arr[y]-arr[z];
                if(arr[y]<temp){
                    System.out.println(-1);
                    continue testcase;
                }
                arr[i]=temp;
                list.add(new int[]{i,y,z});
                y=i;
            }
            System.out.println(list.size());
            for(int i=0;i<list.size();i++){
                System.out.print((list.get(i)[0]+1)+" "+(list.get(i)[1]+1)+" "+(list.get(i)[2]+1));
                System.out.println();
            }
        }
        out.close();
    }
}