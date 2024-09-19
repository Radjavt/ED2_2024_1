package ArvoreRubroNegra;
public interface IBalancedTree <T extends Comparable<T>> extends IBinarySearchTree<T>  {

    public static class Node<T> {
        T data;
        Node<T> left, right, parent;
        boolean color;  // true for red, false for black

        Node(T data) {
            this.data = data;
            this.left = this.right = this.parent = null;
        }
    }
    void balanceAfterInsert(Node<T> node);
    void balanceAfterDelete(Node<T> node);
}