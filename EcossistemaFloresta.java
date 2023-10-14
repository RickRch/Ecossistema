import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class SerVivo {
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

class Animal extends SerVivo {
    public Animal(String nome, int idade) {
        super(nome, idade);
    }

    public void mover() {
        System.out.println(getNome() + " está se movendo.");
    }

    public void comer() {
        System.out.println(getNome() + " está comendo.");
    }
}

class Leão extends Animal {
    public Leão(String nome, int idade) {
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

class Zebra extends Animal {
    public Zebra(String nome, int idade) {
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

class FenomenoNatural {
    private String nome;

    public FenomenoNatural(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Chuva extends FenomenoNatural {
    public Chuva() {
        super("Chuva");
    }

    public void ocorrer() {
        System.out.println("Está chovendo.");
    }
}

class Tempestade extends FenomenoNatural {
    public Tempestade() {
        super("Tempestade");
    }

    public void ocorrer() {
        System.out.println("Uma tempestade está acontecendo.");
    }
}

public class EcossistemaFloresta {
    public static void main(String[] args) {
        List<SerVivo> seresVivos = new ArrayList<>();
        Random random = new Random();
        // Criar uma população de animais e árvores
        for (int i = 1; i <= 3; i++) {
            Leão leao = new Leão("Leão " + i, random.nextInt(10) + 1);
            seresVivos.add(leao);
        }
        for (int i = 1; i <= 3; i++) {
            Zebra zebra = new Zebra("Zebra " + i, random.nextInt(5) + 1);
            seresVivos.add(zebra);
        }
        for (int i = 1; i <= 10; i++) {
            Arvore arvore = new Arvore("Árvore " + i, random.nextInt(30) + 1);
            seresVivos.add(arvore);
        }

        // Loop do jogo
        for (int tempo = 1; tempo <= 10; tempo++) {
            System.out.println("Tempo " + tempo + ":");

            // Gerar aleatoriamente um fenômeno natural
            FenomenoNatural fenomeno = null;
            double chanceFenomeno = random.nextDouble();
            if (chanceFenomeno < 0.2) {
                fenomeno = new Chuva();
            } else if (chanceFenomeno < 0.4) {
                fenomeno = new Tempestade();
            }

            if (fenomeno != null) {
                System.out.println(fenomeno.getNome() + " começou.");
            }

            for (SerVivo ser : seresVivos) {
                if (ser instanceof Animal) {
                    Animal animal = (Animal) ser;
                    animal.mover();
                    animal.comer();
                    animal.crescer();

                    if (animal instanceof Zebra) {
                        Zebra zebra = (Zebra) animal;
                        if (fenomeno instanceof Chuva) {
                            zebra.reproduzir();
                        }
                    } else if (animal instanceof Leão) {
                        Leão leao = (Leão) animal;
                        leao.caça();
                    }
                } else if (ser instanceof Arvore) {
                    Arvore arvore = (Arvore) ser;
                    arvore.crescer();
                    if (fenomeno instanceof Chuva) {
                        arvore.reproduzir();
                    }
                }
            }

            System.out.println("Fim do Tempo " + tempo + "\n");
        }
    }
}