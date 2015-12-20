var storage = require('./storage.js'),
    web = require('./web.js'),
    domain = require('domain').create();

domain.on('error', function(err) {
    console.log('Uncaught error', err.message);
});

//Player.update({where: {accountId: 1}}, {
//    authenticationTicket: null
//}, function (err) {
//    console.log(err);
//});

//Player.findOne({where: { accountId: 1 }}, function(err, player) {
//    if(err) {
//        console.log(err);
//        return;
//    }
//
//});

//Player.create({
//    username: "Leon",
//    accountId: 1
//}, function (err) {
//    console.log(err);
//});

//Player.find({ where: { username: 'Leon' } }, function(err, players) {
//    console.log(err);
//    setImmediate(function() {
//        console.log(players);
//    });
//});