var express = require('express'),
    bodyParser = require('body-parser'),
    app = express(),
    http = require('http'),
    monitoring = require('./monitoring/monitoring.js');
    server = require('./server/server.js');

app.use(bodyParser.urlencoded({ extended: false }));

var rooms = require('./routes/rooms.js');

//app.post("/sessions/register", sessions.registerSession);
//app.post("/sessions/unregister", sessions.unregisterSession);
//app.post("/sessions/findAlias", sessions.findAlias);

app.post("/rooms/register", rooms.registerRoom);
app.post("/rooms/unregister", rooms.unregisterRoom);
app.post("/rooms/findAlias", rooms.findAlias);

app.get('/', function(req, res) {
    res.writeHead(200, { 'Content-Type': 'application/json' });

    res.write(JSON.stringify({
       error: "Invalid request"
    }));

    res.end();
});

app.get('/initialize', function(req, res) {
    res.writeHead(200, { 'Content-Type': 'application/json' });

    res.write(JSON.stringify({
        success: true
    }));

    res.end();
});

app.use("/events", express.static('web'));

var httpServer = app.listen(3000, function() {
    var host = httpServer.address().address;
    var port = httpServer.address().port;

    console.log('Master service listening at http://%s:%s', host, port);
});

monitoring.initialize(httpServer);