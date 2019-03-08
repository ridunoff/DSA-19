import static java.lang.Math.max;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    /**
     * Delete a key from the tree rooted at the given node.
     */
    @Override
    TreeNode<T> delete(TreeNode<T> n, T key) {
        n = super.delete(n, key);
        if (n != null) {
            // TODO
            // update the height of the tree using the height of the left and right child
            // return balance(n)

            n.height =  max(height(n.leftChild),height(n.rightChild)) + 1;
            return balance(n);
        }
        return null;
    }

    /**
     * Insert a key into the tree rooted at the given node.
     */
    @Override
    TreeNode<T> insert(TreeNode<T> n, T key) {
        n = super.insert(n, key);
        if (n != null) {
            // TODO
            // update the height of the tree using the height of the left and right child
            // return balance(n)

            n.height =  max(height(n.leftChild),height(n.rightChild)) + 1;
            return balance(n);
        }
        return null;

    }

    /**
     * Delete the minimum descendant of the given node.
     */
    @Override
    TreeNode<T> deleteMin(TreeNode<T> n) {
        n = super.deleteMin(n);
        if (n != null) {
            n.height = 1 + max(height(n.leftChild), height(n.rightChild));
            return balance(n);
        }
        return null;
    }

    // Return the height of the given node. Return -1 if null.
    private int height(TreeNode<T> n) {
        if(n==null) return -1; //if it is empty, return -1
        return n.height;
        //return max(height(n.leftChild),height(n.rightChild)) + 1; //if there is both, return the taller child + 1
    }

    public int height() {
        return max(height(root), 0);
    }

    // Restores the AVL tree property of the subtree. Return the head of the new subtree
    TreeNode<T> balance(TreeNode<T> n) {
        // TODO: (if you're having trouble, use pseudocode provided in slides)
        if(balanceFactor(n) > 1){ //If it is right heavy, rotate left
            if(balanceFactor(n.rightChild) <= -1){
                n.rightChild = rotateRight(n.rightChild); //second rotation for correction
            }
            n = rotateLeft(n);
        }
        if(balanceFactor(n)<-1){ //if it is left heavy, rotate right
            if(balanceFactor(n.leftChild) >= 1){
                n.leftChild = rotateLeft(n.leftChild); //second rotation for correction
            }
            n = rotateRight(n);
        }
        return n;
    }

    /**
     * Returns the balance factor of the subtree. The balance factor is defined
     * as the difference in height of the left subtree and right subtree, in
     * this order. Therefore, a subtree with a balance factor of -1, 0 or 1 has
     * the AVL property since the heights of the two child subtrees differ by at
     * most one.
     */
    private int balanceFactor(TreeNode<T> n) {
        if(n==null) return -1;
        int rightHeight = -1;
        int leftHeight = -1;
        if(n.hasRightChild()){
            rightHeight = n.rightChild.height;
        }
        if(n.hasLeftChild()){
            leftHeight = n.leftChild.height;
        }
        return rightHeight - leftHeight;
    }

    /**
     * Perform a right rotation on node `n`. Return the head of the rotated tree.
     */
    private TreeNode<T> rotateRight(TreeNode<T> n) {
        TreeNode<T> y = n.leftChild;
        TreeNode<T> beta = y.rightChild;
        y.rightChild = n;
        n.leftChild = beta;
        n.height = max(height(n.leftChild),height(n.rightChild)) + 1;
        y.height = max(height(y.leftChild),height(y.rightChild)) + 1;
        return y;
    }

    /**
     * Perform a left rotation on node `n`. Return the head of the rotated tree.
     */
    private TreeNode<T> rotateLeft(TreeNode<T> n) {
        TreeNode<T> y = n.rightChild;
        TreeNode<T> beta = y.leftChild;
        y.leftChild = n;
        n.rightChild = beta;
        n.height = max(height(n.leftChild),height(n.rightChild)) + 1;
        y.height = max(height(y.leftChild),height(y.rightChild)) + 1;
        return y;
    }
}
