const Despachante = require('./Despachante');

class UDPServe {
    despachante = new Despachante();
    resposta;

    constructor(socket, porta) {
        this.socket = socket;
        this.porta = porta;
    }

    sendRequest(msg, rinfo) {
        this.resposta = this.despachante.invoke(msg.toString());
        this.sendResponse(rinfo);
    }

    sendResponse(rinfo) {
        this.socket.send(JSON.stringify(this.resposta), rinfo.port, rinfo.address, (error) => error && console.error(error));
    }
}

module.exports = UDPServe;