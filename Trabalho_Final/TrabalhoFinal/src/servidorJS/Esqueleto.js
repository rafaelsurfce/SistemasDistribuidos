const CalculadoraCiclista = require('./Services');

class Esqueleto {
    calculadora = CalculadoraCiclista;

    IMC(argumentos) {
        const imc = new this.calculadora.IMC(...argumentos);
        return imc.calcIMC();
    }
    Bike(argumentos) {
        const bike = new this.calculadora.Bike(...argumentos);
        return bike.alturaBike();
    }
    Health(argumentos) {
        const health = new this.calculadora.Health(...argumentos);
        return health.batimentosCardiacos();
    }
}

module.exports = Esqueleto;