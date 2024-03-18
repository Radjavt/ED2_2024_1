package ArvoreBinaria;

public class No {
    int chave;
    No esquerda, direita;

    public No(int valor){
        chave = valor;
        esquerda = direita = null;
    }
}