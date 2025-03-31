package binarysearchtree;

public class BST {
    private Node root;

    public BST(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void BSTFromArray(int items[]) {
        this.root = new Node(items[0]);
        for (int i = 1; i < items.length; i++) {
            Node currentItem = new Node(items[i]);
            Node tempNode = this.root;
            while (tempNode != null) {
                if (currentItem.getItem() <= tempNode.getItem()) {
                    tempNode = tempNode.getLeftChild();
                } else {
                    tempNode = tempNode.getRightChild();
                }
            }

        }
    }
    public void ArrayFromBST(){
        Node tempNode = this.root;
        while(tempNode.getLeftChild() != null || tempNode.getRightChild() != null){
            tempNode = tempNode.getLeftChild();
        }
    }

}
