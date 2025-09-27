import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Div1054D {
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
            byte[] buf = new byte[200005]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        }
        public String next() throws IOException {
            byte c = read();
            while (c <= ' ')
                c = read();
            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }
        public int nextInt() throws IOException { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do{ 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9');
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
            } 
            while ((c = read()) >= '0' && c <= '9'); 
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
            } 
            while ((c = read()) >= '0' && c <= '9');
            if (c == '.') { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
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
    public static void main(String args[])throws IOException
    {

        /*

            Approach : 
            our main aim is to make one element contigious , so focus on it
            if we make one element contigious , you need to know how much swap u need to do to achieve it

            let us take 010101
                        012345
            
            now take 0 ,

            its index are 0 2 4

            to make all contigious , cost is 0 1 2   => (0-0 , 2-1,4-2)

            so if you take starting or ending as a point and moves all the 0s to it , it will be not efficient.

            ex : 0 1 2 => here if 0 is the point , then cost is 3
            but if center point is a point then it will be efficient , bcoz u can reach that point with mini
            cost from both the ends .

            so you need to subract the median cost with others
         */
        int t=inputInt();
        while(t-->0){
            int n=inputInt();
            String s=inputString();
            ArrayList<Integer> aPos=new ArrayList<>();
            ArrayList<Integer> bPos=new ArrayList<>();

            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='a') aPos.add(i);
                else bPos.add(i);
            }
            int[] aCost=new int[aPos.size()];
            int[] bCost=new int[bPos.size()];

            for(int i=0;i<aPos.size();i++){
                aCost[i]=aPos.get(i)-i;
            }
            for(int i=0;i<bPos.size();i++){
                bCost[i]=bPos.get(i)-i;
            }
            int med1=0;
            Long sum1=(long)0;
            if(aCost.length>0){
                med1=aCost[aPos.size()/2];
                for(int i=0;i<aPos.size();i++){
                    sum1+=Math.abs(aCost[i]-med1);
                }
            }
            int med2=0;
            Long sum2=(long)0;
            if(bCost.length>0){
                med2=bCost[bPos.size()/2];
                for(int i=0;i<bPos.size();i++){
                    sum2+=Math.abs(bCost[i]-med2);
                }
            }
            long result=Math.min(sum1,sum2);
            println(result+"");
        }
        bw.flush();
        bw.close();
    }
    public static int inputInt()throws IOException
    {
        return sc.nextInt();
    }
    public static long inputLong()throws IOException
    {
        return sc.nextLong();
    }
    public static double inputDouble()throws IOException
    {
        return sc.nextDouble();
    }
    public static String inputString()throws IOException
    {
        return sc.next();
    }
    public static void print(String a)throws IOException
    {
        bw.write(a);
    }
    public static void printSp(String a)throws IOException
    {
        bw.write(a+" ");
    }
    public static void println(String a)throws IOException
    {
        bw.write(a+"\n");
    }
}
