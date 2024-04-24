public class Semaforo {

    private int valore; // numero delle risorse condivise disponibili

    public Semaforo (int valore){
        this.valore = valore; // risorse inizialmente disponibili
    }

    public synchronized void attendi() throws InterruptedException{
        while (valore == 0)
            wait();
        valore--;
    }

    public synchronized void segnala(){
        valore++;
        notify();
    }

}
