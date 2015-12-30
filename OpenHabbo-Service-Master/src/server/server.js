var net = require('net');
var port = 3001;
var clients = [];
var monitoring = require('../monitoring/monitoring.js');

var sessions = {};

net.createServer(function (socket) {
    socket.write(JSON.stringify({
        id: "hello",
        data: null
    }));

    clients.push(socket);

    socket.on('data', function (data) {
        var obj = JSON.parse(data.toString());

        switch (obj.id) {
            case "serviceInformation":
                socket.serviceInfo = obj;

                monitoring.sendDebugLog("Service " + obj.serviceAlias + " has connected to master");
                break;

            case "sessionRegister":
                sessions[obj.uuid] = {
                    id: obj.uuid,
                    serviceAlias: obj.serviceAlias,
                    playerId: obj.playerId
                };

                monitoring.sendDebugLog("Session " + obj.uuid + " (player #" + obj.playerId + ") has been registered to " + obj.serviceAlias);

                broadcast({
                    id: "sessionRegistered",
                    uuid: obj.uuid,
                    playerId: obj.playerId,
                    serviceAlias: obj.serviceAlias
                });
                break;

            case "sessionUnregister":
                monitoring.sendDebugLog("Session " + obj.uuid + " (player #" + sessions[obj.uuid].playerId + ") has been unregistered from " + obj.serviceAlias);
                delete sessions[obj.uuid];

                broadcast({
                    id: "sessionUnregistered",
                    uuid: obj.uuid
                });
                break;
        }
    });

    socket.on('end', function () {
        monitoring.sendDebugLog("Service " + (socket.serviceInfo === undefined ? "unknown" : socket.serviceInfo.serviceAlias) + " has disconnected from master");
        clients.splice(clients.indexOf(socket), 1);
    });

    socket.on('error', function () {
        monitoring.sendDebugLog("Service " + (socket.serviceInfo === undefined ? "unknown" : socket.serviceInfo.serviceAlias) + " has disconnected from master");

        clients.splice(clients.indexOf(socket), 1);
    });
}).listen(port);

function broadcast(message) {
    for(var i = 0; i < clients.length; i++) {
        var client = clients[i];

        client.write(JSON.stringify(message));
    }
}

console.log("Master service listening at tcp://::::" + port);