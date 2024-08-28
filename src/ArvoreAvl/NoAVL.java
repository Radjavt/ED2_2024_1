package ArvoreAvl;

public class NoAVL <T extends Comparable<T>> {
        T chave;
        int altura;
        NoAVL<T> esquerda, direita;

        NoAVL(T chave) {
        this.chave = chave;
        this.altura = 1;

        }
}