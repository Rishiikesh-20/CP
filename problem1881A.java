import java.util.Scanner;

public class problem1881A {
    public static void solve(String x,String s){
        // 1st approach 
        // int n=x.length();
        // int m=s.length();
        // int i=0;
        // int j=0;
        // int nextStart=i+1;
        // int count=0;
        // int result=0;
        // while(j<m && nextStart<=n){
        //     if(s.charAt(j)==x.charAt(i)){
        //         if(j==m-1){
        //             System.out.println(result);
        //             return;
        //         }
        //         if((i+1)%n==0){ 
        //             count=count+1;
        //             if(Math.pow(2,result)==(double)count || count==1){
        //                 result++;
        //             }
        //         }
                
        //         // 1 3 7 
        //         i=(i+1)%n;
        //         j++;
        //     }else{
        //         j=0;
        //         i=nextStart;
        //         nextStart++;
        //     }
        // }
        
        // System.out.println(-1);

        // 2nd approach 

        int n=x.length();
        int m=s.length();

        StringBuilder str=new StringBuilder(x);

        for(int i=0;i<=5;i++){
            if(str.toString().contains(s)){
                System.out.println(i);
                return;
            }
            str.append(str.toString());
        }
        System.out.println(-1);
        return;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num =in.nextInt();
        
        for(int i=0;i<num;i++){
            int n=in.nextInt();
            int m=in.nextInt();
            in.nextLine();
            String x=in.nextLine();
            String s=in.nextLine();
            solve(x,s);
        }
    }
}
