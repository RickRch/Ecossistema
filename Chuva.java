public class Arvore extends SerVivo {
    public Arvore(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void crescer() {
        System.out.println(getNome() + " está crescendo.");
        super.crescer();
    }

    @Override
    public void realizarAcoes(FenomenoNatural fenomeno) {
        crescer();
        if (fenomeno instanceof Chuva) {
            reproduzir();
        }
    }

    public void reproduzir() {
        System.out.println(getNome() + " está soltando sementes.");
    }
}
