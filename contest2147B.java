import java.util.Scanner;

public class contest2147B {
    public static void solve(int n){
        int[] arr=new int[2*n];
        int min=0;
        for(int i=n;i>=1;i--){
            int j=min;
            int p=-1;
            while(j<2*n){
                if(arr[j]==0){
                    if(p==-1){
                        p=j;
                        j=j+i;
                        arr[p]=i;
                        min=p+1;
                    }else if(arr[j]==0){
                        arr[j]=i;
                    }
                }else{
                    if(p==-1){
                        j++;
                    }else{
                        j=j+i;
                    }    
                }
            }
        }
        for(int i=0;i<2*n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int num=in.nextInt();
            solve(num);
        }
    }
}
