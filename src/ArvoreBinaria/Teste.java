package ArvoreBinaria;

public class Teste {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(75);
        arvore.inserir(98);
        arvore.inserir(82);
        arvore.inserir(90);
        arvore.inserir(49);
        arvore.inserir(39);
        arvore.inserir(44);
        arvore.inserir(45);

        arvore.imprimirArvoreOriginal();

        System.out.println("Tamanho da árvore: "+arvore.tamanho());

        No raiz = arvore.obterRaiz();
        System.out.println("A raiz da arvore é: "+ raiz.chave);

        arvore.imprimirInOrdem();
        arvore.imprimirPreOrdem();
        arvore.imprimirPosOrdem();

        int chaveBusca = 4;
        System.out.println("Buscando pelo valor "+chaveBusca+": "+arvore.buscar(chaveBusca));

        //arvore.remover(98);
        //arvore.imprimirArvoreOriginal();

        System.out.println("Altura da árvore: " + arvore.altura());

        int chaveNivel = 3;
        System.out.println("Nível do nó " + chaveNivel + ": " + arvore.nivel(chaveNivel));

        int chaveFilhos = 3;
        arvore.encontrarFilhos(chaveFilhos);

        int chaveCaminho = 39;
        System.out.println("Comprimento do caminho até o nó " + chaveCaminho + ": " + arvore.comprimentoCaminho(chaveCaminho));

        arvore.imprimirNosFolha();
        arvore.imprimirPorNiveis();
    }
}
