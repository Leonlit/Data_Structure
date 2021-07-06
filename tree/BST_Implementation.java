package tree;

public class BST_Implementation {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(5);
        tree.insert(10);
        tree.insert(8);
        tree.insert(20);
        tree.insert(10);
        tree.insert(4);
        tree.insert(2);
        System.out.println();
        TreePrinter<Integer> treePrint = new TreePrinter<Integer>(tree.getRoot());
        System.out.println(tree.bst(8));
        treePrint.displayTreePreorder(tree.getRoot());
        treePrint.displayTreeInorder(tree.getRoot());
        treePrint.displayTreePostorder(tree.getRoot());

        tree.remove(10);
        treePrint.displayTreePreorder(tree.getRoot());
        treePrint.displayTreeInorder(tree.getRoot());
        treePrint.displayTreePostorder(tree.getRoot());
    }
}
