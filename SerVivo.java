public class SerVivo {
    private String nome;
    private int idade;

    public SerVivo(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void crescer() {
        idade++;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
