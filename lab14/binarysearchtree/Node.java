package binarysearchtree;

public class Node {
    private int item;

    private Node leftChild, rightChild;

    public Node(int item){
        this.item=item;        
    }
    public Node(int item, Node left, Node right){
        this.item=item;
        this.leftChild = left;  
        this.rightChild = right;  
    }

    public Node getLeftChild(){
        return this.leftChild;
    }
    public Node getRightChild(){
        return this.rightChild;
    }

	public int getItem() {
		return this.item; 
	}  
    

    public void setItem(int item) { 
		this.item = item ;
	}

}
