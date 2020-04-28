package cn.chuxiao.designpattern.factory.jdbc.v4;


import cn.chuxiao.designpattern.factory.jdbc.Connection;

public class Db2ConnectionFactory implements ConnectionFactory {

    static {
        ConnectionFactoryManager.register(new Db2ConnectionFactory());
    }

    @Override
    public Connection create(String url, String userName, String password) {
        if (acceptUrl(url)) {
            //...创建Db2Connection
        }
        return null;
    }

    @Override
    public boolean acceptUrl(String url) {
        return url.startsWith("jdbc:db2");
    }
}
