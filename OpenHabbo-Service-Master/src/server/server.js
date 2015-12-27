var net = require('net');
var port = 13337;
var heartbeatInterval = 1000;
var clients = [];

var handshake = {
    "name": "hello",
    "message": ""
}

net.createServer(function (socket) {

    socket.instanceData = {
        "name": "",
        "version": "",
        "status": {},
        "logs": []
    };

    clients.push(socket);

    socket.write(JSON.stringify(handshake));

    socket.on('data', function (data) {
        var dataString = data.toString();

        if(dataString.indexOf("}{") > -1) {
            dataString = dataString.split("}{")[0] + "}";
        }

        var obj = JSON.parse(dataString);

        switch(obj.name) {
            case "hello":
                console.log("Server connected with version: " + obj.message.version);
                socket.instanceData.version = obj.message.version;
                socket.instanceData.name = socket.remoteAddress + ":" + obj.message.port;
                break;

            case "status":
                socket.instanceData.status = obj.message;
                break;

            case "appendLog":
                socket.instanceData.logs.push(obj.message);

                var log = "[" + obj.message.thread + "]  " + obj.message.level + " " + obj.message.name + " - " + obj.message.message;

                console.log(log);

                break;
        }
    });

    socket.on('end', function () {
        clients.splice(clients.indexOf(socket), 1);
    });

    socket.on('error', function() {
        clients.splice(clients.indexOf(socket), 1);
    });

}).listen(port);

setInterval(function() {
    broadcast({name: "heartbeat", message: ""});
}, heartbeatInterval);

var broadcast = function(msg) {
    clients.forEach(function(cli) {
        cli.write(JSON.stringify(msg));
    });
}

var getServerList = function() {
    var serverList = [];

    clients.forEach(function(cli) {
        serverList.push(cli.instanceData);
    });

    return serverList;
}

exports.broadcast = broadcast;
exports.getServerList = getServerList;
