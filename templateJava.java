import java.io.*;
import java.util.*;

class templateJava {
    static final long MOD = 1000000007L;
    static final long INF = 1000000000000000000L;
    static final int NUM = 1000005; // Adjust as needed for precomputations
    static final int N = 10000005; // For sieve, adjust as needed

    static long[] fact, invfact;
    static long[] power;
    static int[] sieve;
    static int[] lp;
    static List<Integer> primes = new ArrayList<>();

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) return;
            din.close();
        }
    }

    static Reader sc = new Reader();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // Uncomment next line if multiple test cases are always present
        // int t = inputInt();
        // for (int test = 0; test < t; test++) {
        //     solve();
        // }

        // For single test case or conditional multiple, put logic here or in solve()
        solve();

        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        // Your logic goes here
        // Example:
        // int n = inputInt();
        // println(String.valueOf(2 * n - 2));
    }

    // Modular arithmetic
    static long modPow(long a, long b, long m) {
        long res = 1;
        a %= m;
        while (b > 0) {
            if ((b & 1) != 0) res = (res * a) % m;
            a = (a * a) % m;
            b >>= 1;
        }
        return res;
    }

    static long modPow(long a, long b) {
        return modPow(a, b, MOD);
    }

    static long modInv(long a, long m) {
        return modPow(a, m - 2, m);
    }

    static long modInv(long a) {
        return modInv(a, MOD);
    }

    static long modDiv(long a, long b, long m) {
        return (a % m * modInv(b, m)) % m;
    }

    static long modDiv(long a, long b) {
        return modDiv(a, b, MOD);
    }

    // Precompute factorials
    static void initFactorials(int maxN) {
        fact = new long[maxN];
        invfact = new long[maxN];
        fact[0] = invfact[0] = 1;
        for (int i = 1; i < maxN; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invfact[maxN - 1] = modInv(fact[maxN - 1]);
        for (int i = maxN - 2; i >= 1; i--) {
            invfact[i] = (invfact[i + 1] * (i + 1)) % MOD;
        }
    }

    static long combination(long n, long k) {
        if (k > n || k < 0) return 0;
        return fact[(int)n] * invfact[(int)k] % MOD * invfact[(int)(n - k)] % MOD;
    }

    // Precompute powers
    static void initPowers(long x, int maxN) {
        power = new long[maxN];
        power[0] = 1;
        for (int i = 1; i < maxN; i++) {
            power[i] = (power[i - 1] * x) % MOD;
        }
    }

    // Eratosthenes sieve
    static void calcSieve(int maxN) {
        sieve = new int[maxN + 1];
        for (int i = 2; i <= maxN; i++) {
            if (sieve[i] == 0) {
                for (int j = i; j <= maxN; j += i) {
                    if (sieve[j] == 0) sieve[j] = i;
                }
            }
        }
    }

    // Linear sieve
    static void linearSieve(int maxN) {
        lp = new int[maxN + 1];
        for (int i = 2; i <= maxN; i++) {
            if (lp[i] == 0) {
                lp[i] = i;
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && primes.get(j) <= lp[i] && (long)i * primes.get(j) <= maxN; j++) {
                lp[i * primes.get(j)] = primes.get(j);
            }
        }
    }

    // GCD and LCM
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    // Input methods
    static int inputInt() throws IOException {
        return sc.nextInt();
    }

    static long inputLong() throws IOException {
        return sc.nextLong();
    }

    static double inputDouble() throws IOException {
        return sc.nextDouble();
    }

    static String inputString() throws IOException {
        return sc.readLine();
    }

    // Output methods
    static void print(String a) throws IOException {
        bw.write(a);
    }

    static void printSp(String a) throws IOException {
        bw.write(a + " ");
    }

    static void println(String a) throws IOException {
        bw.write(a + "\n");
    }

    static void yes() throws IOException {
        println("YES");
    }

    static void no() throws IOException {
        println("NO");
    }
}