package ArvoreHeap;

public class Node<T extends Comparable<T>> {
    T data;
    Node<T> left, right, parent;

    // Construtor para inicializar o nó com o dado fornecido
    public Node(T data) {
        this.data = data;
        this.left = this.right = this.parent = null;
    }
}