package ArvoreAvl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testando com inteiros:");
        ArvoreAVL<Integer> arvoreInteiros = new ArvoreAVL<>();
        arvoreInteiros.inserir(10);
        arvoreInteiros.inserir(20);
        arvoreInteiros.inserir(5);
        arvoreInteiros.inserir(15);
        arvoreInteiros.inserir(25);
        arvoreInteiros.inserir(1);

        System.out.print("In-ordem: ");
        arvoreInteiros.inOrdem();
        System.out.print("Pré-ordem: ");
        arvoreInteiros.preOrdem();
        System.out.print("Pós-ordem: ");
        arvoreInteiros.posOrdem();

        System.out.println("Buscar 15: " + arvoreInteiros.buscar(15));
        System.out.println("Buscar 30: " + arvoreInteiros.buscar(30));

        arvoreInteiros.remover(5);
        arvoreInteiros.remover(20);
        System.out.print("In-ordem após remoção: ");
        arvoreInteiros.inOrdem();

        System.out.println("\n--------------------------");

        System.out.println("Testando com strings:");
        ArvoreAVL<String> arvoreStrings = new ArvoreAVL<>();
        arvoreStrings.inserir("maçã");
        arvoreStrings.inserir("banana");
        arvoreStrings.inserir("laranja");
        arvoreStrings.inserir("uva");
        arvoreStrings.inserir("kiwi");

        System.out.print("In-ordem: ");
        arvoreStrings.inOrdem();
        System.out.print("Pré-ordem: ");
        arvoreStrings.preOrdem();
        System.out.print("Pós-ordem: ");
        arvoreStrings.posOrdem();

        System.out.println("Buscar 'laranja': " + arvoreStrings.buscar("laranja"));
        System.out.println("Buscar 'abacaxi': " + arvoreStrings.buscar("abacaxi"));

        arvoreStrings.remover("banana");
        arvoreStrings.remover("uva");
        System.out.print("In-ordem após remoção: ");
        arvoreStrings.inOrdem();

        System.out.println("\n--------------------------");

        System.out.println("Testando com objetos personalizados (Pessoa):");
        ArvoreAVL<Pessoa> arvorePessoas = new ArvoreAVL<>();
        arvorePessoas.inserir(new Pessoa("Alice", 30));
        arvorePessoas.inserir(new Pessoa("Bob", 25));
        arvorePessoas.inserir(new Pessoa("Charlie", 35));
        arvorePessoas.inserir(new Pessoa("David", 20));
        arvorePessoas.inserir(new Pessoa("Eve", 40));

        System.out.print("In-ordem: ");
        arvorePessoas.inOrdem();
        System.out.print("Pré-ordem: ");
        arvorePessoas.preOrdem();
        System.out.print("Pós-ordem: ");
        arvorePessoas.posOrdem();

        System.out.println("Buscar pessoa com idade 35: " + arvorePessoas.buscar(new Pessoa("Charlie", 35)));
        System.out.println("Buscar pessoa com idade 50: " + arvorePessoas.buscar(new Pessoa("Frank", 50)));

        arvorePessoas.remover(new Pessoa("Bob", 25));
        arvorePessoas.remover(new Pessoa("Eve", 40));
        System.out.print("In-ordem após remoção: ");
        arvorePessoas.inOrdem();
    }
}

class Pessoa implements Comparable<Pessoa> {
    String nome;
    int idade;

    Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public int compareTo(Pessoa outraPessoa) {
        return Integer.compare(this.idade, outraPessoa.idade);
    }

    @Override
    public String toString() {
        return nome + " (" + idade + " anos)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pessoa pessoa = (Pessoa) obj;
        return idade == pessoa.idade && nome.equals(pessoa.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode() + idade;
    }
}