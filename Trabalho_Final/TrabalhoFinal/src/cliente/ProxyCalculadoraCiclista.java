package cliente;

import java.io.IOException;
import org.json.JSONObject;

public class ProxyCalculadoraCiclista {

    UDPCliente cliente = new UDPCliente();

    public String IMC(double altura, double peso) throws IOException {
        String[] args = {(altura + ""), (peso + "")};
        return new JSONObject(cliente.doOperation("IMC", "calcIMC", args)).getString("calcIMC");
    }
    
    public String alturaBike(double altura) throws IOException {
        String[] args = {(altura + "")};
        return new JSONObject(cliente.doOperation("Bike", "alturaBike", args)).getString("alturaBike");
    }
    public String batimentosCardiacos(int batimentosTotal) throws IOException {
        String[] args = {(batimentosTotal + "")};
        return new JSONObject(cliente.doOperation("Health", "batimentosCardiacos", args)).getString("batimentosCardiacos");
    }
    public void close() {
        cliente.close();
    }
}
