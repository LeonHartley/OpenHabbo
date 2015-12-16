var io = require('socket.io');

module.exports = {
    initialize: function (server) {
        io = io.listen(server);

        io.sockets.on('connection', function (socket) {
            socket.emit("log", {
                event: "log",
                data: {
                    level: "info",
                    msg: "Connection successful"
                }
            });
        });
    },

    getSockets: function() {
        return io.sockets;
    }
};