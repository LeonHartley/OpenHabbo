var caminte = require('caminte');
var schema = new caminte.Schema('mysql', {
    host: 'localhost',
    username: 'root',
    password: '',
    database: 'openhabbo'
});

// configure the schemas
var Player = schema.define('Player', require('./models/player.js'));

Player.update({where: {accountId: 1}}, {
    authenticationTicket: null
}, function (err) {
    console.log(err);
});

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