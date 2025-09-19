import java.util.Scanner;

public class problem1857A {
    public static void solve(int[] arr){
        // 1 2 4 3 2 3 5 4
        // odd should be even number of times, even can be any => even
        // odd+even => even , then take atleast 1 even
        int odd=0;
        int even=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0) even++;
            else odd++;
        }
        if(odd%2==0){System.out.println("YES");return;}
        if(odd+(even-1)%2==0){ System.out.println("YES");return;}
        System.out.println("NO");
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        for(int i=0;i<num;i++){
            int n=in.nextInt();
            int[] arr=new int[n];
            for(int j=0;j<n;j++){
                arr[j]=in.nextInt();
            }
            solve(arr);
        }
    }   
}
