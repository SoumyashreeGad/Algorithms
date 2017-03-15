package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AndBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node tree1=new Node(-1);
		tree1.left=new Node(-1);
		tree1.right=new Node(-1);
		tree1.left.left=new Node(1);
		tree1.left.right=new Node(0);
		tree1.right.left=new Node(0);
		tree1.right.right=new Node(1);
		Node tree2=new Node(-1);
		tree2.left=new Node(-1);
		tree2.right=new Node(-1);
		tree2.left.left=new Node(0);
		tree2.left.right=new Node(0);
		tree2.right.left=new Node(1);
		tree2.right.right=new Node(1);
		int[] arr1=inorder(tree1);
		int[] arr2=inorder(tree2);
		int[] arr=and(arr1,arr2);
		System.out.println("Result:");
		Node result= sortedArrayToBST(arr,0,arr.length-1);
		arr=inorder(result);
	}

	private static int[] and(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(int i=0;i<arr1.length;i++){
			if((arr1[i]==1||arr1[i]==0)&&(arr2[i]==1||arr2[i]==0)){
				if((arr1[i]+arr2[i])>1){
					arr.add(1);
				}
				else{
					arr.add(0);
				}
			}
			else{
				arr.add(-1);
			}	
		}		
		int[] ar=new int[arr.size()];
		for(int j=0;j<arr.size();j++){
			ar[j]=arr.get(j);
		}
		return ar;
	}

	static Node sortedArrayToBST(int arr[], int start, int end) {
		 
        /* Base Case */
        if (start > end) {
            return null;
        }
 
        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
 
        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);
 
        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);
         
        return node;
    }
	@SuppressWarnings("null")
	public static int[] inorder(Node root) {
		//int[] arr = new int[Integer.MAX_VALUE];
		List<Integer> arr=new ArrayList<Integer>();
		
        if (root == null) {
            return null;
        }
        int i=0;
        
        //keep the nodes in the path that are waiting to be visited
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
         
        //first node to be visited will be the left one
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
         
        // traverse the tree
        while (stack.size() > 0) {
           
            // visit the top node
            node = stack.pop();
           System.out.print(node.data + " ");
            //arr[i]=node.data;
            //i++;
            arr.add(node.data);
            if (node.right != null) {
                node = node.right;
                 
                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
}
        int[] arr1=new int[arr.size()];
      for(int j=0;j<arr.size();j++)
      {
    	  arr1[j]=arr.get(j);
      }
		return arr1 ;
}}