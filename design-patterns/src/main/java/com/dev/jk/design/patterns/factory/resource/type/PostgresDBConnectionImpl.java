package com.dev.jk.design.patterns.factory.resource.type;

import com.dev.jk.design.patterns.factory.resource.DBConnection;

public class PostgresDBConnectionImpl implements DBConnection {

    @Override
    public void executeDBCall(String query) {
        System.out.println("executed "+ query + " in Postgres DB");
    }

}
