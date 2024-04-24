import java.util.concurrent.TimeUnit;

public class Automobile implements Runnable {
    private String nome;
    private Semaforo semaforoPonte;

    public Automobile(String nome, Semaforo semaforoPonte) {
        this.nome = nome;
        this.semaforoPonte = semaforoPonte;
    }

    @Override
    public void run() {

        try {
            System.out.println(nome + " sta arrivando al ponte");
            semaforoPonte.attendi();

            TimeUnit.SECONDS.sleep(1);

            System.out.println(nome + " sta passando il ponte");

            TimeUnit.SECONDS.sleep(2);

            semaforoPonte.segnala();
            System.out.println(nome + " ha attraversato il ponte");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
