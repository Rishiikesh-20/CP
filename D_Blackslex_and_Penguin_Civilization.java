import java.io.*;
import java.util.*;

public class D_Blackslex_and_Penguin_Civilization{
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
            int size=(int)Math.pow(2,n);
            int power=n;
            HashSet<Integer> set=new HashSet<>();
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=power;i>=1;i--){
                int temp=(int)Math.pow(2,i)-1;
                for(int j=0;j<size;j++){
                    if(!set.contains(j) && (j&temp)==temp){
                        list.add(j);
                        set.add(j);
                    }
                }
            }

            for(int i=0;i<size;i++){
                if(!set.contains(i)){
                    list.add(i);
                }
            }

            for(int i=0;i<size;i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();


        }


        out.close();
    }
}