package cn.chuxiao.designpattern.factory.jdbc.v3;

import cn.chuxiao.designpattern.factory.jdbc.Connection;

import java.util.Properties;

//可以把配置信息放在配置文件中
public class ConnectionFactoryUse {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        Properties info = new Properties();
        info.put("host", "localhost");
        info.put("port", "3306");
        info.put("database", "test");
        info.put("username", "root");
        info.put("password", "xxx");

        Class<?> clazz = Class.forName("cn.chuxiao.designpattern.factory.jdbc.v3.MysqlConnectionFactory");
        ConnectionFactory factory = (ConnectionFactory) clazz.newInstance();

        Connection connection = factory.create(info);
    }
}
