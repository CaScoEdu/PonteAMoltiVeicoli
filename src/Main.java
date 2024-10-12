public class Main {
    
    public static void main(String[] args) throws Exception {
             
        final int NUMERO_POSTI_DEL_PARCHEGGIO = 4;

        Semaforo semaforoParcheggio = new Semaforo(NUMERO_POSTI_DEL_PARCHEGGIO);
        
        final int NUMERO_VEICOLI = 10;
        for (int i=0; i < NUMERO_VEICOLI; i++)
            new Thread(new Automobile("auto"+i, semaforoParcheggio)).start();
    }
}
