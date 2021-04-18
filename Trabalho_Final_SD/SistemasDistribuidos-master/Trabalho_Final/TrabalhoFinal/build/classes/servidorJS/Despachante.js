const Esqueleto = require('./Esqueleto');

class Despachante {
    esqueleto = new Esqueleto();

    invoke(dados) {
        const json = JSON.parse(dados);

        switch (json["calculo"]) {
            case "IMC":
                return this.esqueleto.IMC(json);
            case "alturaBike":
                return this.esqueleto.alturaBike(json);
            case "batimentosCardiacos":
                return this.esqueleto.batimentosCardiacos(json);
            default:
                return {};
        }
    }
}

module.exports = Despachante;