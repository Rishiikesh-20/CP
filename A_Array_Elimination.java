import java.io.*;
import java.util.*;

public class A_Array_Elimination {
    static final long MOD = 1_000_000_007; 
    static final long INF = 1L << 60;
    
    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = in.nextInt();
        testcase: while (t-- > 0) {
            int n=in.nextInt();

            long[] arr=new long[n];

            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }

            long[] count=new long[30+1];

            for(int i=0;i<n;i++){
                int j=30;
                while(j>=0){
                    count[j]+=(arr[i]>>j)&1;
                    j--;
                }
            }
            long a=count[0];
            for(int i=0;i<31;i++){
                long b=count[i];
                //System.out.println("Count: "+count[i]);
                a=gcd(a,b);
            }
            if(a==0){
                for(int i=1;i<=n;i++){
                    System.out.print(i+" ");
                }
                System.out.println();
                continue;
            }

            if(a==1){
                System.out.println(1);
                continue;
            }

            ArrayList<Long> divs = new ArrayList<>();
            for (long d = 1; d * d <= a; d++) {
                if (a % d == 0) {
                    divs.add(d);
                    if (d != a / d) divs.add(a / d);
                }
            }
            Collections.sort(divs);

            for (long x : divs) {
                System.out.print(x + " ");
            }
            System.out.println();


        }

        out.flush(); 
        out.close();
    }

    // =========================================================================
    // MATH UTILITIES
    // =========================================================================

    // Greatest Common Divisor
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Least Common Multiple (Prevents overflow by dividing first)
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    // Modular Exponentiation: (base^exp) % mod in O(log exp) time
    static long power(long base, long exp, long mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    // Fast Exponentiation: base^exp (No modulo)
    static long power(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res *= base;
            base *= base;
            exp >>= 1;
        }
        return res;
    }

    // Modular Inverse (Requires mod to be prime) using Fermat's Little Theorem
    static long modInverse(long n, long p) {
        return power(n, p - 2, p);
    }

    // =========================================================================
    // ARRAY UTILITIES
    // =========================================================================

    // Anti-QuickSort TLE Trick: Randomly shuffles the array before sorting.
    // Java's Arrays.sort() on primitives can be hacked to run in O(N^2) by 
    // malicious test cases. Shuffling prevents this.
    static void shuffleSort(int[] a) {
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            int j = rand.nextInt(i + 1);
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        Arrays.sort(a);
    }

    static void shuffleSort(long[] a) {
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            int j = rand.nextInt(i + 1);
            long temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        Arrays.sort(a);
    }

    private static void whie(boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // =========================================================================
    // ULTRA-FAST I/O
    // =========================================================================

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int head, tail;

        public FastScanner() {
            this.in = System.in;
        }

        private int read() {
            if (head >= tail) {
                head = 0;
                try {
                    tail = in.read(buffer, 0, buffer.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }

        public int nextInt() {
            int c = read();
            while (c <= ' ') {
                if (c == -1) return -1;
                c = read();
            }
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
            int res = 0;
            do {
                res = res * 10 + (c - '0');
                c = read();
            } while (c > ' ');
            return neg ? -res : res;
        }

        public long nextLong() {
            int c = read();
            while (c <= ' ') {
                if (c == -1) return -1;
                c = read();
            }
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
            long res = 0;
            do {
                res = res * 10 + (c - '0');
                c = read();
            } while (c > ' ');
            return neg ? -res : res;
        }

        public String next() {
            int c = read();
            while (c <= ' ') {
                if (c == -1) return null;
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (c > ' ');
            return res.toString();
        }

        public String nextLine() {
            int c = read();
            while (c <= ' ' && c != -1 && c != '\n' && c != '\r') {
                c = read();
            }
            if (c == -1) return null;
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (c != '\n' && c != '\r' && c != -1);
            return res.toString();
        }
    }
}