package ArvoreAvl;

public class ArvoreAVL<T extends Comparable<T>> {
    private NoAVL<T> raiz;

    private int altura(NoAVL<T> no) {
        return no == null ? 0 : no.altura;
    }

    private int obterBalanceamento(NoAVL<T> no) {
        return no == null ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private NoAVL<T> rotacaoDireita(NoAVL<T> y) {
        NoAVL<T> x = y.esquerda;
        NoAVL<T> T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private NoAVL<T> rotacaoEsquerda(NoAVL<T> x) {
        NoAVL<T> y = x.direita;
        NoAVL<T> T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public void inserir(T chave) {
        raiz = inserirRec(raiz, chave);
    }

    private NoAVL<T> inserirRec(NoAVL<T> no, T chave) {
        if (no == null) {
            return new NoAVL<>(chave);
        }

        if (chave.compareTo(no.chave) < 0) {
            no.esquerda = inserirRec(no.esquerda, chave);
        } else if (chave.compareTo(no.chave) > 0) {
            no.direita = inserirRec(no.direita, chave);
        } else {
            return no;
        }

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int balanceamento = obterBalanceamento(no);

        if (balanceamento > 1 && chave.compareTo(no.esquerda.chave) < 0) {
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && chave.compareTo(no.direita.chave) > 0) {
            return rotacaoEsquerda(no);
        }

        if (balanceamento > 1 && chave.compareTo(no.esquerda.chave) > 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && chave.compareTo(no.direita.chave) < 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void remover(T chave) {
        raiz = removerRec(raiz, chave);
    }

    private NoAVL<T> removerRec(NoAVL<T> raiz, T chave) {
        if (raiz == null) return raiz;

        if (chave.compareTo(raiz.chave) < 0) {
            raiz.esquerda = removerRec(raiz.esquerda, chave);
        } else if (chave.compareTo(raiz.chave) > 0) {
            raiz.direita = removerRec(raiz.direita, chave);
        } else {
            if ((raiz.esquerda == null) || (raiz.direita == null)) {
                NoAVL<T> temp = null;
                if (temp == raiz.esquerda) temp = raiz.direita;
                else temp = raiz.esquerda;

                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                } else {
                    raiz = temp;
                }
            } else {
                NoAVL<T> temp = valorMinimoNo(raiz.direita);
                raiz.chave = temp.chave;
                raiz.direita = removerRec(raiz.direita, temp.chave);
            }
        }

        if (raiz == null) return raiz;

        raiz.altura = Math.max(altura(raiz.esquerda), altura(raiz.direita)) + 1;

        int balanceamento = obterBalanceamento(raiz);

        if (balanceamento > 1 && obterBalanceamento(raiz.esquerda) >= 0) {
            return rotacaoDireita(raiz);
        }

        if (balanceamento > 1 && obterBalanceamento(raiz.esquerda) < 0) {
            raiz.esquerda = rotacaoEsquerda(raiz.esquerda);
            return rotacaoDireita(raiz);
        }

        if (balanceamento < -1 && obterBalanceamento(raiz.direita) <= 0) {
            return rotacaoEsquerda(raiz);
        }

        if (balanceamento < -1 && obterBalanceamento(raiz.direita) > 0) {
            raiz.direita = rotacaoDireita(raiz.direita);
            return rotacaoEsquerda(raiz);
        }

        return raiz;
    }

    private NoAVL<T> valorMinimoNo(NoAVL<T> no) {
        NoAVL<T> atual = no;
        while (atual.esquerda != null) atual = atual.esquerda;
        return atual;
    }

    public void preOrdem() {
        preOrdemRec(raiz);
        System.out.println();
    }

    private void preOrdemRec(NoAVL<T> no) {
        if (no != null) {
            System.out.print(no.chave + " ");
            preOrdemRec(no.esquerda);
            preOrdemRec(no.direita);
        }
    }

    public void inOrdem() {
        inOrdemRec(raiz);
        System.out.println();
    }

    private void inOrdemRec(NoAVL<T> no) {
        if (no != null) {
            inOrdemRec(no.esquerda);
            System.out.print(no.chave + " ");
            inOrdemRec(no.direita);
        }
    }

    public void posOrdem() {
        posOrdemRec(raiz);
        System.out.println();
    }

    private void posOrdemRec(NoAVL<T> no) {
        if (no != null) {
            posOrdemRec(no.esquerda);
            posOrdemRec(no.direita);
            System.out.print(no.chave + " ");
        }
    }

    public boolean buscar(T chave) {
        return buscarRec(raiz, chave);
    }

    private boolean buscarRec(NoAVL<T> no, T chave) {
        if (no == null) return false;
        if (chave.compareTo(no.chave) == 0) return true;
        return chave.compareTo(no.chave) < 0 ? buscarRec(no.esquerda, chave) : buscarRec(no.direita, chave);
    }

    public void imprimirArvore() {
        inOrdem();
    }
}