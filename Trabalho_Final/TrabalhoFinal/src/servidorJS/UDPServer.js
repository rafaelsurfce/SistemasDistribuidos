const Despachante = require('./Despachante');

class UDPServe {
    despachante = new Despachante();

    constructor(socket, porta) {
        this.socket = socket;
        this.porta = porta;
    }

    sendRequest(msg, rinfo) {
        const resposta = this.despachante.invoke(msg.toString());
        this.sendReply(resposta, rinfo.address, rinfo.port);
    }
    
    sendReply(reply, clientHost, clientPort) {
        this.socket.send(JSON.stringify(reply), clientPort, clientHost, (error) => error && console.error(error));
    }
}

module.exports = UDPServe;