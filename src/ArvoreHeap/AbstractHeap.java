package ArvoreHeap;

public abstract class AbstractHeap<T extends Comparable<T>> implements IBalancedHeap<T> {
    protected Node<T> root;  // Raiz da Heap

    public boolean search(T data) {
        return searchHeap(root, data) != null;
    }

    private Node<T> searchHeap(Node<T> node, T data) {
        if (node == null || data.compareTo(node.data) == 0)
            return node;
        if (data.compareTo(node.data) < 0)
            return searchHeap(node.left, data);
        else
            return searchHeap(node.right, data);
    }

    public abstract void heapifyUp(Node<T> node);

    public abstract void heapifyDown(Node<T> node);
}
