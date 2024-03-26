public class BinaryTree {
    Node root;


    public BinaryTree() {
        root = null;
//      this.data = null;
    }
    public void insert(int data){
        root = insertRec(root, data);
    }
    private Node insertRec(Node root, int data){
        if (root == null){
            root = new Node(data);
            return  root;
        }
        if (data < root.data){
            root.left = insertRec(root.left, data);
        }else if(data > root.data){
            root.right = insertRec(root.right, data);

        }
        return root;
    }
    public boolean search(int data){
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data){
        if (root == null){
            return false;
        }
        if (root.data == data){
            return true;
        }
        if (data < root.data){
            return searchRec(root.left, data);
        }
        return searchRec(root.right, data);
    }

    public int identification(){

        return 0;
    }
}
