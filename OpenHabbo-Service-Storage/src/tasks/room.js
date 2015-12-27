var Room = require('../storage.js').roomModel,
    sendAsJson = require('../util/util.js').sendAsJson;

module.exports = {
    find: function (req, res) {
        setImmediate(function () {
            Room.findOne({where: {id: req.body.roomId}}, function (err, room) {
                if (err !== null) {
                    sendAsJson({
                        error: "Error while finding room",
                        message: err.message
                    }, res);
                    return;
                }

                sendAsJson({data: room}, res);
            });
        });
    },

    findOwn: function (req, res) {
        setImmediate(function () {
            Room.find({where: {playerId: req.body.playerId}}, function (err, room) {
                if (err !== null) {
                    sendAsJson({
                        error: "Error while finding rooms",
                        message: err.message
                    }, res);
                    return;
                }

                sendAsJson({data: room}, res);
            });
        });
    }
};