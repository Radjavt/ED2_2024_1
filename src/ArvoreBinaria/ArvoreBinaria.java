package ArvoreBinaria;

import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
       raiz = null;

    }

    void inserir(int chave) {
        raiz = inserirRecursivamente(raiz, chave);
    }

    No inserirRecursivamente(No no, int chave) {
        if (no == null) {
            no = new No(chave);
            return no;
        }
        if (chave < no.chave) {
            no.esquerda = inserirRecursivamente(no.esquerda, chave);
        } else if (chave > no.chave) {
            no.direita = inserirRecursivamente(no.direita, chave);
        }
        return no;
    }

    void inOrdem(No no){
        if(no != null){
          inOrdem(no.esquerda);
          System.out.print(no.chave+ " ");
          inOrdem(no.direita);
        }
    }

    void preOrdem(No no){
        if(no != null){
            System.out.print(no.chave+" ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }

    void posOrdem(No no){
        if(no != null){
           posOrdem(no.esquerda);
           posOrdem(no.direita);
            System.out.print(no.chave+" ");
        }
    }

    boolean buscar(int chave){
        return buscarRecursivamente(raiz, chave);
    }

    boolean buscarRecursivamente(No no, int chave){
        if(no == null){
            return false;
        }
        if(no.chave == chave){
            return true;
        }
        return (chave < no.chave) ? buscarRecursivamente(no.esquerda, chave) : buscarRecursivamente(no.direita, chave);
    }

    void remover(int chave ){
        raiz = removerRecursivamente(raiz, chave);
    }

    No removerRecursivamente(No no, int chave){
        if(no == null){
            return null;
        }
        if(chave < no.chave){
            no.esquerda = removerRecursivamente(no.esquerda,chave);
            } else if (chave > no.chave) {
            no.direita =removerRecursivamente(no.direita,chave);
        }else{
            if(no.esquerda == null){
                return no.direita;
            } else if (no.direita == null) {
                return no.esquerda;
            }
        }
        return no;
    }
    int minValor(No no){
        int minv = no.chave;
        while(no.esquerda != null){
            minv = no.esquerda.chave;
            no = no.esquerda;
        }
        return minv;
    }

    int tamanho(){
        return tamanhoRecursivo(raiz);
    }

    int tamanhoRecursivo(No no){
        if(no == null){
            return 0;
        }else{
            return tamanhoRecursivo(no.esquerda) + 1 + tamanhoRecursivo(no.direita);
        }
    }

    No obterRaiz(){
        return raiz;
    }

    void imprimirArvoreOriginal(){
        System.out.print("Árvore original: ");
        imprimirArvore(raiz);
        System.out.println();
    }

    void imprimirArvore(No no){
        if(no != null){
            System.out.print(no.chave + " ");
            imprimirArvore(no.esquerda);
            imprimirArvore(no.direita);
        }
    }

    int altura(){
        return alturaRecursiva(raiz);
    }

    int alturaRecursiva(No no){
        if(no == null){
            return 0;

        }else{
            int alturaEsquerda = alturaRecursiva(no.esquerda);
            int alturaDireita = alturaRecursiva(no.direita);

            return (alturaEsquerda > alturaDireita) ? (alturaEsquerda + 1) : (alturaDireita + 1);
        }
    }

    int nivel(int chave) {
        return nivelRecursivo(raiz, chave, 1);
    }

    int nivelRecursivo(No no, int chave, int nivel) {
        if (no == null)
            return 0;

        if (no.chave == chave)
            return nivel;

        int nivelEsquerda = nivelRecursivo(no.esquerda, chave, nivel + 1);
        if (nivelEsquerda != 0)
            return nivelEsquerda;

        return nivelRecursivo(no.direita, chave, nivel + 1);
    }

    // Método para encontrar o pai de um nó na árvore
    No encontrarPai(No no, int chave) {
        if (no == null || (no.esquerda != null && no.esquerda.chave == chave) || (no.direita != null && no.direita.chave == chave))
            return no;

        if (chave < no.chave)
            return encontrarPai(no.esquerda, chave);

        return encontrarPai(no.direita, chave);
    }

    // Método para encontrar os filhos de um nó na árvore
    void encontrarFilhos(int chave) {
        No pai = encontrarPai(raiz, chave);

        if (pai == null)
            System.out.println("Nó não encontrado ou é a raiz da árvore.");

        else {
            if (pai.esquerda != null && pai.esquerda.chave == chave)
                System.out.println("Filho esquerdo: " + pai.esquerda.chave);
            else
                System.out.println("Filho esquerdo: Nenhum");

            if (pai.direita != null && pai.direita.chave == chave)
                System.out.println("Filho direito: " + pai.direita.chave);
            else
                System.out.println("Filho direito: Nenhum");
        }
    }

    int comprimentoCaminho(int chave) {
        return nivel(chave) - 1;
    }


    void imprimirInOrdem() {
        System.out.println("Percorrendo a árvore em ordem:");
        inOrdem(raiz);
        System.out.println();
    }


    void imprimirPreOrdem() {
        System.out.println("Percorrendo a árvore em pré-ordem:");
        preOrdem(raiz);
        System.out.println();
    }

    void imprimirPosOrdem() {
        System.out.println("Percorrendo a árvore em pós-ordem:");
        posOrdem(raiz);
        System.out.println();
    }


    boolean isFolha(No no) {
        return (no != null && no.esquerda == null && no.direita == null);
    }

    void imprimirNosFolha() {
        System.out.println("Nós folha:");
        imprimirNosFolhaRecursivo(raiz);
        System.out.println();
    }

    void imprimirNosFolhaRecursivo(No no) {
        if (no != null) {
            if (isFolha(no))
                System.out.print(no.chave + " ");
            imprimirNosFolhaRecursivo(no.esquerda);
            imprimirNosFolhaRecursivo(no.direita);
        }
    }

    void imprimirPorNiveis() {
        System.out.println("Imprimindo a árvore por níveis:");

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No no = fila.poll();
            System.out.print(no.chave + " ");

            if (no.esquerda != null) {
                fila.add(no.esquerda);
            }
            if (no.direita != null) {
                fila.add(no.direita);
            }
        }
        System.out.println();
    }
}