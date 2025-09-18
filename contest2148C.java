import java.util.Scanner;

public class contest2148C {
    public static void solve(int n,int m,int[][] a){
        int points=0;
        int cur=0;
        int curSide=0;
        for(int i=0;i<n;i++){
            if((a[i][0]%2==0 && cur%2==0) || (a[i][0]%2!=0 && cur%2!=0)){
                if(curSide==0 && a[i][1]==0 || a[i][1]==1 && curSide==1){
                    points+=(a[i][0]-cur);
                }else{
                    points+=(a[i][0]-cur-1);
                }
            }else{
                if(curSide==0 && a[i][1]==0 || a[i][1]==1 && curSide==1){
                    points+=(a[i][0]-cur-1);
                }else{
                    points+=(a[i][0]-cur);
                }
            }
            cur=a[i][0];
            curSide=a[i][1];
        }
        points+=(m-cur);
        System.out.println(points);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        for(int i=0;i<num;i++){
            int n=in.nextInt();
            int m=in.nextInt();
            int[][] a=new int[n][2];
            for(int j=0;j<n;j++){
                a[j][0]=in.nextInt();
                a[j][1]=in.nextInt();
            }
            
            solve(n,m,a);
        }
    }   
}
