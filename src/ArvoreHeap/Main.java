package ArvoreHeap;

public class Main {
    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<>();  // Cria uma MinHeap de inteiros

        // Insere valores na Heap
        heap.insert(15);
        heap.insert(10);
        heap.insert(30);
        heap.insert(5);

        // Remove e exibe o menor elemento (que deve ser o 5)
        System.out.println("Removendo elemento: " + heap.delete());  // Saída: Removendo elemento: 5
        // Remove e exibe o próximo menor elemento (que deve ser o 10)
        System.out.println("Removendo elemento: " + heap.delete());  // Saída: Removendo elemento: 10
        // Remove e exibe o próximo menor elemento (que deve ser o 15)
        System.out.println("Removendo elemento: " + heap.delete());  // Saída: Removendo elemento: 15
        // Remove e exibe o próximo menor elemento (que deve ser o 30)
        System.out.println("Removendo elemento: " + heap.delete());  // Saída: Removendo elemento: 30
    }
}