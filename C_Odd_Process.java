import java.io.*;
import java.util.*;

public class C_Odd_Process{
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
            int[] arr=new int[n];
            ArrayList<Integer> odd=new ArrayList<>();
            ArrayList<Integer> even=new ArrayList<>();
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                if(arr[i]%2==0) even.add(arr[i]);
                else odd.add(arr[i]);
            }
            

            Collections.sort(odd);
            Collections.sort(even);

            long[] preSumEven=new long[even.size()+1];
            long[] preSumOdd=new long[odd.size()+1];
            long cur=0;
            for(int i=1;i<=even.size();i++){
                preSumEven[i]=even.get(i-1)+cur;
                cur=preSumEven[i];
            }
            cur=0;
            for(int i=1;i<=odd.size();i++){
                preSumOdd[i]=odd.get(i-1)+cur;
                cur=preSumOdd[i];
            }

            for(int k=1;k<=n;k++){
                if(odd.size()==0){
                    System.out.print(0+" ");
                    continue;
                }
                if(k<=(1+even.size())){
                    long result=odd.getLast();
                    if(even.size()>0) result+=preSumEven[even.size()]-preSumEven[even.size()-(k-1)];
                    System.out.print(result+" ");
                }else{
                    if(even.size()==0){
                        if(k%2==0){
                            System.out.print(0+" ");
                        }else{
                            System.out.print(odd.getLast()+" ");
                        }
                        continue;
                    }
                    int x=k-1-even.size();
                    if(x==0){
                        System.out.print(0+" ");
                        continue;
                    }else if(k%2==(1+even.size())%2){
                        long result=odd.getLast();
                        if(even.size()>0) result+=preSumEven[even.size()];

                        System.out.print(result+" ");
                    }else{
                        if(x+1>=odd.size()){
                            System.out.print(0+" ");
                            continue;
                        }
                        int r=k-x-1;
                        long result=odd.getLast();
                        if(even.size()>0) result+=preSumEven[even.size()]-preSumEven[even.size()-(r-1)];
                        System.out.print(result+" ");
                    }
                }
            }
            System.out.println();

        }


        out.close();
    }
}