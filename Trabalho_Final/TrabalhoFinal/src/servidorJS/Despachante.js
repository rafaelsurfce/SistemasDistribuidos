const Esqueleto = require('./Esqueleto');

class Despachante {
    esqueleto = new Esqueleto();

    invoke(dados) {
        const json = JSON.parse(dados);

        switch (json["objectReference"]) {
            case "IMC":
                return this.esqueleto.IMC(json);
            case "Bike":
                return this.esqueleto.Bike(json);
            case "Health":
                return this.esqueleto.Health(json);
            default:
                return {};
        }
    }
}

module.exports = Despachante;