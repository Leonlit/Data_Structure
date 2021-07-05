package tree;

public class BST_Implementation {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(5);
        tree.insert(tree.getRoot(), 10);
        tree.insert(tree.getRoot(), 8);
        tree.insert(tree.getRoot(), 20);
        tree.insert(tree.getRoot(), 10);
        tree.insert(tree.getRoot(), 4);
        tree.insert(tree.getRoot(), 2);
        System.out.println();
        tree.displayTreeInorder(tree.getRoot());
        System.out.println(tree.bst(8));
        tree.displayTreePreorder(tree.getRoot());
        tree.displayTreePostorder(tree.getRoot());
    }
}
