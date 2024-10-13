public class Main {
    
    public static void main(String[] args) throws Exception {
             
        final int NUMERO_POSTI_DEL_PARCHEGGIO = 4;

        final ParcheggioMonitor PARCHEGGIO = new ParcheggioMonitor(NUMERO_POSTI_DEL_PARCHEGGIO);
        
        final int NUMERO_VEICOLI = 10;
        for (int i=1; i <= NUMERO_VEICOLI; i++)
            new Thread(new Automobile("auto"+i, PARCHEGGIO)).start();
    }
}
