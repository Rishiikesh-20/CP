import java.io.*;
import java.util.*;

public class C_1_No_Cost_Too_Great_Easy_Version{
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

        testCase:
        while(t-->0){
            int n=in.nextInt();
            int[] arr=new int[n];
            int even=0;
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                if(arr[i]%2==0){
                    even++;
                }
            }
            for(int i=0;i<n;i++){
                in.nextInt();
            }
            
            if(even>=2){
                System.out.println(0);
                continue;
            }
            int found=0;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(arr[i]!=1 && arr[j]!=1){
                        if((arr[i]%arr[j]==0 || arr[j]%arr[i]==0) ){
                            System.out.println(0);
                            continue testCase;
                        }
                        if((arr[i]+1)%arr[j]==0 || arr[i]%(arr[j]+1)==0 || (arr[j]+1)%arr[i]==0 || arr[j]%(arr[i]+1)==0 ){
                            found=1;
                        }   
                    } 
                }
            }

            if(even==1 || found==1){
                System.out.println(1);
                continue;
            }
            System.out.println(2);
            
        }
        out.close();
    }
}