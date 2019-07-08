package com.dev.jk.design.patterns.factory;

import com.dev.jk.design.patterns.factory.resource.DBConnection;

public interface DBConnectionFactory {

    DBConnection createConnection(String dbConnectionType);

}
