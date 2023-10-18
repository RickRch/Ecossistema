class Tamandua extends Animal {
    public Tamandua(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void mover() {
        System.out.println(getNome() + " está pulando.");
    }

    public void reproduzir() {
        System.out.println(getNome() + " está se reproduzindo.");
    }
}