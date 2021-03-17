const Despachante = require('./Despachante');
const Message = require('./Message');

class UDPServe {
    despachante = new Despachante();

    constructor(socket, porta) {
        this.socket = socket;
        this.porta = porta;
    }

    sendRequest(msg, rinfo) {
        const message = new Message(msg.toString());
        message.argumentos = this.despachante.invoke(message);
        message.messageType = 1;
        this.sendReply(JSON.stringify(message), rinfo.address, rinfo.port);
    }

    sendReply(reply, clientHost, clientPort) {
        this.socket.send(reply, clientPort, clientHost, (error) => error && console.error(error));
    }
}

module.exports = UDPServe;