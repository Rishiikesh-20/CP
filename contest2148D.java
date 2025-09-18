import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class contest2148D {
    public static void solve(int n,int[] a){
        ArrayList<Integer> odd=new ArrayList<>();
        long even=0;
        for(int i=0;i<n;i++){
            if(a[i]%2==0){
                even+=a[i];
            }else{
                even+=a[i];
                odd.add(a[i]);
            }
        }
        if(odd.size()==0){ System.out.println(0);return;};

        Collections.sort(odd);

        long points=even;

        for(int i=0;i<odd.size()/2;i++){
            points-=odd.get(i);
        }
        
        System.out.println(points); 
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        for(int i=0;i<num;i++){
            int n=in.nextInt();
            int[] a=new int[n];
            for(int j=0;j<n;j++){
                a[j]=in.nextInt();
            }
            solve(n,a);
        }
    }   
}
