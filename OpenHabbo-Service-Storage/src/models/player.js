module.exports = {
    username: {type: String, limit: 255},
    authenticationTicket: {type: String, limit: 50},
    accountId: { type: Number },

    gender: { type: String, limit: 1 },
    figure: { type: String, limit: 512 }
}