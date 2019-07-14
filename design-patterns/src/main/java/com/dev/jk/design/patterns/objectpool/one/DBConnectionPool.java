package com.dev.jk.design.patterns.objectpool.one;

import java.sql.Connection;

public interface DBConnectionPool {

    Connection getConnection();

    boolean releaseConnection(Connection connection);

}
