package cliente;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProxyCalculadoraCiclista {

    UDPCliente cliente = new UDPCliente();
    private String ip = "localhost";
    private int porta = 1515;
    
    public JSONArray doOperation(String objectReference, String methodId, String[] arguments) throws IOException {
        RequestMsg msg = new RequestMsg(objectReference, methodId, arguments);
        cliente.sendRequest(msg.toString(), this.porta, this.ip);
        return new JSONObject(cliente.sendResponse()).getJSONArray("arguments");
    }

    public String IMC(double altura, double peso) throws IOException {
        String[] args = {(altura + ""), (peso + "")};
        return this.doOperation("IMC", "calcIMC", args).getString(0);
    }
    
    public String alturaBike(double altura) throws IOException {
        String[] args = {(altura + "")};
        return this.doOperation("Bike", "alturaBike", args).getString(0);
    }
    
    public String batimentosCardiacos(int batimentosTotal) throws IOException {
        String[] args = {(batimentosTotal + "")};
        return this.doOperation("Health", "batimentosCardiacos", args).getString(0);
    }
    
    public void close() {
        cliente.close();
    }
}
