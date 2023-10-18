class Arvore extends SerVivo {
    public Arvore(String nome, int idade) {
        super(nome, idade);
    }

    public void crescer() {
        System.out.println(getNome() + " está crescendo.");
        super.crescer();
    }

    public void reproduzir() {
        System.out.println(getNome() + " está soltando sementes.");
    }
}