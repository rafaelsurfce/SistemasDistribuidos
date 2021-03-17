package cliente;

import java.io.IOException;
import org.json.JSONObject;

public class ProxyCalculadoraCiclista {

    UDPCliente cliente = new UDPCliente();
    private String ip = "localhost";
    private int porta = 1515;
    
    public String doOperation(String objectReference, String methodId, String[] arguments) throws IOException {
        RequestMsg msg = new RequestMsg(objectReference, methodId, arguments);
        cliente.sendRequest(msg.toString(), this.porta, this.ip);
        return cliente.sendResponse();
    }
    
//    public empacotaMensagem desempacotaMensagem

    public String IMC(double altura, double peso) throws IOException {
        String[] args = {(altura + ""), (peso + "")};
        return new JSONObject(this.doOperation("IMC", "calcIMC", args)).getString("calcIMC");
    }
    
    public String alturaBike(double altura) throws IOException {
        String[] args = {(altura + "")};
        return new JSONObject(this.doOperation("Bike", "alturaBike", args)).getString("alturaBike");
    }
    public String batimentosCardiacos(int batimentosTotal) throws IOException {
        String[] args = {(batimentosTotal + "")};
        return new JSONObject(this.doOperation("Health", "batimentosCardiacos", args)).getString("batimentosCardiacos");
    }
    public void close() {
        cliente.close();
    }
}
