package ArvoreHeap;

public interface IHeap<T extends Comparable<T>> {
    void insert(T data);  // Insere um dado na Heap
    T delete();  // Remove e retorna o elemento da raiz (min ou max)
    boolean search(T data);  // Verifica se um dado está presente na Heap
}