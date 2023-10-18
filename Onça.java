class Onça extends Animal {
    public Onça(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void mover() {
        System.out.println(getNome() + " está correndo.");
    }

    public void caça() {
        System.out.println(getNome() + " está caçando.");
    }
}