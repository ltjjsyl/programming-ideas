package cn.chuxiao.designpattern.callback.case3;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JdbcTemplateImpl {

    public <T> List<T> query(String sql, RowMapper<T> rowMapper) throws DataAccessException {
        return query(sql, new RowMapperResultSetExtractor<T>(rowMapper));
    }

    public <T> T query(final String sql, final ResultSetExtractor<T> rse) throws DataAccessException {
        Assert.notNull(sql, "SQL must not be null");
        Assert.notNull(rse, "ResultSetExtractor must not be null");

        //回调 业务逻辑相关
        class QueryStatementCallback implements StatementCallback<T>, SqlProvider {
            @Override
            public T doInStatement(Statement stmt) throws SQLException {
                ResultSet rs = null;
                try {
                    rs = stmt.executeQuery(sql);
                    ResultSet rsToUse = rs;
//            if (nativeJdbcExtractor != null) {
//                rsToUse = nativeJdbcExtractor.getNativeResultSet(rs);
//            }
                    return rse.extractData(rsToUse);
                } finally {
                    JdbcUtils.closeResultSet(rs);
                }
            }

            @Override
            public String getSql() {
                return sql;
            }
        }
        return execute(new QueryStatementCallback());
    }


    //模板 抽象过程
    public <T> T execute(StatementCallback<T> action) throws DataAccessException {
        Assert.notNull(action, "Callback object must not be null");
        Connection con = DataSourceUtils.getConnection(getDataSource());
        Statement stmt = null;
        try {
            Connection conToUse = con;
//            if (this.nativeJdbcExtractor != null && this.nativeJdbcExtractor.isNativeConnectionNecessaryForNativeStatements()) {
//                conToUse = this.nativeJdbcExtractor.getNativeConnection(con);
//            }
            stmt = conToUse.createStatement();
//            applyStatementSettings(stmt);
            Statement stmtToUse = stmt;
//            if (this.nativeJdbcExtractor != null) {
//                stmtToUse = this.nativeJdbcExtractor.getNativeStatement(stmt);
//            }
            T result = action.doInStatement(stmtToUse);
//            handleWarnings(stmt);
            return result;
        } catch (SQLException ex) {
            // Release Connection early, to avoid potential connection pool deadlock
            // in the case when the exception translator hasn't been initialized yet.
            JdbcUtils.closeStatement(stmt);
            stmt = null;
            DataSourceUtils.releaseConnection(con, getDataSource());
            con = null;
//            throw getExceptionTranslator().translate("StatementCallback", getSql(action)
        } finally {
            JdbcUtils.closeStatement(stmt);
            DataSourceUtils.releaseConnection(con, getDataSource());
        }
        return null;
    }


    public DataSource getDataSource() {
        return null;
    }
}
