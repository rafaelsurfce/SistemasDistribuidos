package servidor;

public class CalculadoraCiclista {
	public String IMC(String altura, String peso) {
		double altura1=Double.parseDouble(altura);
		double peso1=Double.parseDouble(peso);
		
		double imc=peso1/(altura1 * altura1);
		String resposta=null;
		if (imc <= 18.5) {
			
			resposta = "VOCE ESTÁ ABAIXO DO PESO IDEAL";
		}
		else if (imc >= 18.6 && imc <= 24.9) {
			resposta = "PESO IDEAL PARABÉNS!!!";
		}
		else if (imc >= 25 && imc <= 29.9) {
			resposta = "SOBREPESO, COMECE A PEDALAR DE FORMA LEVE";
		}
		else if (imc >= 30 && imc <= 34.9) {
			resposta = "OBESIDADE GRAU 1, PROCURE PEDALAR COM FREQUÊNCIA";
		}
		else if (imc >= 35 && imc <= 39.9) {
			resposta = "OBESIDADE GRAU 2, COMECE A PEDALAR CON FREQUENCIA SEGUIDA DA AJUDA DE UM ESPECIALISTA";
		}
		else if (imc >= 40) {
			resposta = "OBESIDADE MORBIDA, COMECE A PEDALAR CON FREQUENCIA SEGUIDA DA AJUDA DE UM ESPECIALISTA, VOCE CORRE RISCO DE VIDA";	
		}
		
		return resposta;
		
	}
	public String alturaBike(String altura) {
		double altura1=Double.parseDouble(altura);
		String resposta = null;
		if (altura1 >= 1.65 && altura1 <= 1.71) {
			
			resposta = "Quadro ideal para sua altura é a S -15 ou 16-";	
		}
		else if (altura1 >= 1.72 && altura1 <= 1.76) {
			
			resposta = "Quadro ideal para sua altura é a M -17 ou 18-";	
		}
		else if (altura1 >= 1.77 && altura1 <= 1.82) {
			
			resposta = "Quadro ideal para sua altura é a L -19-";	
		}	
		else if (altura1 >= 1.83 && altura1 <= 1.90) {
			
			resposta = "Quadro ideal para sua altura é a XL -21-";	
		}
		else {
			
			resposta = "Altura invalida";
		}
		return resposta;
	}
	
	public String batimentosCardiacos(String batimentosTotal) {
		
		double batimentos=Double.parseDouble(batimentosTotal);
		double resultado=(batimentos * 6);
		String resposta=null;
		if (resultado >= 60) {
			resposta = "Batimentos normal";
		}
		else if (resultado < 60) {
			resposta = "Voc~e está com bradicardia procure um medico";
		}
		else if (resultado > 100) {
			resposta = "Voc~e está com taquicardia procure um medico";
		}
		return resposta;
	}

}
