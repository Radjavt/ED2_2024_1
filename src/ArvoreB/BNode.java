package ArvoreB;

public class BNode {
    int[] chaves; // Array de chaves
    int grau; // Grau da árvore B
    BNode[] filhos; // Array de filhos
    int numChaves; // Número de chaves presentes no nó
    boolean folha; // Verifica se é um nó folha

    // Construtor
    public BNode(int grau, boolean folha) {
        this.grau = grau;
        this.folha = folha;
        this.chaves = new int[2 * grau - 1]; // Máximo de chaves
        this.filhos = new BNode[2 * grau]; // Máximo de filhos
        this.numChaves = 0; // Inicialmente sem chaves
    }

    // Busca uma chave no nó
    public BNode busca(int chave) {
        int i = 0;
        while (i < numChaves && chave > chaves[i]) {
            i++;
        }

        if (chaves[i] == chave) {
            return this;
        }

        if (folha) {
            return null;
        }

        return filhos[i].busca(chave);
    }

    // Insere uma nova chave no nó
    public void insereNaoCheio(int chave) {
        int i = numChaves - 1;

        if (folha) {
            while (i >= 0 && chaves[i] > chave) {
                chaves[i + 1] = chaves[i];
                i--;
            }

            chaves[i + 1] = chave;
            numChaves++;
        } else {
            while (i >= 0 && chaves[i] > chave) {
                i--;
            }

            if (filhos[i + 1].numChaves == 2 * grau - 1) {
                divideFilho(i + 1, filhos[i + 1]);

                if (chaves[i + 1] < chave) {
                    i++;
                }
            }

            filhos[i + 1].insereNaoCheio(chave);
        }
    }

    // Divide o filho y do nó atual
    public void divideFilho(int i, BNode y) {
        BNode z = new BNode(y.grau, y.folha);
        z.numChaves = grau - 1;

        for (int j = 0; j < grau - 1; j++) {
            z.chaves[j] = y.chaves[j + grau];
        }

        if (!y.folha) {
            for (int j = 0; j < grau; j++) {
                z.filhos[j] = y.filhos[j + grau];
            }
        }

        y.numChaves = grau - 1;

        for (int j = numChaves; j >= i + 1; j--) {
            filhos[j + 1] = filhos[j];
        }

        filhos[i + 1] = z;

        for (int j = numChaves - 1; j >= i; j--) {
            chaves[j + 1] = chaves[j];
        }

        chaves[i] = y.chaves[grau - 1];
        numChaves++;
    }

    // Método para imprimir as chaves
    public void imprimir() {
        int i;
        for (i = 0; i < numChaves; i++) {
            if (!folha) {
                filhos[i].imprimir();
            }
            System.out.print(chaves[i] + " ");
        }

        if (!folha) {
            filhos[i].imprimir();
        }
    }
}