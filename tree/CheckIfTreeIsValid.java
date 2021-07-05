package tree;

public class CheckIfTreeIsValid {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode n1 = new TreeNode(4);
        n1.setLeftNode(new TreeNode(1));
        n1.setRightNode(new TreeNode(6));
        root.setLeftNode(n1);
        root.setRightNode(new TreeNode(9));
        System.out.println(fasterTreeCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    //faster approach using limits, time complexity O(n). Since every node only passed through one time
    public static boolean fasterTreeCheck(TreeNode node, int min, int max) {
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
    public static boolean isValidTree (TreeNode currNode) {
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

    public static boolean isSubTreeLesser(TreeNode node, int value) {
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

    public static boolean isSubTreeGreater (TreeNode node, int value) {
        if (isNodeNull(node)) {
            return true;
        }
        return node.getValue() >= value;
    }
    
    public static boolean isNodeNull (TreeNode node) {   
        return node == null;
    }
}
