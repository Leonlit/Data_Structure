package tree;

public class AVLTreeTest {
    public static void main(String[] args) {
        // 33, 13, 52, 9, 21, 61, 8, 11
        AVLTree<Integer> tree = new AVLTree<Integer>(33);
        tree.insert(13);
        tree.insert(52);
        tree.insert(9);
        tree.insert(21);
        tree.insert(61);
        tree.insert(8);
        tree.insert(11);
        
        /* Expected output
            33   13   9   8   11   21   52   61
            8   9   11   13   21   33   52   61
            8   11   9   21   13   61   52   33
        */

        System.out.println();
        tree.displayTreePreorder(tree.getRoot());
        tree.displayTreeInorder(tree.getRoot());
        tree.displayTreePostorder(tree.getRoot());

        tree.remove(13);

        System.out.println();
        tree.displayTreePreorder(tree.getRoot());
        tree.displayTreeInorder(tree.getRoot());
        tree.displayTreePostorder(tree.getRoot());
    }
}
