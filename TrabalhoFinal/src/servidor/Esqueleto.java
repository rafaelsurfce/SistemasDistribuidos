package servidor;

public class Esqueleto {

    CalculadoraCiclista calculadora = new CalculadoraCiclista();

    public String IMC(String altura, String peso) {
        return calculadora.IMC(altura, peso);
    }

    public String alturaBike(String altura) {
        return calculadora.alturaBike(altura);
    }

    public String batimentosCardiacos(String batimentosTotal) {
        return calculadora.batimentosCardiacos(batimentosTotal);
    }

}
