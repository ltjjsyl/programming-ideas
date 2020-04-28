package cn.chuxiao.designpattern.factory.jdbc.v4;

import cn.chuxiao.designpattern.factory.jdbc.Connection;

public interface ConnectionFactory {

    Connection create(String url, String userName, String password);

    boolean acceptUrl(String url);
}
