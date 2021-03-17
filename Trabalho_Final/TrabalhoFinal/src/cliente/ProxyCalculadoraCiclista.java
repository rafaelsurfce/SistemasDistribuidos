package cliente;

import java.io.IOException;
import org.json.JSONObject;

public class ProxyCalculadoraCiclista {

    UDPCliente cliente = new UDPCliente();
    String ip = "localhost";
    int porta = 1515;

    public String IMC(double altura, double peso) throws IOException {
        String dados = "{\"calculo\": \"IMC\", \"altura\":" + altura + ", \"peso\":" + peso + "}";
        cliente.sendRequest(dados, porta, ip);
        return new JSONObject(cliente.sendResponse()).getString("IMC"); // { "IMC": "resultado" }
    }
    public String alturaBike(double altura) throws IOException {
        String dados = "{\"calculo\": \"alturaBike\", \"altura\":" + altura + "}";
        cliente.sendRequest(dados, porta, ip);
        return new JSONObject(cliente.sendResponse()).getString("alturaBike"); // { "alturaBike": "resultado" }
    }
    public String batimentosCardiacos(int batimentosTotal) throws IOException {
        String dados = "{\"calculo\": \"batimentosCardiacos\", \"batimentosTotal\":" + batimentosTotal + "}";
        cliente.sendRequest(dados, porta, ip);
        return new JSONObject(cliente.sendResponse()).getString("batimentosCardiacos"); // { "batimentosCardiacos": "resultado" }
    }
    public void close() {
        cliente.close();
    }
}
