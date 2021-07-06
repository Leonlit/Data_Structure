package tree;

public class TreeNode<type> {
    
    private type data;
    private TreeNode<type> left, right;

    public TreeNode (type value) {
        this.data = value;
        left = right = null;
    }

    public void setLeftNode (TreeNode<type> node) {
        this.left = node;
    }

    public void setRightNode (TreeNode<type> node) {
        this.right = node;
    }

    public void setNewValue (type newValue) {
        this.data = newValue;
    }

    public TreeNode<type> getLeftNode () {
        return this.left;
    }

    public TreeNode<type> getRightNode () {
        return this.right;
    }

    public type getValue () {
        return this.data;
    }

}