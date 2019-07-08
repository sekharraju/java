package com.dev.jk.design.patterns.factory;

import com.dev.jk.design.patterns.factory.resource.DBConnection;
import com.dev.jk.design.patterns.factory.resource.type.DB2DBConnectionImpl;
import com.dev.jk.design.patterns.factory.resource.type.OracleDBConnectionImpl;
import com.dev.jk.design.patterns.factory.resource.type.PostgresDBConnectionImpl;

public class DBConnectionFactoryImpl implements DBConnectionFactory {

    @Override
    public DBConnection createConnection(String dbConnectionType) {
        DBConnection dbConnection = null;
        switch (dbConnectionType) {
            case "ORACLE" : dbConnection = new OracleDBConnectionImpl();break;
            case "DB2" : dbConnection = new DB2DBConnectionImpl();break;
            case "POSTGRES" : dbConnection = new PostgresDBConnectionImpl();break;
            default:
        }
        return dbConnection;
    }

}
