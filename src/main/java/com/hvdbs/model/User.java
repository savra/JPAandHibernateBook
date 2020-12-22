package com.hvdbs.model;

import java.math.BigDecimal;

public class User {
    protected String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal calcShippingCosts() {
        return null;
    }
}
