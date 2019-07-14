package com.dev.jk.design.patterns.objectpool.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionPoolImpl implements DBConnectionPool {

    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();
    private static int INITIAL_POOL_SIZE = 3;

    private DBConnectionPoolImpl(List<Connection> pool) {
        this.connectionPool = pool;
    }

    public static DBConnectionPoolImpl create(String url, String user, String password) throws SQLException {
        try {
            List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
            Class.forName ("org.h2.Driver");
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                pool.add(createConnection(url, user, password));
            }
            return new DBConnectionPoolImpl(pool);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("org.h2.Driver class not found");
        }
    }

    @Override
    public Connection getConnection() {
        Connection connection = connectionPool
                .remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    private static Connection createConnection(
            String url, String user, String password)
            throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

}
