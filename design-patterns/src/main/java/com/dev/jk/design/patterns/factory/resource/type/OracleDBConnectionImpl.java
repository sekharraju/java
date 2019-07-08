package com.dev.jk.design.patterns.factory.resource.type;

import com.dev.jk.design.patterns.factory.resource.DBConnection;

public class OracleDBConnectionImpl implements DBConnection {

    @Override
    public void executeDBCall(String query) {
        System.out.println("executed "+ query + " in oracle DB");
    }

}
