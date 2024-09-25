package ArvoreB;

public class BTree {
    BNode raiz;
    int grau;

    public BTree(int grau) {
        this.grau = grau;
        this.raiz = null;
    }

    // Busca uma chave na árvore
    public BNode busca(int chave) {
        if (raiz == null) {
            return null;
        } else {
            return raiz.busca(chave);
        }
    }

    // Insere uma nova chave na árvore
    public void insere(int chave) {
        if (raiz == null) {
            raiz = new BNode(grau, true);
            raiz.chaves[0] = chave;
            raiz.numChaves = 1;
        } else {
            if (raiz.numChaves == 2 * grau - 1) {
                BNode s = new BNode(grau, false);
                s.filhos[0] = raiz;
                s.divideFilho(0, raiz);

                int i = 0;
                if (s.chaves[0] < chave) {
                    i++;
                }
                s.filhos[i].insereNaoCheio(chave);

                raiz = s;
            } else {
                raiz.insereNaoCheio(chave);
            }
        }
    }

    // Imprime a árvore
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
}