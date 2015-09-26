var sendAsJson = require('../util/response.js').sendAsJson;

var sessions = {};
var redisClient;

module.exports = {
    initialize: function(client) {
        redisClient = client;
    },

    registerSession: function(req, res) {
        redisClient.hset("sessions", req.body.sessionId, req.body.serviceAlias, function(err, res) {});
        sendAsJson({ "success": true}, res)
    },

    unregisterSession: function(req, res) {
        redisClient.hdel("sessions", req.body.sessionId, function (err, res) {});
        sendAsJson({ "success": true}, res);
    },

    findAlias: function(req, res) {
        redisClient.hget("sessions", req.body.sessionId, function(err, obj) {
           sendAsJson({ "serviceAlias": obj }, res);
        });
    }
};