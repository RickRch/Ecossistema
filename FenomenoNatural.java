public class FenomenoNatural {
    private String nome;

    public FenomenoNatural(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

public class Chuva extends FenomenoNatural {
    public Chuva() {
        super("Chuva");
    }

    public void ocorrer() {
        System.out.println("Está chovendo.");
    }
}

public class Tempestade extends FenomenoNatural {
    public Tempestade() {
        super("Tempestade");
    }

    public void ocorrer() {
        System.out.println("Uma tempestade está acontecendo.");
    }
}
