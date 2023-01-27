public class Sala {
    private int num_cadires;
    private int num_clients;
    boolean barberOcupat;

    public Sala(int n) {
        num_cadires = n;
        barberOcupat = false;
    }


    public synchronized boolean entrar() {
        if (num_cadires > num_clients) {
            System.out.printf("Hi ha %d%n",++num_clients);
            return true;
        } else return false;
    }

    public synchronized void tallar() {
        while(barberOcupat) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //barber lliure
        barberOcupat = true;
        notifyAll();
    }

    public synchronized void sortir() {
        barberOcupat = false;
        num_clients--;
        System.out.printf("Hi ha %d%n",num_clients);

        notifyAll();
    }
}