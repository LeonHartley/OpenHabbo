var storage = require('./storage.js'),
    web = require('./web.js'),
    domain = require('domain').create();

domain.on('error', function(err) {
    console.log('Uncaught error', err.message);
});