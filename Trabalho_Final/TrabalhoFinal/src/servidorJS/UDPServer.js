const Despachante = require('./Despachante');
const Message = require('./Message');

class UDPServe {
    despachante = new Despachante();
    historicoMsg = {};

    constructor(socket, porta) {
        this.socket = socket;
        this.porta = porta;
    }

    getRequest(msg, rinfo) {
        const message = new Message(msg.toString());
        if (!this.isDuplicated(message, rinfo)) return;
        message.arguments = this.despachante.invoke(message);
        message.messageType = 1;
        console.log(message, rinfo);
        this.sendReply(JSON.stringify(message), rinfo.address, rinfo.port);
    }

    sendReply(reply, clientHost, clientPort) {
        this.socket.send(reply, clientPort, clientHost, (error) => error && console.error(error));
    }

    isDuplicated(msg, rinfo) {
        const cliente = this.historicoMsg[rinfo.address];
        if (cliente) {
            console.log(cliente.lastId, msg.requestId);
            if (cliente.lastId == msg.requestId) return false;
            else {
                cliente.lastId = msg.requestId;
                cliente.msgVet.push(msg);
                return true;
            }
        } else {
            console.log(msg.requestId);
            this.historicoMsg[rinfo.address] = {
                lastId: msg.requestId,
                msgVet: [msg]
            };
            return true;
        }
    }
}

module.exports = UDPServe;