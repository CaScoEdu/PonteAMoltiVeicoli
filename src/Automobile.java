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

            final Random RANDOM = new Random();

            TimeUnit.SECONDS.sleep(RANDOM.nextInt(2));

            // richiesta posto
            System.out.println(this.toString() + " sta richiedendo un posto al parcheggio");
            final Posto POSTO = parcheggio.richiedi();

            // utilizzo posto
            System.out.println(this.toString() + " sta sostando nel parcheggio al " + POSTO.toString());
            TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));

            // rilascio posto
            System.out.println(this.toString() + " sta liberando il " + POSTO.toString());
            parcheggio.rilascia(POSTO);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Automobile " + nome;
    }

}
