import java.util.Scanner;

public class problem1883B {
    public static void solve(int n,String s,int k){
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-97]++;
        }
        int odd=0;
        int even=0;
        for(int i=0;i<26;i++){
            if(arr[i]%2==1){
                odd++;
            }else{
                even++;
            }
        }
        if(odd-k<0){
            odd=1;
        }else{
            odd=odd-k;
        }
        if(odd==1 || odd==0){
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int num=in.nextInt();
            int k=in.nextInt();
            in.nextLine();
            String s=in.nextLine();
            solve(num,s,k);
        }
    }
}
