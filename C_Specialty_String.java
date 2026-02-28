import java.io.*;
import java.util.*;

public class C_Specialty_String{
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
            Stack<Character> stack=new Stack<>();
            for(Character ch:s.toCharArray()){
                if(!stack.isEmpty() && ch==stack.peek()){
                    stack.pop();
                }else{
                    stack.add(ch);
                }
            }
            if(stack.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }


        out.close();
    }
}