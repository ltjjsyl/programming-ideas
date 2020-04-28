package cn.chuxiao.designpattern.factory.jdbc.v3;

import cn.chuxiao.designpattern.factory.jdbc.Connection;

import java.util.Properties;

public class MysqlConnectionFactory implements ConnectionFactory {

    @Override
    public Connection create(Properties info) {
        return null;
    }
}
