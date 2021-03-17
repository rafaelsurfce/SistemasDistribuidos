const CalculadoraCiclista = require('./CalculadoraCiclista');

class Esqueleto {
    calculadora = CalculadoraCiclista;

    IMC(json) {
        const imc = new this.calculadora.IMC(...json.arguments);
        return imc.calcIMC();
    }
    Bike(json) {
        const bike = new this.calculadora.Bike(...json.arguments);
        return bike.alturaBike();
    }
    Health(json) {
        const health = new this.calculadora.Health(...json.arguments);
        return health.batimentosCardiacos();
    }
}

module.exports = Esqueleto;