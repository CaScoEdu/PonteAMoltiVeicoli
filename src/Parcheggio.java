import java.util.ArrayList;

public class Parcheggio {

    private ArrayList<Integer> postiDisponibili = new ArrayList<Integer>();

    public Parcheggio (int numeroPosti){

        for (Integer posto = 1; posto <= numeroPosti; posto++){
            postiDisponibili.add(posto);
        }
            
    }

    public synchronized Integer richiediPosto() throws InterruptedException{
        while (postiDisponibili.size() == 0)
            wait();
        Integer postoAssegnato = postiDisponibili.removeFirst();
        return postoAssegnato;
    }

    public synchronized void rilasciaPosto(Integer posto){
        postiDisponibili.add(posto);
        notify();
    }

}
