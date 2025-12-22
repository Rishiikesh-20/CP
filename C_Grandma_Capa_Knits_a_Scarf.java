import java.io.*;
import java.util.*;

public class C_Grandma_Capa_Knits_a_Scarf{
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
            char[] arr=s.toCharArray();
            int ind=-1;
            for(int i=0;i<n/2;i++){
                // System.out.println("I : "+i);
                if(arr[i]!=arr[n-i-1]){
                    ind=i;
                    break;
                }
            }
            // System.out.println("Ind : "+ind);
            if(ind==-1){
                System.out.println(0);
                continue;
            }
            char c1=arr[ind];
            char c2=arr[n-ind-1];

            int left=ind;
            int right=n-ind-1;
            int count1=0;
            int count2=0;
            while(left<right){
                // System.out.println("Left "+left+" Right: "+right+ "Count: "+count1);
                if(arr[left]==arr[right]){
                    left++;
                    right--;
                }else if(arr[left]==c1){
                    left++;
                    count1++;
                }else if(arr[right]==c1){
                    right--;
                    count1++;
                }else{
                    count1=-1;
                    break;
                }
            }
            left=ind;
            right=n-ind-1;
            while(left<right){
                if(arr[left]==arr[right]){
                    left++;
                    right--;
                }else if(arr[left]==c2){
                    left++;
                    count2++;
                }else if(arr[right]==c2){
                    right--;
                    count2++;
                }else{
                    count2=-1;
                    break;
                }
            }

            if(count1<0 && count2<0){
                System.out.println(-1);
                continue;
            }else if(count1>=0 && count2>=0){
                System.out.println(Math.min(count1,count2));
                continue;
            }else if(count1>=0){
                System.out.println(count1);
            }else{
                System.out.println(count2);
            }
           
        }
        out.close();
    }
}