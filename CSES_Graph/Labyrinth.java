
import java.io.*;
import java.util.*;

public class Labyrinth{
    static final long MOD = 1_000_000_007; 
    static final long INF = 1L << 60;
    
    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = in.nextInt();
        int m = in.nextInt();

        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = in.next();
            arr[i] = s.toCharArray();
        }

        int[] start = new int[2];
        int[] target = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'A') {
                    start[0] = i;
                    start[1] = j;
                } else if (arr[i][j] == 'B') {
                    target[0] = i;
                    target[1] = j;
                }
            }
        }

        char[][] path = new char[n][m];
        int[][] visited = new int[n][m];

        bfs(arr, start, target, path, visited);
        if (path[target[0]][target[1]] == '\u0000') {
            System.out.println("NO");
            return;
        }

        int x = target[0];
        int y = target[1];
        StringBuilder result = new StringBuilder();
        while (x != start[0] || y != start[1]) {
            char ch = path[x][y];
            result.append(ch);

            if (ch == 'R') y--;
            else if (ch == 'L') y++;
            else if (ch == 'D') x--;
            else if (ch == 'U') x++;
        }
        result.reverse();

        System.out.println("YES");
        System.out.println(result.length());
        System.out.println(result);

        out.flush(); 
        out.close();
    }

    public static void bfs(char[][] arr, int[] start, int[] target, char[][] path, int[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = 1;

        int n = arr.length;
        int m = arr[0].length;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        char[] dir = {'R', 'L', 'D', 'U'};

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int curX = temp[0];
            int curY = temp[1];

            for (int i = 0; i < 4; i++) {
                int x = curX + dx[i];
                int y = curY + dy[i];

                if (x >= 0 && x < n && y >= 0 && y < m && visited[x][y] == 0 && arr[x][y] != '#') {
                    visited[x][y] = 1;
                    path[x][y] = dir[i];
                    if (x == target[0] && y == target[1]) {
                        return;
                    }
                    queue.add(new int[]{x, y});
                }
            }
        }

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
            return buffer[head++] & 0xff;
        }

        public int nextInt() {
            int c = read();
            while (c != -1 && c <= ' ') c = read();
            while (c != -1 && c != '-' && (c < '0' || c > '9')) c = read();
            if (c == -1) return -1;
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
            if (c == -1) return -1;
            int res = 0;
            while (c >= '0' && c <= '9') {
                res = res * 10 + (c - '0');
                c = read();
            }
            return neg ? -res : res;
        }

        public long nextLong() {
            int c = read();
            while (c != -1 && c <= ' ') c = read();
            while (c != -1 && c != '-' && (c < '0' || c > '9')) c = read();
            if (c == -1) return -1;
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
            if (c == -1) return -1;
            long res = 0;
            while (c >= '0' && c <= '9') {
                res = res * 10 + (c - '0');
                c = read();
            }
            return neg ? -res : res;
        }

        public String next() {
            int c = read();
            while (c != -1 && c <= ' ') c = read();
            if (c == -1) return null;
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
