/*

    OpenHabbo Master service is basically a web service that allows other services to interface with the Redis
    service without needing to connect to Redis directly.

 */

var redis = require('redis'),
    client = redis.createClient(6379, "redis.eu.openhabbo.com"),
    express = require('express'),
    app = express();

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