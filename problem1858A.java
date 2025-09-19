
import java.util.Scanner;

public class problem1858A {
    public static void solve(int a,int b,int c){
        if(c%2!=0){
            if(b-1>=a){
                System.out.println("Second");
                return;
            }else{
                System.out.println("First");
                return;
            }
        }else{
            if(a-1>=b){
                System.out.println("First");
                return;
            }
            System.out.println("Second");
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        for(int i=0;i<num;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            int c=in.nextInt();
            solve(a,b,c);
        }
    }   
}
