package ArvoreB;

public class Main {
    public static void main(String[] args) {
        BTree arvoreB = new BTree(3); // Grau 3

        arvoreB.insere(10);
        arvoreB.insere(20);
        arvoreB.insere(5);
        arvoreB.insere(6);
        arvoreB.insere(12);
        arvoreB.insere(30);
        arvoreB.insere(7);
        arvoreB.insere(17);

        System.out.println("Impressão da árvore B:");
        arvoreB.imprimir();

        int chaveParaBuscar = 6;
        BNode resultadoBusca = arvoreB.busca(chaveParaBuscar);
        if (resultadoBusca != null) {
            System.out.println("\nChave " + chaveParaBuscar + " encontrada.");
        } else {
            System.out.println("\nChave " + chaveParaBuscar + " não encontrada.");
        }
    }
}