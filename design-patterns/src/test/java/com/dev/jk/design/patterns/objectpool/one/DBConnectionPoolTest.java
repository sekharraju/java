package com.dev.jk.design.patterns.objectpool.one;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionPoolTest {

    private DBConnectionPool dbConnectionPool;

    @Before
    public void setUp() throws SQLException {
        dbConnectionPool = DBConnectionPoolImpl.create("jdbc:h2:mem:test", "sa", "");
    }

    @Test
    public void testConnection() {
        Connection connection = dbConnectionPool.getConnection();
        Assertions.assertThat(connection).isNotNull();
    }
}
