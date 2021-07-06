package tree;

public class BinaryTree<type extends Comparable<type>> {
    TreeNode<type> root;

    public BinaryTree (type value) {
        if (value != null) {
            this.root = new TreeNode<type>(value);
        }
    }

    public TreeNode<type> getRoot () {
        return this.root;
    }

    //binary search tree
    public String bst (type value) {
        TreeNode<type> current = this.root;
        String path = "";
        if (this.root == null)
            return "";
        path += value;
        while(current != null){
            if(current.getValue() == value){
                System.out.println("The value is found in the tree");
                return path;
            }else if(value.compareTo(current.getValue()) < 0){
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

    public boolean insert (type value) {
        if (value == null) {
            System.out.println("No value is provided");
        }else{
            if (!contains(value)) {
                this.root = insert(this.root, value);
                return true;
            }else {
                System.out.println("Error, dupplicate value");
            }
        }
        return false;
    }

    public TreeNode<type> insert (TreeNode<type> root, type value) {

        TreeNode<type> newNode = new TreeNode<type>(value);

        if (root == null) {
            return newNode;
        }

        if (value.compareTo(root.getValue()) < 0) {
            root.setLeftNode(insert(root.getLeftNode(), value));
        }else {
            root.setRightNode(insert(root.getRightNode(), value));
        }
        return root;
    }

    public boolean contains (type value) {
        return contains (this.root, value);
    }

    public boolean contains(TreeNode<type> root, type value) {
        if (isNodeNull(root)) {
            return false;
        }

        int cmp = value.compareTo(root.getValue());
        if (cmp < 0)
            return contains(root.getLeftNode(), value);
        if (cmp > 0)
            return contains (root.getRightNode(), value);
        
        return true;
    }

    public boolean isNodeNull (TreeNode<type> node) {   
        return node == null;
    }

    public int treeHeight (TreeNode<type> root) {
        if (root == null) {
            return -1;
        }
        int leftSubTree = treeHeight(root.getLeftNode());
        int rightSubTree = treeHeight(root.getRightNode());
        return Math.max(leftSubTree, rightSubTree) + 1;
    }
}
