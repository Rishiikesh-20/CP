import java.io.*;
import java.util.*;

public class B_Kalindrome_Array{
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
            int i=0;
            int j=n-1;
            int removed=-1;
            int ind=-1;
            int flag=0;
            while(i<j){
                if(arr[i]==arr[j]){
                    i++;
                    j--;
                    continue;
                }else if(arr[i]!=arr[j]){
                    if(removed==-1){
                        removed=arr[i];
                        ind=i;
                    }else if(arr[i]==removed){
                        i++;
                    }else if(arr[j]==removed){
                        j--;
                    }else if(flag==0){
                        removed=arr[n-ind-1];
                        i=ind;
                        j=n-ind-1;
                        flag=1;
                    }else{
                        out.println("NO");
                        continue testcase;
                    }
                }
            }
            out.println("YES");
        }


        out.close();
    }
}