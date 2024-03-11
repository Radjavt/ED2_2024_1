package EditorTexto;

import java.util.Iterator;

public class ListaIterator<T> implements Iterator {
    private NoLista<T> cabeca;
    private NoLista<T> atual = cabeca;

    @Override
    public boolean hasNext() {
        return atual != null;
    }

    @Override
    public T next() {
        T dado = atual.dado;
        atual = atual.proximo;
        return dado;
    }
}