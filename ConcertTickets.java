import java.io.*;
import java.util.*;

public class ConcertTickets {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        FastWriter out = new FastWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();

        TreeMap<Integer, int[]> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            int[] count = map.get(val);
            if (count == null) {
                map.put(val, new int[]{1});
            } else {
                count[0]++;
            }
        }

        for (int i = 0; i < m; i++) {
            int cust = in.nextInt();

            Map.Entry<Integer, int[]> entry = map.floorEntry(cust);

            if (entry == null) {
                out.printInt(-1);
            } else {
                int price = entry.getKey();
                int[] count = entry.getValue();
                
                out.printInt(price);
                
                if (count[0] == 1) {
                    map.remove(price);
                } else {
                    count[0]--; 
                }
            }
        }
        
        out.flush();
    }


    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int head, tail;

        public FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }

        public int nextInt() throws IOException {
            int c = read();
            while (c <= ' ') {
                if (c == -1) return -1;
                c = read();
            }
            int res = 0;
            do {
                res = res * 10 + (c - '0');
                c = read();
            } while (c > ' ');
            return res;
        }
    }

    static class FastWriter {
        private final OutputStream out;
        private final byte[] buffer = new byte[1 << 16];
        private int pos;

        public FastWriter(OutputStream out) {
            this.out = out;
        }

        public void printInt(int i) throws IOException {
            if (i == -1) {
                write((byte) '-');
                write((byte) '1');
                write((byte) '\n');
                return;
            }
            int temp = i;
            int count = 0;
            while (temp > 0) {
                count++;
                temp /= 10;
            }
            
            if (pos + count + 1 >= buffer.length) flush();
            
            int p = pos + count;
            pos = p;
            while (i > 0) {
                buffer[--p] = (byte) ((i % 10) + '0');
                i /= 10;
            }
            buffer[pos++] = '\n';
        }

        private void write(byte b) throws IOException {
            if (pos == buffer.length) flush();
            buffer[pos++] = b;
        }

        public void flush() throws IOException {
            out.write(buffer, 0, pos);
            pos = 0;
        }
    }
}