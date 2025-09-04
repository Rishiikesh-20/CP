import java.util.Scanner;

public class problem1903A{
    public static void solve(int[] arr,int k){
        /* 
        2 1 
        3 1 

         10 3 830 14

        wrong Approach : 
        two pointers , start from i=1 , check whether last no is greater than this element , if so , 
        just move j . move till j-i+1 becomes larger than k or arr[last]<arr[j]

        4 2
        4 3 2 1

        3 4 2 1
        3 4 1 2
        3 1 4 2
        1 3 4 2
        1 3 2 4
        1 2 3 4

        3 1 2

        when k=1 i can't able to change

        correct approach : 
            when k=1 you can able to do anything , but if the array is sorted it is okay . if k>1 , it is always
            yes, So just check if k==1 and is the array is sorted , then YES otherwise NO
        */
        int n=arr.length;
        if(n==1){
            System.out.println("YES");
            return;
        }
        if(k>1){
            System.out.println("YES");
            return;
        }
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int num=in.nextInt();
            int k=in.nextInt();
            int[] arr=new int[num];
            for(int j=0;j<num;j++){
                arr[j]=in.nextInt();
            }
            solve(arr, k);
        }
    }
}