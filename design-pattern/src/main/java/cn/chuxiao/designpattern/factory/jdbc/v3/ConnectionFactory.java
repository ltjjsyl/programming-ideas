package cn.chuxiao.designpattern.factory.jdbc.v3;

import cn.chuxiao.designpattern.factory.jdbc.Connection;

import java.util.Properties;

public interface ConnectionFactory {

    Connection create(Properties info);
}
