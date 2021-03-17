const Esqueleto = require('./Esqueleto');

class Despachante {
    esqueleto = new Esqueleto();

    invoke(message) {

        switch (message.objectReference) {
            case "IMC":
                return this.esqueleto.IMC(message.arguments);
            case "Bike":
                return this.esqueleto.Bike(message.arguments);
            case "Health":
                return this.esqueleto.Health(message.arguments);
            default:
                return [ ":(" ];
        }
    }
}

module.exports = Despachante;