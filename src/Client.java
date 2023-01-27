public class Client extends Thread {
    Sala sala;

    public Client(Sala sala, String nom) {
        super(nom);
        this.sala = sala;

    }

    @Override
    public void run() {
        for(;;) {
            if(sala.entrar()) {
                System.out.printf("%s ha entrat%n",getName());
                sala.tallar();
                System.out.printf("%s s'està tallant%n",getName());
                try {
                    Thread.sleep((long) (Math.random() * 1000) + 500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                sala.sortir();
                System.out.printf("%s ha sortit%n",getName());
                try {
                    Thread.sleep((long) (Math.random() * 3000) + 500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.printf("%s no ha pogut entrar%n",getName());
                try {
                    Thread.sleep((long) (Math.random() * 1000) + 500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }


        }

    }
}
