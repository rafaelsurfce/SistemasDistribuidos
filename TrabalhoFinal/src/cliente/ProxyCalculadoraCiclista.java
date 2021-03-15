package cliente;

import java.io.IOException;

public class ProxyCalculadoraCiclista {

    UDPCliente cliente = new UDPCliente();
    String ip = "localhost";
    int porta = 1515;

    public String IMC(double altura, double peso) throws IOException {
        String dados = "IMC" + "-" + altura + "-" + peso;
        cliente.sendRequest(dados, porta, ip);
        return cliente.sendResponse();
    }

    public String alturaBike(double altura) throws IOException {
        String dados = "alturaBike" + "-" + altura;
        cliente.sendRequest(dados, porta, ip);
        return cliente.sendResponse();
    }

    public String batimentosCardiacos(int batimentosTotal) throws IOException {
        String dados = "batimentosCardiacos" + "-" + batimentosTotal;
        cliente.sendRequest(dados, porta, ip);
        return cliente.sendResponse();
    }

    public void close() {
        cliente.close();
    }

}
