import java.util.Scanner;

public class problem1900A {
    public static void solve(String[] arr){
        int n=arr.length;
        int cur=0;
        int fill=0;
        for(int i=0;i<n;i++){
            if(arr[i].equals(".")){
                cur++;
                if(cur==3){
                    System.out.println(2);
                    return;
                }
                fill++;
            }else{
                cur=0;
            }
        }

        System.out.println(fill);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++){
            int num=in.nextInt();
            in.nextLine();
            String[] arr=new String[num];
            String s=in.nextLine().trim();
            arr=s.split("");
            System.out.println();
            solve(arr);
        }
    }
}
