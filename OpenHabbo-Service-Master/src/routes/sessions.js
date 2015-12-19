var sendAsJson = require('../util/response.js').sendAsJson;
var monitoring = require('../monitoring/monitoring.js');
var sessions = {};

module.exports = {
    initialize: function() {

    },

    registerSession: function(req, res) {
        sessions[req.body.sessionId] = {
            id: req.body.sessionId,
            serviceAlias: req.body.serviceAlias
        };

        sendAsJson({ "success": true}, res);

        monitoring.getSockets().emit("log", {
            event: "log",
            data: {
                level: "debug",
                msg: "Session '" + req.body.sessionId + "' has been registered to service: " + req.body.serviceAlias
            }
        });
    },

    unregisterSession: function(req, res) {
        monitoring.getSockets().emit("log", {
            event: "log",
            data: {
                level: "debug",
                msg: "Session '" + req.body.sessionId + "' has been unregistered from service: " + sessions[req.body.sessionId].serviceAlias
            }
        });

        delete sessions[req.body.sessionId];
        sendAsJson({ "success": true}, res);
    },

    findAlias: function(req, res) {
        sendAsJson({ "serviceAlias": sessions[req.body.sessionId].serviceAlias}, res);
    }
};