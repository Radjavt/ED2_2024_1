package ArvoreRubroNegra;

public abstract class AbstractBinarySearchTree <T extends Comparable<T>> implements IBalancedTree<T>{
    protected Node<T> root;

    @Override
    public boolean search(T data) {
        return searchTree(root, data) != null;
    }

    public Node<T> searchTree(Node<T> node, T data) {
        if (node == null || data.compareTo(node.data) == 0) {
            return node;
        }
        if (data.compareTo(node.data) < 0) {
            return searchTree(node.left, data);
        } else {
            return searchTree(node.right, data);
        }
    }

    @Override
    public abstract void balanceAfterInsert(Node<T> node);

    @Override
    public abstract void balanceAfterDelete(Node<T> node);
}