const CalculadoraCiclista = require('./CalculadoraCiclista');

class Esqueleto {
    calculadora = new CalculadoraCiclista();

    IMC(json) {
        const altura = json["altura"];
        const peso = json["peso"];
        return this.calculadora.IMC(altura, peso);
    }
    alturaBike(json) {
        const altura = json["altura"];
        return this.calculadora.alturaBike(altura);
    }
    batimentosCardiacos(json) {
        const batimentosTotal = json["batimentosTotal"];
        return this.calculadora.batimentosCardiacos(batimentosTotal);
    }
}

module.exports = Esqueleto;