class Message {
    messageType; // int
    requestId; // int
    methodId; // String
    methodId; // Srting
    argumentos; // Array ou Object

    constructor(msg) {
        const json = JSON.parse(msg);
        this.messageType = json.messageType;
        this.requestId = json.requestId;
        this.methodId = json.methodId;
        this.methodId = json.methodId;
        this.argumentos = json.arguments;
    }
}

module.exports = Message;