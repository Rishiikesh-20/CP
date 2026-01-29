import java.io.*;
import java.util.*;

public class B_Prinzessin_der_Verurteilung{
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

            // 1 char
            int[] arr=new int[26];
            for(int i=0;i<n;i++){
                int ind=s.charAt(i)-97;
                arr[ind]=1;
            }
            for(int i=0;i<26;i++){
                if(arr[i]==0){
                    System.out.println((char)(97+i));
                    continue testcase;
                }
            }

            // 2 char

            for(int i=0;i<26;i++){
                int[] temp=new int[26];
                for(int j=0;j<n-1;j++){
                    if(s.charAt(j)==(char)(97+i)){
                        temp[s.charAt(j+1)-97]=1;
                    }
                }
                for(int j=0;j<26;j++){
                    if(temp[j]==0){
                        System.out.println((char)(97+i)+""+(char)(97+j));
                        continue testcase;
                    }
                }
            }

            // 3 char

            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    int[] temp=new int[26];
                    for(int k=0;k<n-2;k++){
                        if(s.charAt(k)==(char)(97+i) && s.charAt(k+1)==(char)(97+j)){
                            temp[s.charAt(k+2)-97]=1;
                        }
                    }

                    for(int k=0;k<26;k++){
                        if(temp[k]==0){
                            System.out.println((char)(97+i)+""+(char)(97+j)+""+(char)(97+k));
                            continue testcase;
                        }
                    }
                    
                }
            }

        }
        out.close();
    }
}