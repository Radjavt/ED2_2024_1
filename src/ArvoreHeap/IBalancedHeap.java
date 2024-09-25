package ArvoreHeap;

public interface IBalancedHeap<T extends Comparable<T>> extends IHeap<T> {
    void heapifyUp(Node<T> node);  // Balanceia a Heap após inserção
    void heapifyDown(Node<T> node);  // Balanceia a Heap após remoção
}