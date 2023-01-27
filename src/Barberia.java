// Una altra versió: https://github.com/camilonova/Barbero/tree/master/edu/distrital/log/main

public class Barberia {

    public static void main(String[] args) {
        int numClients = 6;
        Sala sala = new Sala(3);
        Client[] clients = new Client[numClients];
        for (int i = 0; i < numClients; i++) {
            clients[i] = new Client(sala,"Client-" + i);
        }
        for (int i = 0; i < numClients; i++) {
            clients[i].start();
        }
    }

}
