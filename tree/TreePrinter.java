package tree;

public class TreePrinter<type> {

    TreeNode<type> initial;

    public TreePrinter (TreeNode<type> initial) {
        this.initial = initial;
    }

    //for testing the position
    public void displayTreeInorder (TreeNode<type> root) {
        if (root == null)
            return;
        displayTreeInorder(root.getLeftNode());
        System.out.print(root.getValue() + "   ");
        displayTreeInorder(root.getRightNode());
        if (root == initial) {
            System.out.println();
        }
    }

    public void displayTreePreorder (TreeNode<type> root) {
        if (root == null)
            return;
        System.out.print(root.getValue() + "   ");
        displayTreeInorder(root.getLeftNode());
        displayTreeInorder(root.getRightNode());
        if (root == initial) {
            System.out.println();
        }
    }

    public void displayTreePostorder (TreeNode<type> root) {
        if (root == null)
            return;
        displayTreeInorder(root.getLeftNode());
        displayTreeInorder(root.getRightNode());
        System.out.print(root.getValue() + "   ");
        if (root == initial) {
            System.out.println();
        }
    }
}
