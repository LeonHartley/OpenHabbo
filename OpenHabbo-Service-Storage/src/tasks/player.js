var Player = require('../storage.js').playerModel,
    sendAsJson = require('../util/util.js').sendAsJson;

module.exports = {
    authenticate: function (req, res) {
        setImmediate(function () {
            Player.findOne({where: {authenticationTicket: req.body.authenticationTicket}}, function (err, player) {
                if (err !== null) {
                    sendAsJson({
                        error: "Error while finding player by authentication ticket",
                        message: err.message
                    }, res);
                    return;
                }

                if(player == null) {
                    sendAsJson({authenticated: false}, res);
                    return;
                }

                // nullify the ticket.
                Player.update({where: {accountId: player.accountId}}, {
                    authenticationTicket: null
                }, function (err) {

                });

                sendAsJson({authenticated: true, data: player}, res);
            });
        });
    }
};