package com.dev.jk.design.patterns.objectpool.two;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionPool extends ResourcePool<Connection> {
    private String url;
    private String user;
    private String password;

    public H2ConnectionPool(String driver, String url, String user, String password) {
        super();
        try {
            Class.forName(driver);
            this.url = url;
            this.user = user;
            this.password = password;
        } catch (Exception e) {
            throw new RuntimeException("driver class loading failed", e);
        }
    }

    Connection create() {
        try {
            return (DriverManager.getConnection(url, user, password));
        } catch (SQLException e) {
            throw new RuntimeException("connection creation failed", e);
        }
    }

    void expireIt(Connection o) {
        try {
             o.close();
        } catch (SQLException e) {
            throw new RuntimeException("connection closing failed", e);
        }
    }

    boolean validate(Connection o) {
        try {
            return !o.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
