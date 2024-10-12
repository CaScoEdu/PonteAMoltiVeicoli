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

            System.out.println(this.toString() + " sta arrivando al parcheggio");

            final Posto POSTO = parcheggio.richiediPosto();

            TimeUnit.SECONDS.sleep(random.nextInt(3));

            System.out.println(this.toString() + " sta sostando nel parcheggio al " + POSTO.toString());

            TimeUnit.SECONDS.sleep(random.nextInt(5));

            parcheggio.rilasciaPosto(POSTO);
            System.out.println(this.toString() + " ha liberato il " + POSTO.toString() + " ed è uscita dal parcheggio");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Automobile " + nome;
    }

    

}
