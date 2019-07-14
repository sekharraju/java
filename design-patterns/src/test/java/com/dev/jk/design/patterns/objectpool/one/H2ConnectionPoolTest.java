package com.dev.jk.design.patterns.objectpool.one;

import com.dev.jk.design.patterns.objectpool.two.H2ConnectionPool;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.sql.Connection;

public class H2ConnectionPoolTest {

    @Test
    public void test()
    {
        H2ConnectionPool pool = new H2ConnectionPool(
                "org.h2.Driver",
                "jdbc:h2:mem:test",
                "sa", "");
        Connection con = pool.leaseResource();
        Assertions.assertThat(con).isNotNull();
        pool.requiteResource(con);
    }
}
