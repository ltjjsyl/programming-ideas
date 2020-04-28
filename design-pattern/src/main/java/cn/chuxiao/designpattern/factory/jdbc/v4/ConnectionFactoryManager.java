package cn.chuxiao.designpattern.factory.jdbc.v4;

import cn.chuxiao.designpattern.factory.jdbc.Connection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//隐藏ConnectionFatory,有点类似ApplicationContext的意思
public class ConnectionFactoryManager {

    private static List<ConnectionFactory> factories = new CopyOnWriteArrayList<>();

    public static Connection getConnection(String url, String userName, String password) {
        for (ConnectionFactory factory : factories) {
            Connection connection = factory.create(url, userName, password);
            if (connection != null) {
                return connection;
            }
        }
        throw new RuntimeException("can't create connection");
    }

    public static void register(ConnectionFactory factory) {
        factories.add(factory);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //ConnectionFactoryManager的使用

        //加载驱动
        Class.forName("cn.chuxiao.designpattern.factory.jdbc.v4.MysqlConnectionFactory");
        //活动连接，可以放在配置文件中
        Connection connection = ConnectionFactoryManager.
                getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "xxx");

    }
}
