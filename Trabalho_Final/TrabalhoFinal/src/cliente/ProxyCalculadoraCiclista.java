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
    private int requestId = 0;
    
    public JSONArray doOperation(String objectReference, String methodId, String[] arguments) /* throws IOException */ {
        try {
            this.requestId++;
            RequestMsg msg = new RequestMsg(objectReference, methodId, arguments, this.requestId);
            cliente.sendRequest(msg.toString(), this.porta, this.ip);
            return new JSONObject(cliente.sendResponse()).getJSONArray("arguments");
        } catch (SocketTimeoutException time) {
            if (this.requestId <= 5) 
                return this.doOperation(objectReference, methodId, arguments);
            return new JSONObject("{arguments:[\"erro timeout\"]}").getJSONArray("arguments");
        } catch (IOException ex) {
            Logger.getLogger(ProxyCalculadoraCiclista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new JSONObject("{arguments:[\"error\"]}").getJSONArray("arguments");
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
