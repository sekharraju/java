package com.dev.jk.design.patterns.factory;

import com.dev.jk.design.patterns.factory.resource.type.DB2DBConnectionImpl;
import com.dev.jk.design.patterns.factory.resource.type.OracleDBConnectionImpl;
import com.dev.jk.design.patterns.factory.resource.type.PostgresDBConnectionImpl;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DBConnectionFactoryImplTest {

    private DBConnectionFactory dbConnectionFactory;

    @Before
    public void setUp() {
        dbConnectionFactory = new DBConnectionFactoryImpl();
    }

    @Test
    public void assertNonNullResources() {
        assertThat(dbConnectionFactory.createConnection("ORACLE")).isInstanceOf(OracleDBConnectionImpl.class);
        assertThat(dbConnectionFactory.createConnection("DB2")).isInstanceOf(DB2DBConnectionImpl.class);
        assertThat(dbConnectionFactory.createConnection("POSTGRES")).isInstanceOf(PostgresDBConnectionImpl.class);
        assertThat(dbConnectionFactory.createConnection("UNKNOWN")).isNull();
    }

}

