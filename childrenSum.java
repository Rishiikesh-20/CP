import java.util.*;

public class childrenSum {

    public static void logic(Node root){
        if(root==null){
            return;
        }

        int sum=0;
        if(root.left!=null){
            sum+=root.left.val;
        }
        if(root.right!=null){
            sum+=root.right.val;
        }

        if(sum<root.val){
            if(root.right!=null) root.right.val=root.val;
            if(root.left!=null) root.left.val=root.val;
        }

        logic(root.left);
        logic(root.right);

        int total=0;
        if(root.left==null && root.right==null){
            total=root.val;
        }
        if(root.left!=null){
            total+=root.left.val;
        }
        if(root.right!=null){
            total+=root.right.val;
        }
        root.val=total;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Binary Tree : ");
        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }

        Node root=insertLevelOrder(arr, 0);

        logic(root);

        levelOrderTraversal(root);
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
    public static void levelOrderTraversal(Node root){
        Queue<Node> queue=new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            boolean flag=false;
            for(int i=0;i<size;i++){
                Node node=queue.poll();
                if(node==null){
                    System.out.print(0+" ");
                    continue;
                }
                System.out.print(node.val+" ");
                if(node.left!=null || node.right!=null){
                    flag=true;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            if(flag==false){
                break;
            }
        }
    }
}


