package cn.chuxiao.designpattern.callback.case3;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Spring JdbcTemplate
 * JDBI... 都是类似的思路
 * 只需要编写跟这个业务有关的代码，
 * 其中包括，查询用户的SQL语句、查询结果与User对象之间的映射关系。
 * 其他流程性质的代码都封装在了JdbcTemplate类中，不需要每次都重新编写。
 */
public class JdbcTemplateDemo {

    JdbcTemplate jdbcTemplate;

    public User queryUser(int id) {
        String sql = "select * from user where id = " + id;
        return jdbcTemplate.query(sql, new UserMapper()).get(0);
    }

    class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setTelephone(resultSet.getString("telephone"));
            return user;
        }
    }
}
