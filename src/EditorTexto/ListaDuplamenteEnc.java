package EditorTexto;
import java.util.Iterator;

public class ListaDuplamenteEnc<T> implements Iterable<T> {

    private NoLista<T> cabeca;
    private NoLista<T> cauda;
    private int tamanho;

    public ListaDuplamenteEnc(){
        this.cabeca = null;
        this.cauda  = null;
        this.tamanho = 0;
    }

    public void inserir(T dado){
        NoLista<T> novoNo = new NoLista<>(dado);
        if(cabeca == null){
            cabeca = cauda = novoNo;
        }else{
            cauda.proximo = novoNo;
            novoNo.anterior = cauda;
            cauda = novoNo;
        }
        tamanho++;
    }

    public int contarElementos(){
        return tamanho;
    }

    public boolean buscarElementos(T elemento) throws Exception{
        if(elemento == null){
            throw new IllegalAccessException("Elemento inválido.");
        }

        NoLista<T> atual = cabeca;
        while (atual != null){
            if(atual.dado.equals(elemento)){
                return true;
            }
            atual = atual.proximo;
        }

        return false;
    }

    public int contarPalavras(){
        int cont = 0;
        boolean dentroPalavra = false;
        NoLista<T> atual = cabeca;
        while (atual!= null){
            if(Character.isLetterOrDigit((char) atual.dado)){
                if (!dentroPalavra) {
                   cont++;
                   dentroPalavra = true;
                }
            }else{
                dentroPalavra = false;
            }
            atual= atual.proximo;
        }
        return cont;
    }

    public void imprimirTexto() {
        for (T dado : this) {
            System.out.print(dado);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListaIterator();
    }
}