import java.io.*;
class Main{
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
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)
                return -ret;
            return ret;
        }
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
    static Reader sc=new Reader();
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static int powLog2(int n) {
        return 1<<(31 - Integer.numberOfLeadingZeros(n)); 
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String args[])throws IOException {
        // Logic goes here
        int t=inputInt();
        while(t-->0){
            int l=inputInt();
            int r=inputInt();

            int[] ans=new int[r+1];
            for(int i=0;i<=r;i++) ans[i]=i;
            int[] vis=new int[r+1];
            for(int st=powLog2(r);st>0;st/=2){
                if(vis[st]==1) continue;
                for(int i=st,j=st-1;i<=r && j>=0;i++,j--){
                    if(vis[i]==1) break;
                    swap(ans,i, j);
                    vis[i]=vis[j]=1;
                }
            }  
            long result=0;
            for(int i=0;i<r+1;i++){
                result+=(ans[i]|i);
            }
            println(result+"");
           StringBuilder sb = new StringBuilder();
            for(int i=0;i<r+1;i++){
                sb.append(ans[i]).append(" ");
            }
            println(sb.toString());
            println("");
        }                 
        bw.flush();
        bw.close();
    }
    public static int inputInt()throws IOException {
        return sc.nextInt();
    }
    public static long inputLong()throws IOException {
        return sc.nextLong();
    }
    public static double inputDouble()throws IOException {
        return sc.nextDouble();
    }
    public static String inputString()throws IOException {
        return sc.readLine();
    }
    public static void print(String a)throws IOException {
        bw.write(a);
    }
    public static void printSp(String a)throws IOException {
        bw.write(a+" ");
    }
    public static void println(String a)throws IOException {
        bw.write(a+"\n");
    }
}