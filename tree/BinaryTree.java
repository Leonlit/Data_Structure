package tree;

public class BinaryTree {
    TreeNode root;

    public BinaryTree (Integer value) {
        if (value != null) {
            this.root = new TreeNode(value);
        }
    }

    public TreeNode getRoot () {
        return this.root;
    }

    //binary search tree
    public String bst (int value) {
        TreeNode current = this.root;
        String path = "";
        if (this.root == null)
            return "";
        path += value;
        while(current != null){
            if(current.getValue() == value){
                System.out.println("Book Exists in library, and the path is as below: \n");
                return path;
            }else if(value < current.getValue()){
                current = current.getLeftNode();
                path += " L " + current.getValue();
            }else{
                current= current.getRightNode();
                path += " R " + current.getValue();
            }
        }
        System.out.println("Value " + value +", does not Exist in the library");
        return "";
    }

    public TreeNode insert (TreeNode root, int value) {
        TreeNode newNode = new TreeNode(value);
        if (root == null) {
            return newNode;
        }else {
            if (value < root.getValue()) {
                root.setLeftNode(insert(root.getLeftNode(), value));
            }else {
                root.setRightNode(insert(root.getRightNode(), value));
            }
        }
        return root;
    }

    //for testing the position
    public void displayTreeInorder (TreeNode root) {
        if (root == null)
            return;
        displayTreeInorder(root.getLeftNode());
        System.out.print(root.getValue() + "   ");
        displayTreeInorder(root.getRightNode());
    }
}
