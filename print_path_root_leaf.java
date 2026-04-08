import java.util.*;

public class print_path_root_leaf {

    public static boolean logic(Node root,int leaf,ArrayList<Integer> list){
        if(root == null) return false;
        list.add(root.val);
        if(root.left==null && root.right==null && root.val==leaf){
            return true;
        }
        if(root.left!=null){ 
            boolean flag=logic(root.left,leaf,list);
            if(flag==true) return true;
        }
        if(root.right!=null){
            boolean flag=logic(root.right,leaf,list);
            if(flag==true) return true;
        }
        list.remove(list.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Binary Tree : ");
        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int leaf=in.nextInt();

        Node root=insertLevelOrder(arr, 0);

        ArrayList<Integer> list=new ArrayList<>();
        boolean flag=logic(root,leaf,list);

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        
    }
    public static Node insertLevelOrder(int[] arr,int i){
        Node root=null;
        if(i<arr.length && arr[i]!=-1){
            root=new Node(arr[i]);
            root.left=insertLevelOrder(arr, 2*i+1);
            root.right=insertLevelOrder(arr, 2*i+2);
        }
        return root;
    }
    
    
}
class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }

