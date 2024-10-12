import java.util.concurrent.TimeUnit;

public class Automobile implements Runnable {
    private String nome;
    private Semaforo semaforoParcheggio;
    
    public Automobile(String nome, Semaforo semaforoParcheggio) {
        this.nome = nome;
        this.semaforoParcheggio = semaforoParcheggio;
    }

    @Override
    public void run() {

        try {
            System.out.println(nome + " sta arrivando al parcheggio");
            semaforoParcheggio.attendi();

            TimeUnit.SECONDS.sleep(1);

            System.out.println(nome + " sta sostando al parcheggio");

            TimeUnit.SECONDS.sleep(5);

            semaforoParcheggio.segnala();
            System.out.println(nome + " è uscita dal parcheggio");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
