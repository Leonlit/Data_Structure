package tree;

public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<Integer>(5);
        tree.insert(10);
        tree.insert(8);
        tree.insert(20);
        tree.insert(10);
        tree.insert(4);
        tree.insert(2);
        System.out.println();
        tree.displayTreePreorder(tree.getRoot());
        tree.displayTreeInorder(tree.getRoot());
        tree.displayTreePostorder(tree.getRoot());
    }
}
