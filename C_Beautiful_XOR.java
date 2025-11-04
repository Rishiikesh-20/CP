import java.io.*;
import java.util.*;

public class C_Beautiful_XOR {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {}
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static int numOfDigits(int n) {
        int bits = 0;
        while (n > 0) {
            bits++;
            n = n >> 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        /*
            a= 1011 b>a
            b= 1111 

         
            a>b
            
            a=a^x

            9 6
            405 400
            998 244

            9 6
            1010   1001
            00     1000
            0001   0001

            1001
            1000
            0001

            0110

            0011
            

            405 400
            110010101
            110010000

            1111100110
            0011110100
            
            1100010010


         */

        int t = in.nextInt();
        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();

            if (b == a) {
                out.println(0);
                continue;
            }

            int maxNumPos = numOfDigits(a);
            if (b >=(1<<maxNumPos)) {
                out.println(-1);
                continue;
            }
            int mask = (1 << (maxNumPos-1));

            int bitsNeedToBeChanged=a^b;
            if(bitsNeedToBeChanged>a){
                out.println(2);
                int remaining=bitsNeedToBeChanged^mask;
                out.println(remaining+" "+mask);
                continue;
            }
            out.println(1);
            out.println(bitsNeedToBeChanged);
        }

        out.flush();
        out.close();
    }
}
