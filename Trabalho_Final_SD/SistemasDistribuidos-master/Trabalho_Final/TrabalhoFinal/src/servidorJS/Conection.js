const UDPServe = require('./UDPServer');
const udp = require('dgram');

class Conection {
    falha = 1;

    main() {
        const socket = udp.createSocket('udp4');
        const porta = 1515;
        const servidor = new UDPServe(socket, porta);

        socket.on('message', (msg, rinfo) => this.falha++ % 3 && servidor.getRequest(msg, rinfo));

        socket.bind(porta);
    }
}

new Conection().main();