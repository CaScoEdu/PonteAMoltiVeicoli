import java.util.ArrayList;

public class Parcheggio {

    final private ArrayList<Posto> POSTI_DISPONIBILI = new ArrayList<Posto>();

    public Parcheggio (int numeroPosti){

        for (int numero = 1; numero <= numeroPosti; numero++){
            final Posto POSTO = new Posto(numero);
            POSTI_DISPONIBILI.add(POSTO);
        }
            
    }

    public synchronized Posto richiediPosto() throws InterruptedException{
        while (POSTI_DISPONIBILI.size() == 0)
            wait();
        
        return POSTI_DISPONIBILI.removeFirst();
    }

    public synchronized void rilasciaPosto(Posto posto){
        POSTI_DISPONIBILI.add(posto);
        notify();
    }

}
