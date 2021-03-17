class CalculadoraCiclista {
    IMC(altura, peso) {
        const imc = peso / (altura * altura);
        let resposta = null;

        if (imc <= 18.5) {
            resposta = "VOCE ESTÁ ABAIXO DO PESO IDEAL";
        } else if (imc >= 18.6 && imc <= 24.9) {
            resposta = "PESO IDEAL PARABÉNS!!!";
        } else if (imc >= 25 && imc <= 29.9) {
            resposta = "SOBREPESO, COMECE A PEDALAR DE FORMA LEVE";
        } else if (imc >= 30 && imc <= 34.9) {
            resposta = "OBESIDADE GRAU 1, PROCURE PEDALAR COM FREQUÊNCIA";
        } else if (imc >= 35 && imc <= 39.9) {
            resposta = "OBESIDADE GRAU 2, COMECE A PEDALAR CON FREQUENCIA SEGUIDA DA AJUDA DE UM ESPECIALISTA";
        } else if (imc >= 40) {
            resposta = "OBESIDADE MORBIDA, COMECE A PEDALAR CON FREQUENCIA SEGUIDA DA AJUDA DE UM ESPECIALISTA, VOCE CORRE RISCO DE VIDA";
        }
        return { IMC: resposta };
    }

    alturaBike(altura) {
        let resposta;
        
        if (altura >= 1.65 && altura <= 1.71) {
            resposta = "Quadro ideal para sua altura é a S -15 ou 16-";
        } else if (altura >= 1.72 && altura <= 1.76) {
            resposta = "Quadro ideal para sua altura é a M -17 ou 18-";
        } else if (altura >= 1.77 && altura <= 1.82) {
            resposta = "Quadro ideal para sua altura é a L -19-";
        } else if (altura >= 1.83 && altura <= 1.90) {
            resposta = "Quadro ideal para sua altura é a XL -21-";
        } else {
            resposta = "Altura invalida";
        }
        return { alturaBike: resposta };
    }

    batimentosCardiacos(batimentosTotal) {
        const resultado = (batimentosTotal * 6);
        let resposta;
        
        if (resultado < 60) {
            resposta = "Você está com bradicardia procure um médico";
        } else if (resultado > 100) {
            resposta = "Você está com taquicardia procure um médico";
        } else {
            resposta = "Batimentos normal";
        }
        return { batimentosCardiacos: resposta };
    }
}

module.exports = CalculadoraCiclista;