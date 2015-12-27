package com.openhabbo.api.data.players;

public class Player {
    private int id;
    private String username;
    private String authenticationTicket;
    private int accountId;

    // TODO: enums for these
    private String gender;
    private String figure;

    private int balanceCoins;
    private int balanceActivityPoints;

    public Player(int id, String username, String authenticationTicket, int accountId, String gender, String figure, int balanceCoins, int balanceActivityPoints) {
        this.id = id;
        this.username = username;
        this.authenticationTicket = authenticationTicket;
        this.accountId = accountId;
        this.gender = gender;
        this.figure = figure;
        this.balanceCoins = balanceCoins;
        this.balanceActivityPoints = balanceActivityPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthenticationTicket() {
        return authenticationTicket;
    }

    public void setAuthenticationTicket(String authenticationTicket) {
        this.authenticationTicket = authenticationTicket;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public int getBalanceCoins() {
        return balanceCoins;
    }

    public void setBalanceCoins(int balanceCoins) {
        this.balanceCoins = balanceCoins;
    }

    public int getBalanceActivityPoints() {
        return balanceActivityPoints;
    }

    public void setBalanceActivityPoints(int balanceActivityPoints) {
        this.balanceActivityPoints = balanceActivityPoints;
    }
}
