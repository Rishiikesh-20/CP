import java.util.Scanner;

public class problem2132A {
    public static void solve(String a,String b,String c){
        for(int i=0;i<c.length();i++){
            if(c.charAt(i)=='V'){
                a=b.charAt(i)+a;
            }else{
                a=a+b.charAt(i);
            }
        }
        System.out.println(a);
        return;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++){
            int n1=in.nextInt();
            in.nextLine();
            String a=in.nextLine();
            int n2=in.nextInt();
            in.nextLine();
            String b=in.nextLine();
            String c=in.nextLine();
            solve(a,b,c);
        }
    }
}
