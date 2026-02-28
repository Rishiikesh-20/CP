import java.io.*;
import java.util.*;

public class D_Portal{
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
    public static void reverseSubArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        int t=in.nextInt();
        testcase: while(t-->0){
            int n=in.nextInt();
            int x=in.nextInt();
            int y=in.nextInt();

            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            ArrayList<Integer> center=new ArrayList<>();
            int smallSecond=x;

            for(int i=x;i<y;i++){
                if(arr[i]<arr[smallSecond]){
                    smallSecond=i;
                }
            }

            for(int i=smallSecond;i<y;i++){
                center.add(arr[i]);
            }
            for(int i=x;i<smallSecond;i++){
                center.add(arr[i]);
            }
            ArrayList<Integer> result=new ArrayList<>();

            for(int i=0;i<x;i++){
                result.add(arr[i]);
            }

            for(int i=y;i<n;i++){
                result.add(arr[i]);
            }
            ArrayList<Integer> first=new ArrayList<>();
            int ind=0;
            while(result.size()>ind && center.get(0)>result.get(ind)){
                first.add(result.get(ind));
                ind++;
            }

            first.addAll(center);

            while (ind < result.size()) {
                first.add(result.get(ind));
                ind++;
            }


            for(int i=0;i<first.size();i++){
                System.out.print(first.get(i)+" ");
            }
            System.out.println();
        }

        out.close();
    }

}