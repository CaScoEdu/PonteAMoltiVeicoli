import java.util.ArrayList;

public class Parcheggio {

    private ArrayList<Posto> postiDisponibili = new ArrayList<Posto>();

    public Parcheggio (int numeroPosti){

        for (int numero = 1; numero <= numeroPosti; numero++){
            Posto posto = new Posto(numero);
            postiDisponibili.add(posto);
        }
            
    }

    public synchronized Posto richiediPosto() throws InterruptedException{
        while (postiDisponibili.size() == 0)
            wait();
        Posto postoAssegnato = postiDisponibili.removeFirst();
        return postoAssegnato;
    }

    public synchronized void rilasciaPosto(Posto posto){
        postiDisponibili.add(posto);
        notify();
    }

}
