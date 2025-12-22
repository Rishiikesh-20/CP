import java.io.*;
import java.util.*;

public class B_Stone_Age_Problem{
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

        int n=in.nextInt();
        int q=in.nextInt();

        int[] arr=new int[n];
        long sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
            sum+=arr[i];
            map.put(i,arr[i]);
        }
        ArrayList<int[]> queries=new ArrayList<>();

        for(int i=0;i<q;i++){
            int t=in.nextInt();
            if(t==1){
                int ind=in.nextInt();
                int x=in.nextInt();
                queries.add(new int[]{t,ind,x});
            }else{
                int x=in.nextInt();
                queries.add(new int[]{t,x});
            } 
        }
        int[] time=new int[n];
        Arrays.fill(time,-1);
        
        int lgv=-1;
        int lgt=-1;
        long result=sum;
        for(int i=0;i<q;i++){
            int[] temp=queries.get(i);
            if(temp[0]==1){
                int val=0;
                if (lgt>time[temp[1]-1]) val=lgv;
                else val=arr[temp[1]-1];
                result=result+temp[2]-val;
                arr[temp[1]-1]=temp[2];
                time[temp[1]-1]=i;
            }else{
                result=(long)n*temp[1];
                lgt=i;
                lgv=temp[1];
            }
            out.println(result);
        }

        

        out.close();
    }
}