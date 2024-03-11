package EditorTexto;

public class NoLista<T>{
    T dado;
    NoLista<T> anterior;
    NoLista<T> proximo;

    public NoLista(T dado){
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }
}