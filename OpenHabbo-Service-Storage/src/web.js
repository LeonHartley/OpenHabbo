var express = require('express'),
    bodyParser = require('body-parser'),
    app = express(),
    http = require('http');

app.use(bodyParser.urlencoded({ extended: false }));

// Register the task routes
var playerTasks = require('./tasks/player.js');

app.post('/player/authenticate', playerTasks.authenticate);

app.get('/', function(req, res) {
    res.writeHead(200, { 'Content-Type': 'application/json' });

    res.write(JSON.stringify({
        error: "Invalid request"
    }));

    res.end();
});

var server = app.listen(1000, function() {
    var host = server.address().address;
    var port = server.address().port;

    console.log('Storage service listening at http://%s:%s', host, port);
});
