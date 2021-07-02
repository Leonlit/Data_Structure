package tree;

public class TreeNode {
    
    private int data;
    private TreeNode left, right;

    public TreeNode (int value) {
        this.data = value;
        left = right = null;

    }

    public void setLeftNode (TreeNode node) {
        this.left = node;
    }

    public void setRightNode (TreeNode node) {
        this.right = node;
    }

    public void setNewValue (int newValue) {
        this.data = newValue;
    }

    public TreeNode getLeftNode () {
        return this.left;
    }

    public TreeNode getRightNode () {
        return this.right;
    }

    public int getValue () {
        return this.data;
    }

}