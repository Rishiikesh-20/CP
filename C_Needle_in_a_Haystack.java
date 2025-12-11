import java.io.*;
import java.util.*;

public class C_Needle_in_a_Haystack{
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

        int test=in.nextInt();
        testcase: while(test-->0){
            String t=in.next();
            String s=in.next();
            int n=s.length();
            int k=t.length();
            int[] arr=new int[26];
            int[] v=new int[26];
            for(int i=0;i<n;i++){
                arr[s.charAt(i)-97]++;
            }
            for(int i=0;i<k;i++){
                v[t.charAt(i)-97]++;
            }

            for(int i=0;i<26;i++){
                if(v[i]>arr[i]){
                    System.out.println("Impossible");
                    continue testcase;
                }else{
                    arr[i]-=v[i];
                }
            }
            int l=0;
            String result="";
            int i=0;
            for(i=0;i<26 && l<t.length();i++){
                if(arr[i]!=0){
                    if(t.charAt(l)>(97+i)){
                        result=result+String.valueOf(((char)(97+i))).repeat(arr[i]);
                        arr[i]-=arr[i];
                    }else{
                        result+=t.charAt(l);
                        v[t.charAt(l)-97]--;
                        l++;
                        i--;
                    }
                }   
            }
            for(int r=l;r<t.length();r++){
                result+=t.charAt(r);
            }   
            for(int m=i;m<26;m++){
                result=result+String.valueOf(((char)(97+m))).repeat(arr[m]);
            }
            System.out.println(result);
            
        }


        out.close();
    }
}