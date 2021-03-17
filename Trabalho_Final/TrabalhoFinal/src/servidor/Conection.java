package servidor;

import java.io.IOException;
import java.net.DatagramSocket;

public class Conection {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = null;
        UDPServe servidor = new UDPServe(socket);

        while (true) {
            servidor.sendRequest();
            servidor.sendResponse();
        }
    }
}
