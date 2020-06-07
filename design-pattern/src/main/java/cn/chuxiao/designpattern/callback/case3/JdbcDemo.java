package cn.chuxiao.designpattern.callback.case3;


import java.sql.*;

/**
 * queryUser() 函数包含很多流程性质的代码，跟业务无关
 * 比如，加载驱动、创建数据库连 接、创建 statement、关闭连接、关闭 statement、处理异常
 */
public class JdbcDemo {

    public User queryUser(int id) {
        Connection connection = null;
        Statement statement = null;

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", null);

            //2.创建statement类对象，用来执行SQL语句
            statement = connection.createStatement();
            String sql = "select * from user where id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setTelephone(resultSet.getString("telephone"));
                return user;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) try {
                connection.close();
            } catch (SQLException e) {
                // TODO: log...
            }
            if (statement != null) try {
                statement.close();
            } catch (SQLException e) {
                // TODO: log...        }
            }
        }
        return null;
    }
}