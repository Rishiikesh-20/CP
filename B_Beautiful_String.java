import java.io.*;
import java.util.*;

public class B_Beautiful_String{
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
        while(t-->0){
            int n=in.nextInt();
            String s=in.nextLine();
            int[] arr=new int[n];
            int count=0;
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='0'){
                    arr[count]=i+1;
                    count++;
                }
            }
            System.out.println(count);
            for(int i=0;i<count;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            // int len=in.nextInt();
            // String s=in.nextLine();
            // int result=0;
            // int palindrome=1;
            // int change=0;
            // for(int i=0;i<len;i++){
            //     for(int j=0;j<len;j++){
            //         for(int k=i;k<i+(j-i+1)/2;k++){
            //             if(s.charAt(k)!=s.charAt(i+(j-i+1)-k-1)){
            //                 palindrome=0;
            //                 break;
            //             }
            //         }
            //         if(palindrome==1){
            //             if(i-1<0 && j+1>len){
            //                 System.out.println(0);
            //                 System.out.println("");
            //                 result=1;
            //                 break;
            //             }else{
            //                 int count;
            //                 for(count=0;count<i-1;count++){
            //                     if(s.charAt(count)=='1' && s.charAt(count+1)=='0'){
            //                         change=1;
            //                         break;
            //                     }
            //                 }
            //                 if(s.charAt(i-1)=='1' && s.charAt(j+1)=='0'){
            //                     change=1;
            //                 }
            //                 for(count=j+1;count<len;count++){
            //                     if(s.charAt(count)=='1' && s.charAt(count+1)=='0'){
            //                         change=1;
            //                         break;
            //                     }
            //                 }
            //                 if(change==1){
            //                     continue;     
            //                 }else{
            //                     for(int k=0;k<i;k++){
            //                         System.out.print((k+1)+" ");
            //                     }
            //                     for(int k=j+1;k<len;k++){
            //                         System.out.print((k+1)+" ");
            //                     }

            //                 }
            //             }
            //         }  
            //     }
            // }  
        }


        out.close();
    }
}