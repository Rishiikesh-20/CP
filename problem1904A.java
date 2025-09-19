import java.util.Scanner;

public class problem1904A {
    public static void solve(int a,int b,int xk,int yk,int xq,int yq){
        int count=0;
        int[] x={1,-1,1,-1};
        int[] y={1,1,-1,-1};
        int n=8;
        if(a==b) n=4;
        int[][] arr=new int[n][2];
        int[][] arr1=new int[n][2];
        
        for(int i=0;i<4;i++){
            arr[i][0]=xk+x[i]*a;
            arr[i][1]=yk+y[i]*b;
            if(n==8){
                arr[4+i][0]=xk+x[i]*b;
                arr[4+i][1]=yk+y[i]*a;  
            }  
        }

        for(int i=0;i<4;i++){
            arr1[i][0]=xq+x[i]*a;
            arr1[i][1]=yq+y[i]*b;
            if(n==8){
                arr1[4+i][0]=xq+x[i]*b;
                arr1[4+i][1]=yq+y[i]*a;  
            }  
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][0]==arr1[j][0] && arr[i][1]==arr1[j][1]){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            int xk=in.nextInt();
            int yk=in.nextInt();
            int xq=in.nextInt();
            int yq=in.nextInt();
            
            solve(a, b, xk, yk, xq, yq);
        }
    }
}
