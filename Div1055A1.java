import java.util.HashSet;
import java.util.Scanner;

public class Div1055A1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int n=in.nextInt();
            HashSet<Integer> hash=new HashSet<>();
            for(int j=0;j<n;j++){
                int val=in.nextInt();
                hash.add(val);
            }
            int result=2*hash.size()-1;
            System.out.println(result);
        }
        
    }
}
