package tree;

public class BST_Implementation {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(5);
        tree.insert(tree.getRoot(), 10);
        tree.insert(tree.getRoot(), 8);
        tree.insert(tree.getRoot(), 20);
        tree.insert(tree.getRoot(), 10);
        tree.insert(tree.getRoot(), 4);
        tree.insert(tree.getRoot(), 2);
        System.out.println();
        TreePrinter<Integer> treePrint = new TreePrinter<Integer>(tree.getRoot());
        System.out.println(tree.bst(8));
        treePrint.displayTreePreorder(tree.getRoot());
        treePrint.displayTreeInorder(tree.getRoot());
        treePrint.displayTreePostorder(tree.getRoot());
    }
}
