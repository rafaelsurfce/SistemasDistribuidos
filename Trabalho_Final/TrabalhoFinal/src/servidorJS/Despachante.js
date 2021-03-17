const Esqueleto = require('./Esqueleto');

class Despachante {
    esqueleto = new Esqueleto();

    invoke(message) {

        switch (message.objectReference) {
            case "IMC":
                return this.esqueleto.IMC(message.argumentos);
            case "Bike":
                return this.esqueleto.Bike(message.argumentos);
            case "Health":
                return this.esqueleto.Health(message.argumentos);
            default:
                return { erro: ":("};
        }
    }
}

module.exports = Despachante;