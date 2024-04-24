public class PonteAMoltiVeicoli {
    
    public static void main(String[] args) throws Exception {

        final int MAX_VEICOLI_SUL_PONTE = 3;
        final int NUMERO_VEICOLI = 10;
        
        Semaforo semaforoPonte = new Semaforo(MAX_VEICOLI_SUL_PONTE);
        for (int i=0; i < NUMERO_VEICOLI; i++)
            new Thread(new Automobile("veicolo"+i,semaforoPonte)).start();
    }
}
