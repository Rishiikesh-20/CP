import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
public class problem2132B {
    public static void solve(long num){
        Stack<Long> stack=new Stack<>();
        for(int i=1;i<=18;i++){
            long val=1+(long)Math.pow(10,i);
            if(num/val<0){
                break;
            }
            if(num%val==0){
                stack.add(num/val);
            }
        }
        System.out.println(stack.size());
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        
        for(int i=0;i<n;i++){
            long num=in.nextLong();
            solve(num);
        }
    }
}
