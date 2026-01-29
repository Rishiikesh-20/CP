import java.io.*;
import java.util.*;

public class B_Flip_the_Bits{
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
            String a=in.next();
            String b=in.next();
            if(n==1){
                String result=a.charAt(0)==b.charAt(0)?"YES":"NO";
                System.out.println(result);
                continue;
            }
            ArrayList<Integer> list=new ArrayList<>();
            list.add(-1);
            int count=a.charAt(0)=='0'?1:-1;;
            for(int i=1;i<n;i++){
                if(a.charAt(i)=='0'){
                    count++;
                }else{
                    count--;
                }
                if(count==0){
                    list.add(i);
                }
            }
            //System.out.println("ArrayList: "+ list);
            count=0;
            int j=1;
            for(int i=0;i<n;i++){
                if(a.charAt(i)!=b.charAt(i)){
                    count++;
                }
                if(j<list.size() && list.get(j)==i){
                    //System.out.println("Count : "+count+" Index: "+i);
                    if(count!=((i-list.get(j-1))) && count!=0){
                        //System.out.println("Count : "+count+" Index: "+i);

                        System.out.println("NO");
                        continue testcase;
                    }
                    j++;
                    count=0;
                }
            }
            if(count!=0){
                System.out.println("NO");
                continue testcase;
            }
            System.out.println("YES");
        }


        out.close();
    }
}