import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EcossistemaFloresta {
    public static void main(String[] args) {
        List<SerVivo> seresVivos = new ArrayList<>();
        Random random = new Random();

        // Criar uma população de animais e árvores
        criarPopulacao(seresVivos, random, 3, Onca::new);
        criarPopulacao(seresVivos, random, 3, Tamandua::new);
        criarPopulacao(seresVivos, random, 10, Arvore::new);

        // Loop do jogo
        for (int tempo = 1; tempo <= 5; tempo++) {
            System.out.println("Tempo " + tempo + ":");

            // Gerar aleatoriamente um fenômeno natural
            FenomenoNatural fenomeno = gerarFenomeno(random);

            if (fenomeno != null) {
                System.out.println(fenomeno.getNome() + " começou.");
            }

            for (SerVivo ser : seresVivos) {
                ser.realizarAcoes(fenomeno);
            }

            System.out.println("Fim do Tempo " + tempo + "\n");
        }
    }

    private static void criarPopulacao(List<SerVivo> seresVivos, Random random, int quantidade, CriadorSerVivo criador) {
        for (int i = 1; i <= quantidade; i++) {
            seresVivos.add(criador.criar("SerVivo " + criador.getTipo() + " " + i, random.nextInt(criador.getMaxIdade()) + 1));
        }
    }

    private static FenomenoNatural gerarFenomeno(Random random) {
        double chanceFenomeno = random.nextDouble();
        if (chanceFenomeno < 0.9) {
            return new Chuva();
        } else if (chanceFenomeno < 0.6) {
            return new Tempestade();
        }
        return null;
    }
}
