package servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServe {

    Despachante despachante = new Despachante();
    DatagramSocket socket;
    DatagramPacket request;
    String dados1;
    String resposta;
    byte[] dados;

    public UDPServe(DatagramSocket socket) throws SocketException {
        this.socket = new DatagramSocket(1515);
        this.dados = new byte[1000];
    }

    public void sendRequest() throws IOException {
        this.request = new DatagramPacket(this.dados, this.dados.length);
        socket.receive(request);
        this.dados1 = new String(request.getData());
        this.resposta = despachante.invoke(this.dados1);

    }

    public void sendResponse() throws IOException {
        request.setData(this.resposta.getBytes());
        DatagramPacket resposta = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort());
        socket.send(resposta);
    }

}
