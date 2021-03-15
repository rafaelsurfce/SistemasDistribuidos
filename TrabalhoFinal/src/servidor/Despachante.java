package servidor;

public class Despachante {

    Esqueleto esqueleto = new Esqueleto();

    public String invoke(String dados) {

        String[] dados1 = dados.split("-");

        String resultado = null;

        if (dados1[0].equals("IMC")) {
            resultado = esqueleto.IMC(dados1[1], dados1[2]);
        } else if (dados1[0].equals("alturaBike")) {
            resultado = esqueleto.alturaBike(dados1[1]);
        } else if (dados1[0].equals("batimentosCardiacos")) {
            resultado = esqueleto.batimentosCardiacos(dados1[1]);
        }
        return resultado;

    }

}
