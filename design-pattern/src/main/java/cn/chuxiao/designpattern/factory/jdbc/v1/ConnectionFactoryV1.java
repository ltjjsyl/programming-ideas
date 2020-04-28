package cn.chuxiao.designpattern.factory.jdbc.v1;

import cn.chuxiao.designpattern.factory.jdbc.Connection;
import cn.chuxiao.designpattern.factory.jdbc.Db2Connnection;
import cn.chuxiao.designpattern.factory.jdbc.MysqlConnection;
import cn.chuxiao.designpattern.factory.jdbc.OracleConnection;

import java.util.Properties;


//简单工厂，静态工厂方法，没有结合单例模式
//不灵活，如果实现类改名或增加新的类型都需要修改，违反OCP
public class ConnectionFactoryV1 {

    public static Connection create(String type, Properties info) {

        if ("mysql".equalsIgnoreCase(type)) {
            return new MysqlConnection(info);
        }
        if ("oracle".equalsIgnoreCase(type)) {
            return new OracleConnection(info);
        }
        if ("db2".equalsIgnoreCase(type)) {
            return new Db2Connnection(info);
        }

        throw new RuntimeException("unsupported db type = " + type);
    }
}
