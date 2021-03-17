package servidor;

import org.json.JSONObject;

public class Esqueleto {
    
	CalculadoraCiclista calculadora= new CalculadoraCiclista();
        
	public String IMC(JSONObject json) {
            double altura = json.getDouble("altura");
            double peso = json.getDouble("peso");
            return calculadora.IMC(altura, peso);
	}
	public String alturaBike(JSONObject json) {
            double altura = json.getDouble("altura");
            return calculadora.alturaBike(altura);
	}
	public String batimentosCardiacos(JSONObject json) {
            double batimentosTotal = json.getDouble("batimentosTotal");
            return calculadora.batimentosCardiacos(batimentosTotal);
	}
}
