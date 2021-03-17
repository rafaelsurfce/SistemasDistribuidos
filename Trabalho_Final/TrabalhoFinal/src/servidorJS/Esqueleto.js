const Services = require('./Services');

class Esqueleto {
    services = Services;

    IMC(argumentos) {
        const imc = new this.services.IMC(...argumentos);
        return imc.calcIMC();
    }
    Bike(argumentos) {
        const bike = new this.services.Bike(...argumentos);
        return bike.alturaBike();
    }
    Health(argumentos) {
        const health = new this.services.Health(...argumentos);
        return health.batimentosCardiacos();
    }
}

module.exports = Esqueleto;