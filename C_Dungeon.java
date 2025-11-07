import java.io.*;
import java.util.*;

public class C_Dungeon{
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
        while(t-->0){

            int n=in.nextInt();
            int m=in.nextInt();

            TreeMap<Integer,Integer> sword=new TreeMap<>();

            for(int i=0;i<n;i++){
                int val=in.nextInt();
                sword.put(val,sword.getOrDefault(val, 0)+1);
            }

            int[] b=new int[m];
            int[] c=new int[m];

            for(int i=0;i<m;i++){
                b[i]=in.nextInt();
            }

            for(int i=0;i<m;i++){
                c[i]=in.nextInt();
            }

            ArrayList<Pair> mc=new ArrayList<>();
            ArrayList<Pair> zero_mc=new ArrayList<>();
            
            for(int i=0;i<m;i++){
                if(c[i]!=0){
                    mc.add(new Pair(b[i], c[i]));
                }else{
                    zero_mc.add(new Pair(b[i], c[i]));
                }
            }

            Collections.sort(mc);
            Collections.sort(zero_mc);

            int result=0;
            
            for(Pair p:mc){
                Integer val=sword.ceilingKey(p.b);
                if(val!=null){
                    result++;
                    int max=Math.max(p.c,val);
                    if(sword.get(val)==1){
                        sword.remove(val);
                    }else{
                        sword.put(val,sword.get(val)-1);
                    }
                    sword.put(max,sword.getOrDefault(max,0)+1);
                }else{
                    break;
                }
            }
            for(Pair p:zero_mc){
                Integer val=sword.ceilingKey(p.b);
                if(val!=null){
                    result++;
                    if(sword.get(val)==1){
                        sword.remove(val);
                    }else{
                        sword.put(val, sword.get(val)-1);
                    }
                }else{
                    break;
                }
            }

            out.println(result);

            // Previous Approach

            // int n=in.nextInt();
            // int m=in.nextInt();
            // int[] a=new int[n];
            // int[] b=new int[m];
            // int[] c=new int[m];

            // for(int i=0;i<n;i++){
            //     a[i]=in.nextInt();
            // }
            // for(int i=0;i<m;i++){
            //     b[i]=in.nextInt();
            // }
            // for(int i=0;i<m;i++){
            //     c[i]=in.nextInt();
            // }
            // int result=0;

            // ArrayList<Pair> list=new ArrayList<>();
            
            // for(int i=0;i<m;i++){
            //     list.add(new Pair(b[i], c[i]));
            // }
            // Collections.sort(list,(p1,p2)->Integer.compare(p2.c, p1.c));
            // Arrays.sort(a);
            // int flag=0;
            // int zeroIndex=-1;
            // for(int i=0;i<m;i++){
            //     Arrays.sort(a);
            //     for(int j=0;j<n;j++){
            //         if(list.get(i).c==0){
            //             flag=1;
            //             zeroIndex=i;
            //             break;
            //         }
            //         if(list.get(i).c>=a[j] && list.get(i).b<=a[j]){
            //             result++;
            //             a[j]=list.get(i).c;
            //             break;
            //         }else if(list.get(i).b<=a[j]){
            //             result++;
            //             break;
            //         }
            //     }
            //     if(flag==1){
            //         break;
            //     }
            // }
            // int size=m-zeroIndex;
            // int[] d=new int[size];
            // if(flag==1){
            //     for(int i=zeroIndex;i<m;i++){
            //         d[i-zeroIndex]=list.get(i).b;
            //     }
            //     Arrays.sort(d);

            //     int ind=0;
            //     for(int i=0;i<n;i++){
            //         if(a[i]>=d[ind]){
            //             result++;
            //             ind++;
            //         }
            //         if(ind>=size){
            //             break;
            //         }
            //     }
            // }
            // System.out.println(result);
            
        }


        out.close();
    }
    
}
class Pair implements Comparable<Pair>{
        int b;
        int c;
        Pair(int b,int c){
            this.b=b;
            this.c=c;
        }
    
    @Override
    public int compareTo(Pair other){
        if(this.b!=other.b){
            return Integer.compare(this.b, other.b);
        }
        return Integer.compare(other.c, this.c);
    }
}