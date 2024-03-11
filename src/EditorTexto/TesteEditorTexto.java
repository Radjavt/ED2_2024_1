package EditorTexto;

public class TesteEditorTexto {
    public static void main(String[] args) {
        ListaDuplamenteEnc<Character> texto = new ListaDuplamenteEnc<>();

        String textoEntrada = "Eu amo estrutura de dados 2. Vou resolver em 10 minutos, sozinho, o problema.";
        for (char c : textoEntrada.toCharArray()){
            texto.inserir(c);
        }

        System.out.println("Texto original: "+textoEntrada);
        texto.imprimirTexto();

        System.out.println("Total de caracteres: "+ texto.contarElementos());

        System.out.println("Total de palavras: " +texto.contarPalavras());

        char elementoBusca = 'w';
        try{
            System.out.println("O elemento ' "+elementoBusca+" ' está presente? "+texto.buscarElementos(elementoBusca));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}