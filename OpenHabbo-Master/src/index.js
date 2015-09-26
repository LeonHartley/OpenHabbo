var redis = require('redis'),
    client = redis.createClient(6379, "redis.eu.openhabbo.com"),
    express = require('express'),
    bodyParser = require('body-parser'),
    app = express();

app.use(bodyParser.urlencoded({ extended: false }));

var sessions = require('./routes/sessions.js');
sessions.initialize(client);

app.post("/sessions/register", sessions.registerSession);
app.post("/sessions/unregister", sessions.unregisterSession);
app.post("/sessions/findAlias", sessions.findAlias);

app.get('/', function(req, res) {
    res.writeHead(200, { 'Content-Type': 'application/json' });

    res.write(JSON.stringify({
       error: "Invalid request"
    }));

    res.end();
});

var server = app.listen(3000, function() {
    var host = server.address().address;
    var port = server.address().port;

    console.log('Master service listening at http://%s:%s', host, port);
});