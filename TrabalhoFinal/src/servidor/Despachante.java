package servidor;

import org.json.JSONObject;

public class Despachante {

    Esqueleto esqueleto = new Esqueleto();

    public String invoke(String dados) {
        JSONObject json = new JSONObject(dados);

        switch (json.getString("calculo")) {
            case "IMC":
                return esqueleto.IMC(json);
            case "alturaBike":
                return esqueleto.alturaBike(json);
            case "batimentosCardiacos":
                return esqueleto.batimentosCardiacos(json);
            default:
                return "";
        }
    }
}
