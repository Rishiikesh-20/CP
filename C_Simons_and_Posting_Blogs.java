import java.io.*;
import java.util.*;

public class C_Simons_and_Posting_Blogs{
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

    public static int cmp(ArrayList<Integer> a,ArrayList<Integer> b,HashSet<Integer> exists){
        int i=0;
        int j=0;

        while(true){
            while(i<a.size() && exists.contains(a.get(i))) i++;
            while(j<b.size() && exists.contains(b.get(j))) j++;

            if(i==a.size() || j==b.size()) break;

            int valA=a.get(i);
            int valB=b.get(j);

            if(valA!=valB) return valA<valB?1:-1;
            i++;
            j++;
        }
        return (a.size()-i)<(b.size()-j)?1:-1;
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        int t=in.nextInt();
        testcase: while(t-->0){
            int n=in.nextInt();
            
            ArrayList<ArrayList<Integer>> blogs=new ArrayList<>();

            for(int i=0;i<n;i++){
                int m=in.nextInt();
                ArrayList<Integer> list=new ArrayList<>();
                for(int j=0;j<m;j++){
                    int num=in.nextInt();
                    list.add(num);
                }

                HashSet<Integer> seen=new HashSet<>();
                ArrayList<Integer> uniqueList=new ArrayList<>();

                for(int j=m-1;j>=0;j--){
                    if(!seen.contains(list.get(j))){
                        seen.add(list.get(j));
                        uniqueList.add(list.get(j));
                    }
                }
                blogs.add(new ArrayList<>(uniqueList));
            }

            HashSet<Integer> exists = new HashSet<>();
            ArrayList<Integer> result=new ArrayList<>();
            int[] used=new int[n];

            for(int k=0;k<n;k++){
                int best=-1;
                for(int i=0;i<n;i++){
                    if(used[i]==1) continue;
                    if(best==-1 || cmp(blogs.get(i),blogs.get(best),exists)==1){
                        best=i;
                    }
                }

                used[best]=1;

                for(Integer x:blogs.get(best)){
                    if(!exists.contains(x)){
                        result.add(x);
                        exists.add(x);
                    }
                }

            }

            for(Integer val:result){
                System.out.print(val+" ");
            }
            System.out.println();
        }


        out.close();
    }
}