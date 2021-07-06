package tree;

public class CheckIfTreeIsValid {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(7);
        TreeNode<Integer> n1 = new TreeNode<Integer>(4);
        n1.setLeftNode(new TreeNode<Integer>(1));
        n1.setRightNode(new TreeNode<Integer>(6));
        root.setLeftNode(n1);
        root.setRightNode(new TreeNode<Integer>(9));
        System.out.println(fasterTreeCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    //faster approach using limits, time complexity O(n). Since every node only passed through one time
    public static boolean fasterTreeCheck(TreeNode<Integer> node, int min, int max) {
        if (isNodeNull(node))
            return true;

        if (node.getValue() > min
            && node.getValue() < max
            && fasterTreeCheck(node.getLeftNode(), min, node.getValue())
            && fasterTreeCheck(node.getRightNode(), node.getValue(), max)
            ) {
            return true;
        }
        return false;
    }


    //slow approach, need O(n^) time complexity
    public static boolean isValidTree (TreeNode<Integer> currNode) {
        if (isNodeNull(currNode)) {
            return true;
        }

        if (isSubTreeLesser(currNode.getLeftNode(), currNode.getValue())
            && isSubTreeGreater(currNode.getRightNode(), currNode.getValue())
            && isValidTree(currNode.getLeftNode())
            && isValidTree(currNode.getRightNode())
        ) {
            return true;
        }
        return false;
    }

    public static boolean isSubTreeLesser(TreeNode<Integer> node, int value) {
        if (isNodeNull(node)) {
            return true;
        }

        if (node.getValue() < value
            && isSubTreeLesser(node.getLeftNode(), value)
            && isSubTreeLesser(node.getRightNode(), value)
        ) {
            return true;
        }
        return false;
    }

    public static boolean isSubTreeGreater (TreeNode<Integer> node, int value) {
        if (isNodeNull(node)) {
            return true;
        }
        return node.getValue() >= value;
    }
    
    public static boolean isNodeNull (TreeNode<Integer> node) {   
        return node == null;
    }
}
