var sendAsJson = require('../util/response.js').sendAsJson;
var monitoring = require('../monitoring/monitoring.js');

var rooms = {};

module.exports = {

    registerRoom: function(req, res) {
        rooms[req.body.roomId] = {
            id: req.body.roomId,
            serviceAlias: req.body.serviceAlias
        };

        sendAsJson({ "success": true}, res);

        monitoring.getSockets().emit("log", {
            event: "log",
            data: {
                level: "debug",
                msg: "Room '" + req.body.roomId + "' has been registered to service: " + req.body.serviceAlias
            }
        });
    },

    unregisterRoom: function(req, res) {
        monitoring.getSockets().emit("log", {
            event: "log",
            data: {
                level: "debug",
                msg: "Room '" + req.body.roomId + "' has been unregistered from service: " + rooms[req.body.roomId].serviceAlias
            }
        });

        delete rooms[req.body.roomId];
        sendAsJson({ "success": true}, res);
    },

    findAlias: function(req, res) {
        sendAsJson({ "serviceAlias": sessions[req.body.roomId].serviceAlias}, res);
    }
};