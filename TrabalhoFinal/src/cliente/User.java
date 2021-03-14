package cliente;

import java.io.IOException;
import java.util.Scanner;

public class User {

	public static void main(String[] args) throws IOException {
		Scanner teclado = new Scanner (System.in);
		ProxyCalculadoraCiclista calculadoraCiclista = new ProxyCalculadoraCiclista();
		while (true) {
			System.out.println("-------------------CALCULADORA DO CICLISTA-------------------");
			System.out.println("Escolha uma das 3 opções: \n 1 - Calculo de IMC;\n 2 - Quadro ideal da bike \n 3 - Batimentos cardiacos; \n exit - para sair \n");
			System.out.print("Escolha uma opção: ");
			String option=teclado.nextLine();
			
			if (option.equals("1")) {
				double dados[]=new double[2];
				System.out.println("-------------------CALCULO DE IMC-------------------");
				System.out.print("informe sua altura: ");
				dados[0]=Double.parseDouble(teclado.nextLine());
				System.out.print("informe seu peso: ");
				dados[1]=Double.parseDouble(teclado.nextLine());
				System.out.println(calculadoraCiclista.IMC(dados[0], dados[1]));
			}
			
			else if (option.equals("2")) {
				double dados[]=new double[1];
				System.out.println("-------------------QUADRO IDEAL DA BIKE-------------------");
				System.out.print("informe sua altura: ");
				dados[0]=Double.parseDouble(teclado.nextLine());
				System.out.println(calculadoraCiclista.alturaBike(dados[0]));
			}
			
			else if (option.equals("3")) {
				int dados[]=new int[1];
				System.out.println("-------------------BATIMENTOS CARDIACOS-------------------");
				System.out.println("DICA: CONTE O NUMERO DE PULSAÇÕES POR 10 SEGUNDOS");
				System.out.print("Informe o numero de pulsações: ");
				dados[0]=Integer.parseInt(teclado.nextLine());
				System.out.println(calculadoraCiclista.batimentosCardiacos(dados[0]));
				
			}
			
			else if (option.equals("exit")) {
				System.out.println("-------------------SERVIÇO ENCERRADO-------------------");
				calculadoraCiclista.close();
				break;
			}
			
			else {
				
				System.out.println("SERVIÇO DESCONHECIDO TENTE UM VALIDO");
			}
			
			
		}

	}

}
