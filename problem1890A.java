import java.util.Scanner;

public class problem1890A {
    public static void solve(int[] arr){
        int n=arr.length;
        int ele1=0;
        int ele2=0;
        int countEle1=0;
        int countEle2=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=ele1 && arr[i]!=ele2){
                if(ele1==0){
                    ele1=arr[i];
                    countEle1++;
                }else if(ele2==0){
                    ele2=arr[i];
                    countEle2++;
                }else{
                    System.out.println("No");
                    return;
                }
            }else if(arr[i]==ele1){
                countEle1++;
            }else if(arr[i]==ele2){
                countEle2++;
            }
        }
        if(countEle2-countEle1==0|| Math.abs(countEle2-countEle1)==arr.length || Math.abs(countEle2-countEle1)==1){
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
        return;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
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
