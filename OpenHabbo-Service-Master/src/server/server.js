var net = require('net');
var port = 3001;
var heartbeatInterval = 1000;
var clients = [];
var monitoring = require('../monitoring/monitoring.js');

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

console.log("Master service listening at tcp://::::" + port);