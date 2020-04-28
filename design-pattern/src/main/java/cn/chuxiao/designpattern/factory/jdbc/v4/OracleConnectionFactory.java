package cn.chuxiao.designpattern.factory.jdbc.v4;

import cn.chuxiao.designpattern.factory.jdbc.Connection;

public class OracleConnectionFactory implements ConnectionFactory {

    static {
        ConnectionFactoryManager.register(new OracleConnectionFactory());
    }

    @Override
    public Connection create(String url, String userName, String password) {
        if (acceptUrl(url)) {
            //...创建OracleConnection
        }
        return null;
    }

    @Override
    public boolean acceptUrl(String url) {
        return url.startsWith("jdbc:oracle");
    }
}
