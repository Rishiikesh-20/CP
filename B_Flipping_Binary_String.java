    import java.io.*;
    import java.util.*;

    public class B_Flipping_Binary_String{
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
                String s=in.next();
                int count_1=0;
                int count_0=0;
                ArrayList<Integer> arr0=new ArrayList<>();
                ArrayList<Integer> arr1=new ArrayList<>();
                for(int i=0;i<n;i++){
                    if(s.charAt(i)=='1'){
                        count_1++;
                        arr1.add(i);
                    }else{
                        count_0++;
                        arr0.add(i);
                    }
                }
                if(count_1%2==0){
                    System.out.println(count_1);
                    if(count_1==0){
                        continue;
                    }
                    for(Integer i:arr1){
                        System.out.print((i+1)+" ");
                    }
                    System.out.println("");
                }else if(count_0%2==1){
                    System.out.println(count_0);
                    for(Integer i: arr0){
                        System.out.print((i+1)+" ");
                    }
                    System.out.println("");
                }else{
                    System.out.println(-1);
                }
                

            }


            out.close();
        }
    }