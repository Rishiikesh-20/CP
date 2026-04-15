import java.io.*;
import java.util.*;

public class B_OIE_Excursion {
    static final long MOD = 1_000_000_007; 
    static final long INF = 1L << 60;
    
    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = in.nextInt();
        testcase: while (t-- > 0) {
            int n=in.nextInt();
            int m=in.nextInt();

            int[] arr=new int[n];

            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            int cur=arr[0];
            int count=0;
            for(int i=0;i<n;i++){
                if(arr[i]==cur){
                    count++;
                    if(count==m){
                        System.out.println("NO");
                        continue testcase;
                    }
                }else{
                    count=1;
                    cur=arr[i];
                }
            }
            System.out.println("YES");
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