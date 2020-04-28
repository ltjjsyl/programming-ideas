package cn.chuxiao.designpattern.factory.jdbc.v4;

import cn.chuxiao.designpattern.factory.jdbc.Connection;

public class MysqlConnectionFactory implements ConnectionFactory {

    static {
        ConnectionFactoryManager.register(new MysqlConnectionFactory());
    }

    @Override
    public Connection create(String url, String userName, String password) {
        if (acceptUrl(url)) {
            //...创建MysqlConnection
        }
        return null;
    }

    @Override
    public boolean acceptUrl(String url) {
        return url.startsWith("jdbc:mysql");
    }
}
