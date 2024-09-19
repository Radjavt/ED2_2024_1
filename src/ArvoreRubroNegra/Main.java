package ArvoreRubroNegra;

public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer> rbTree = new RedBlackTree<>();


        System.out.println("Inserindo valores na árvore:");
        rbTree.insert(10);
        rbTree.insert(20);
        rbTree.insert(30);
        rbTree.insert(15);
        rbTree.insert(25);
        rbTree.insert(5);

        // Verificando se a raiz é preta após inserções
        System.out.println("A raiz é preta após inserções? " + (rbTree.root.color == RedBlackTree.BLACK));

        // Imprimindo a árvore após inserções
        System.out.println("Árvore após inserções (in-order):");
        rbTree.printInOrder();

        IBalancedTree.Node<Integer> node20 = rbTree.searchTree(rbTree.root, 20);
        if (node20 != null) {
            System.out.println("O nó com valor 20 é vermelho? " + (node20.color == RedBlackTree.RED));
        } else {
            System.out.println("O nó com valor 20 não foi encontrado.");
        }


        // Teste de exclusão
        System.out.println("\nExcluindo o valor 15:");
        rbTree.delete(15);
        System.out.println("A raiz é preta após excluir 15? " + (rbTree.root.color == RedBlackTree.BLACK));
        rbTree.printInOrder();

        System.out.println("\nExcluindo o valor 10:");
        rbTree.delete(10);
        System.out.println("A raiz é preta após excluir 10? " + (rbTree.root.color == RedBlackTree.BLACK));
        rbTree.printInOrder();

        System.out.println("\nExcluindo o valor 30:");
        rbTree.delete(30);
        System.out.println("A raiz é preta após excluir 30? " + (rbTree.root.color == RedBlackTree.BLACK));
        rbTree.printInOrder();

        // Imprimindo a árvore final
        System.out.println("\nÁrvore final:");
        rbTree.printInOrder();
        System.out.println("A raiz é preta na árvore final? " + (rbTree.root.color == RedBlackTree.BLACK));
    }
}