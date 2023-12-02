public class Tamandua extends Animal {
    public Tamandua(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void mover() {
        System.out.println(getNome() + " está pulando.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " está se alimentando.");
    }

    @Override
    public void realizarAcoes(FenomenoNatural fenomeno) {
        super.realizarAcoes(fenomeno);
        if (fenomeno instanceof Chuva) {
            reproduzir();
        }
    }

    public void reproduzir() {
        System.out.println(getNome() + " está se reproduzindo.");
    }
}
