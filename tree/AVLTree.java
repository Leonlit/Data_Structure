package tree;

public class AVLTree<type extends Comparable<type>> {

    class AVLNode extends TreeNode<type>{
        int bf;
        int height;
        AVLNode left, right;

        public AVLNode (type value) {
            super(value);
        }

        @Override
        public AVLNode getLeftNode () {
            return this.left;
        }

        @Override
        public AVLNode getRightNode () {
            return this.right;
        }
        
    }

    AVLNode root;
    int nodeCount;

    public AVLTree (type value) {
        if (value == null) {
            System.out.println("Note, no initial value is given into tree node");
            return;
        }
        this.root = new AVLNode(value);
        this.nodeCount = 1;
    }

    public boolean insertNode(type value) {
        if (value == null) {
            System.out.println("No value is provided");
        }else {
            if (!contains(this.root, value)) {
                this.root = insertNode(this.root, value);
                nodeCount++;
                return true;
            }
        }
        return false;
    }

    public AVLNode insertNode(AVLNode root, type value) {
        if (root == null)
            return new AVLNode(value);
        
        int cmp = value.compareTo(root.getValue());
        if (cmp < 0) 
            root.setLeftNode(insertNode(root.getLeftNode(), value));
        else 
            root.setRightNode(insertNode(root.getRightNode(), value));
        updateNode(root);
        return balance(root);
    }

    public boolean contains (type value) {
        return contains(this.root, value);
    }

    public boolean contains (AVLNode root, type value) {
        if (root == null) {
            return false;
        }

        int cmp = value.compareTo(root.getValue());
        if (cmp < 0)
            return contains (root.getLeftNode(), value);
        if (cmp > 0)
            return contains (root.getRightNode(), value);

        return true;
    }

    private void updateNode (AVLNode node) {
        int leftNodeHeight = (node.getLeftNode() == null) ? -1: node.getLeftNode().height;
        int rightNodeHeight =  (node.getRightNode() == null) ? -1: node.getRightNode().height;

        node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);
        node.bf = rightNodeHeight - leftNodeHeight;
    }

    private AVLNode balance(AVLNode node) {
        if (node.bf == -2) {
            if (node.getLeftNode().bf <= 0) {
                return leftLeftCase(node);
            }else {
                return leftRightCase(node);
            }
        }else if (node.bf == +2) {
            if (node.getRightNode().bf >= 0) {
                return rightRightCase(node);
            }else {
                return rightLeftCase(node);
            }   
        }
        return node;
    }

    private AVLNode leftLeftCase (AVLNode node) {
        return rightRotation(node);
    }

    private AVLNode rightRightCase (AVLNode node) {
        return leftRotation(node);
    }

    private AVLNode leftRightCase(AVLNode node) {
        node.setLeftNode(leftRotation(node.getLeftNode()));
        return leftLeftCase(node);
    }

    private AVLNode rightLeftCase(AVLNode node) {
        node.setRightNode(rightRotation(node.getRightNode()));
        return rightRightCase(node);
    }

    private AVLNode leftRotation(AVLNode node) {
        AVLNode newParent = node.getRightNode();
        node.setRightNode(newParent.getLeftNode());
        newParent.setLeftNode(node);
        updateNode(node);
        updateNode(newParent);
        return newParent;
    }

    private AVLNode rightRotation (AVLNode node) {
        AVLNode newParent = node.getLeftNode();
        node.setLeftNode(newParent.getRightNode());
        newParent.setRightNode(node);
        updateNode(newParent);
        updateNode(node);
        return newParent;
    }
    
    public int getHeight(){
        return this.root.height;
    }

    public int getSize () {
        return this.nodeCount;
    }

    public boolean isEmpty () {
        return getSize() == 0;
    }
}


