class Message {
    messageType; // int
    requestId; // int
    objectReference; // String
    methodId; // String
    methodId; // Srting
    arguments; // Array ou Object

    constructor(msg) {
        const json = JSON.parse(msg);
        this.messageType = json.messageType;
        this.requestId = json.requestId;
        this.objectReference = json.objectReference;
        this.methodId = json.methodId;
        this.methodId = json.methodId;
        this.arguments = json.arguments;
    }
}

module.exports = Message;