import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EcossistemaFloresta {
    public static void main(String[] args) {
        List<SerVivo> seresVivos = new ArrayList<>();
        Random random = new Random();
        // Criar uma população de animais e árvores
        for (int i = 1; i <= 3; i++) {
            Onça onça = new Onça("Onça " + i, random.nextInt(10) + 1);
            seresVivos.add(onça);
        }
        for (int i = 1; i <= 3; i++) {
            Tamandua tamandua = new Tamandua("Tamandua " + i, random.nextInt(5) + 1);
            seresVivos.add(tamandua);
        }
        for (int i = 1; i <= 10; i++) {
            Arvore arvore = new Arvore("Árvore " + i, random.nextInt(30) + 1);
            seresVivos.add(arvore);
        }

        // Loop do jogo
        for (int tempo = 1; tempo <= 5; tempo++) {
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

                    if (animal instanceof Tamandua) {
                        Tamandua tamandua = (Tamandua) animal;
                        if (fenomeno instanceof Chuva) {
                            tamandua.reproduzir();
                        }
                    } else if (animal instanceof Onça) {
                        Onça onça = (Onça) animal;
                          onça.caça();
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
