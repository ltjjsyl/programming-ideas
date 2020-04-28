package cn.chuxiao.designpattern.factory.jdbc.v2;

import cn.chuxiao.designpattern.factory.jdbc.Connection;

import java.lang.reflect.Constructor;
import java.util.Properties;


//配置文件格式：Connection-type.properties
//mysql = com.mysql.jdbc.MysqlConnectioImpl
//oracle = com.oracle.jdbc.OracleConnection
//db2 = com.ibm.db2.Db2ConnectionImpl
//other =...

//使用配置文件增加灵活性
public class ConnectionFactoryV2 {

    public static Connection create(String type, Properties info) {

        Class<?> clazz = getConnectionClass(type);

        try {
            Constructor<?> constructor = clazz.getConstructor(Properties.class);
            return (Connection) constructor.newInstance(info);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("unsupported db type" + type);
        }
    }

    //通过配置文件，获取对应类信息
    private static Class getConnectionClass(String type) {
        //...
        return null;
    }
}
