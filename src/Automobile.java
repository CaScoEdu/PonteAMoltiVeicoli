import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Automobile implements Runnable {
    private String nome;
    private Parcheggio parcheggio;
    
    public Automobile(String nome, Parcheggio parcheggio) {
        this.nome = nome;
        this.parcheggio = parcheggio;
    }

    @Override
    public void run() {

        try {

            Random random = new Random();

            TimeUnit.SECONDS.sleep(random.nextInt(3));

            System.out.println(nome + " sta arrivando al parcheggio");

            final Integer POSTO = parcheggio.richiediPosto();

            TimeUnit.SECONDS.sleep(random.nextInt(3));

            System.out.println(nome + " sta sostando nel parcheggio al posto n." + POSTO);

            TimeUnit.SECONDS.sleep(random.nextInt(5));

            parcheggio.rilasciaPosto(POSTO);
            System.out.println(nome + " ha liberato il posto n." + POSTO + " ed è uscita dal parcheggio");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
