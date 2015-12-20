var caminte = require('caminte');
var schema = new caminte.Schema('mysql', {
    host: 'localhost',
    username: 'root',
    password: '',
    database: 'openhabbo'
});

// configure the schemas
var Player = schema.define('Player', require('./models/player.js'));

module.exports = {
    playerModel: Player
}