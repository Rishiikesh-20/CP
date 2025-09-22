import java.util.Scanner;

public class contest2146A {
    public static void solve(int[] arr){
        int cur=arr[0];
        int longSub=Integer.MIN_VALUE;
        int currentOcc=0;
        int count=1;

        int[] temp=new int[100];
        for(int i=0;i<arr.length;i++){
            if(cur!=arr[i]){
                cur=arr[i];
                count++;
                currentOcc=0;
            }
            currentOcc++;
            temp[currentOcc-1]++;
            longSub=Math.max(currentOcc*temp[currentOcc-1],longSub);
        }
        System.out.println(longSub);
    }
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int num=in.nextInt();
            int[] arr=new int[num];
            for(int j=0;j<num;j++){
                arr[j]=in.nextInt();
            }
            solve(arr);
        }
    }
}
