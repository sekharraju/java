package com.dev.jk.design.patterns.singleton;

public enum SingletonDataSourceEnum {

    SINGLETON_ORACLE_DATASOURCE_INSTANCE;

    private final String code = "Oracle Data source";

    SingletonDataSourceEnum() {

    }

    public static SingletonDataSourceEnum getSingletonInstance() {
        return SINGLETON_ORACLE_DATASOURCE_INSTANCE;
    }

    public String getCode() {
        return code;
    }
}
