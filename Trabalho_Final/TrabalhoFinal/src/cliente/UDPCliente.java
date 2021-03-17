package cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPCliente {

    private DatagramSocket socket;

    public void sendRequest(String request, int porta, String ip) throws IOException {
        socket = new DatagramSocket();
        byte[] dados = request.getBytes();
        InetAddress host = InetAddress.getByName(ip);
        int servePorta = porta;
        DatagramPacket mensagem = new DatagramPacket(dados, dados.length, host, servePorta);
        socket.send(mensagem);
        System.out.println("mensagem enviada");
    }
    public String sendResponse() throws IOException {
        byte[] buffer = new byte[1000];
        DatagramPacket resposta = new DatagramPacket(buffer, buffer.length);
        socket.receive(resposta);
        System.out.println("mensagem recebida");
        String result = new String(resposta.getData());
        return result;
    }
    public void close() {
        socket.close();
    }
}
