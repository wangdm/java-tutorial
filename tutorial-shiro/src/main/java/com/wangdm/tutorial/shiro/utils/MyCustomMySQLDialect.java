package com.wangdm.tutorial.shiro.utils;

import org.hibernate.dialect.MySQL5InnoDBDialect;

public class MyCustomMySQLDialect extends MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
