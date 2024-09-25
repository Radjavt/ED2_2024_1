package ArvoreHeap;

import java.util.LinkedList;
import java.util.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class MinHeap<T extends Comparable<T>> extends AbstractHeap<T> {

    @Override
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);  // Cria um novo nó
        if (root == null) {
            root = newNode;  // Se a árvore estiver vazia, o novo nó será a raiz
        } else {
            insertNode(root, newNode);  // Insere o novo nó na posição apropriada
            heapifyUp(newNode);  // Balanceia a Heap (Heapify Up)
        }
    }

    @Override
    public T delete() {
        if (root == null) {
            throw new IllegalStateException("Heap is empty");
        }

        T removedData = root.data;  // Armazena o dado da raiz para retorno

        // Substitui o dado da raiz com o último nó da heap
        Node<T> lastNode = getLastNode();
        if (lastNode == root) {
            root = null;  // Se a árvore só tem um nó, a raiz fica nula após a remoção
        } else {
            root.data = lastNode.data;  // Substitui o dado da raiz pelo último
            removeLastNode(lastNode);  // Remove fisicamente o último nó da árvore
            heapifyDown(root);  // Reorganiza a heap a partir da nova raiz
        }

        return removedData;
    }

    // Implementação do método insertNode para encontrar a primeira posição vazia na árvore
    private void insertNode(Node<T> root, Node<T> newNode) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();

            // Verifica se há espaço no lado esquerdo
            if (current.left == null) {
                current.left = newNode;
                newNode.parent = current;
                return;
            } else {
                queue.add(current.left);
            }

            // Verifica se há espaço no lado direito
            if (current.right == null) {
                current.right = newNode;
                newNode.parent = current;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    // Balanceia a árvore após inserção (subindo o nó para manter a propriedade de Heap)
    @Override
    public void heapifyUp(Node<T> node) {
        while (node.parent != null && node.data.compareTo(node.parent.data) < 0) {
            swap(node, node.parent);  // Troca o nó com seu pai, se necessário
            node = node.parent;  // Continua subindo até a raiz
        }
    }

    // Balanceia a árvore após remoção (descendo o nó para manter a propriedade de Heap)
    @Override
    public void heapifyDown(Node<T> node) {
        while (node.left != null) {
            Node<T> smallerChild = node.left;

            // Seleciona o menor filho para comparar com o nó atual
            if (node.right != null && node.right.data.compareTo(node.left.data) < 0) {
                smallerChild = node.right;
            }

            // Se o nó atual for maior que o menor filho, troca de posição
            if (node.data.compareTo(smallerChild.data) > 0) {
                swap(node, smallerChild);
                node = smallerChild;  // Continua descendo
            } else {
                break;  // Se não precisar trocar, o balanceamento está completo
            }
        }
    }

    // Método auxiliar para obter o último nó da heap
    private Node<T> getLastNode() {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        Node<T> lastNode = null;

        // Percorre a árvore por nível para encontrar o último nó
        while (!queue.isEmpty()) {
            lastNode = queue.poll();

            if (lastNode.left != null) queue.add(lastNode.left);
            if (lastNode.right != null) queue.add(lastNode.right);
        }

        return lastNode;  // Retorna o último nó encontrado na travessia por nível
    }

    // Método auxiliar para remover o último nó da heap
    private void removeLastNode(Node<T> lastNode) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        Node<T> parent = null;

        // Percorre a árvore para encontrar o pai do último nó
        while (!queue.isEmpty()) {
            parent = queue.poll();

            if (parent.left != null) {
                if (parent.left == lastNode) {
                    parent.left = null;  // Remove o último nó se for filho esquerdo
                    return;
                }
                queue.add(parent.left);
            }

            if (parent.right != null) {
                if (parent.right == lastNode) {
                    parent.right = null;  // Remove o último nó se for filho direito
                    return;
                }
                queue.add(parent.right);
            }
        }
    }

    // Método para trocar os dados de dois nós
    private void swap(Node<T> node1, Node<T> node2) {
        T temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }
}