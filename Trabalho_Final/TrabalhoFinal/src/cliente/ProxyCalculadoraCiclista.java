package cliente;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.net.SocketTimeoutException;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProxyCalculadoraCiclista {

    UDPCliente cliente = new UDPCliente();
    private String ip = "localhost";
    private int porta = 1515;
    private int requestId = 1;
    private int tentativas = 1;
    
    public JSONArray doOperation(String objectReference, String methodId, String[] arguments) /* throws IOException */ {
        JSONArray response = new JSONObject("{arguments:[\"error\"]}").getJSONArray("arguments");
        try {
            RequestMsg msg = new RequestMsg(objectReference, methodId, arguments, this.requestId);
            cliente.sendRequest(msg.toString(), this.porta, this.ip);
            response = new JSONObject(cliente.sendResponse()).getJSONArray("arguments");
        } catch (SocketTimeoutException time) {
            if (this.tentativas <= 5) {
                this.tentativas++;
                response = this.doOperation(objectReference, methodId, arguments);
            } else {
                response = new JSONObject("{arguments:[\"erro timeout\"]}").getJSONArray("arguments");
            }
        } catch (IOException ex) {
            Logger.getLogger(ProxyCalculadoraCiclista.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tentativas = 0;
        this.requestId++;
        return response;
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
