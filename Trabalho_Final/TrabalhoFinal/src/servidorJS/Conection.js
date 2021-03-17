const UDPServe = require('./UDPServer');
const udp = require('dgram');

class Conection {
    main() {
        const socket = udp.createSocket('udp4');
        const porta = 1515;
        const servidor = new UDPServe(socket, porta);

        socket.on('message', (msg, rinfo) => servidor.sendRequest(msg, rinfo));

        socket.bind(porta);
    }
}

new Conection().main();