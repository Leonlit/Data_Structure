package tree;

public class AVLTree<type extends Comparable<type>> {

    class AVLNode{
        int bf;
        int height;
        type value;
        AVLNode left, right;

        public AVLNode (type value) {
            this.value = value;
            left = right = null;
        }

        public AVLNode getLeftNode () {
            return this.left;
        }

        public AVLNode getRightNode () {
            return this.right;
        }

        public type getValue() {
            return this.value;
        }

        public void setRightNode (AVLNode node) {
            this.right = node;
        }

        public void setLeftNode (AVLNode node) {
            this.left = node;
        }

        public void setNewValue (type value) {
            if (value == null) 
                return;
            this.value = value;
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

    public boolean insert(type value) {
        if (value == null) {
            System.out.println("No value is provided");
        }else {
            if (!contains(this.root, value)) {
                this.root = insert(this.root, value);
                nodeCount++;
                return true;
            }else {
                System.out.println("duplicate value");
            }
        }
        return false;
    }

    private AVLNode insert(AVLNode node, type value) {
        if (node == null)
            return new AVLNode(value);
        
        int cmp = value.compareTo(node.getValue());
        System.out.println(cmp);
        if (cmp < 0) {
            System.out.println("inserted " + value + " to left");
            node.setLeftNode(insert(node.getLeftNode(), value));
        }else {
            System.out.println("inserted " + value + " to right");
            node.setRightNode(insert(node.getRightNode(), value));
        }
        updateNode(node);
        return balance(node);
    }

    public boolean contains (type value) {
        return contains(this.root, value);
    }

    private boolean contains (AVLNode node, type value) {
        if (node == null) {
            return false;
        }

        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) {
            return contains (node.getLeftNode(), value);
        }
        if (cmp > 0) {
            //System.out.println("test");
            return contains (node.getRightNode(), value);
        }

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

    public boolean remove(type value) {
        if (contains(this.root, value)) {
            this.root = remove(this.root, value);
            return true;
        }
        return false;
    }

    private AVLNode remove (AVLNode node, type value) {
        if (isNodeNull(node)) {
            return null;
        }
        int cmp = value.compareTo(node.getValue());

        if (cmp < 0) 
            node.setLeftNode(remove(node.getLeftNode(), value));
        else if (cmp > 0)
            node.setRightNode(remove(node.getRightNode(), value));
        else {
            if (isNodeNull(node.getLeftNode())) {  //only when the right tree is present and left side is null
                AVLNode tempRight = node.getRightNode();
                node.setNewValue(null);
                node = null;
                return tempRight;
            }else if (isNodeNull(node.getRightNode())) { //only when the left tree is present and right side is null
                AVLNode tempLeft = node.getLeftNode();
                node.setNewValue(null);
                node = null;
                return tempLeft;
            }else { //both subtree present
                //choose the one with higher high
                if (node.getLeftNode().height < node.getRightNode().height ) {
                    //digging through the right nodes of the left node of the current node
                    AVLNode temp = findMax(node.getLeftNode());
                    //swapping the values
                    node.setNewValue(temp.getValue());
                    //removing the node used to replace the deleted node
                    node.setLeftNode(remove(node.getLeftNode(),temp.getValue()));
                }else {
                    //digging through the left nodes of the right subtree node of the current node
                    AVLNode temp = findMin(node.getRightNode());
                    //swapping the values
                    node.setNewValue(temp.getValue());
                    //removing the node used to replace the deleted node
                    node.setRightNode(remove(node.getRightNode(),temp.getValue()));
                }

            }
        }
        updateNode(node);
        return balance(node);
    }

    public AVLNode findMax (AVLNode node) {
        while (node.getRightNode() != null) {
            node = node.getRightNode();
        }
        return node;
    }

    public AVLNode findMin (AVLNode node) {
        while (node.getLeftNode() != null) {
            node = node.getLeftNode();
        }
        return node;
    }

    public boolean isNodeNull (AVLNode node) {
        return node == null;
    }
    
    public int getHeight(){
        return this.root.height;
    }

    public int getSize () {
        return this.nodeCount;
    }

    public AVLNode getRoot () {
        return this.root;
    }

    public boolean isEmpty () {
        return getSize() == 0;
    }

    public void displayTreeInorder (AVLNode node) {
        if (node == null)
            return;
        displayTreeInorder(node.getLeftNode());
        System.out.print(node.getValue() + "   ");
        displayTreeInorder(node.getRightNode());
        if (node == this.root) {
            System.out.println();
        }
    }

    public void displayTreePreorder (AVLNode node) {
        if (node == null)
            return;
        System.out.print(node.getValue() + "   ");
        displayTreeInorder(node.getLeftNode());
        displayTreeInorder(node.getRightNode());
        if (node == this.root) {
            System.out.println();
        }
    }

    public void displayTreePostorder (AVLNode node) {
        if (node == null)
            return;
        displayTreeInorder(node.getLeftNode());
        displayTreeInorder(node.getRightNode());
        System.out.print(node.getValue() + "   ");
        if (node == this.root) {
            System.out.println();
        }
    }
}


