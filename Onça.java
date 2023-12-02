public class Onca extends Animal {
    public Onca(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void mover() {
        System.out.println(getNome() + " está correndo.");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " está caçando.");
    }
}
