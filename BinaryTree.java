package basic;


public class BinaryTree {
	String value;
	BinaryTree leftChild;
	BinaryTree rightChild;
	
	public BinaryTree(String value,BinaryTree leftChild, BinaryTree rightChild){
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
}
