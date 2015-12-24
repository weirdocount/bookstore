package com.weirdo.dao.impl;

import com.weirdo.dao.DAO;
import com.weirdo.util.ConnectionContext;
import com.weirdo.util.JDBCUtils;
import com.weirdo.util.ReflectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Administrator on 2015/12/16.
 */
public class BaseDAO<T> implements DAO<T>{

    private QueryRunner queryRunner = new QueryRunner();
    private Class<T> clazz;

    public BaseDAO() {
        this.clazz = ReflectionUtils.getSuperGenericType(getClass());
    }

    /**
     * 插入数据
     *
     * @param sql
     * @param args
     * @return
     */
    public long insert(String sql, Object... args) {
        long id = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
//            connection = ConnectionContext.getInstance().get();
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            if(args != null){
                for(int i = 0; i < args.length; i++){
                    preparedStatement.setObject(i + 1, args[i]);
                }
            }

            preparedStatement.executeUpdate();

            //获取生成的主键值
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                id = resultSet.getLong(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtils.release(resultSet, preparedStatement);
            JDBCUtils.release(connection);
        }

        return id;
    }

    /**
     * 更新数据
     *
     * @param sql
     * @param args
     */
    public void update(String sql, Object... args) {
        Connection connection = null;

        try {
//            connection = ConnectionContext.getInstance().get();
            connection = JDBCUtils.getConnection();
            queryRunner.update(connection, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.release(connection);
        }
    }

    /**
     * 获取单个数据
     *
     * @param sql
     * @param args
     * @return
     */
    public T query(String sql, Object... args) {
        Connection connection = null;

        try {
//            connection = ConnectionContext.getInstance().get();
            connection = JDBCUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.release(connection);
        }

        return null;
    }

    /**
     * 获取列表
     *
     * @param sql
     * @param args
     * @return
     */
    public List queryForList(String sql, Object... args) {
        Connection connection = null;

        try {
//            connection = ConnectionContext.getInstance().get();
            connection = JDBCUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.release(connection);
        }
        return null;
    }

    /**
     * 批量操作
     *
     * @param sql
     * @param params
     */
    public void batch(String sql, Object[]... params) {
        Connection connection = null;

        try {
//            connection = ConnectionContext.getInstance().get();
            connection = JDBCUtils.getConnection();
            queryRunner.batch(connection, sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.release(connection);
        }
    }

    /**
     * 获取某个查询的值
     *
     * @param sql
     * @param args
     * @return
     */
    public <V> V getSingleVal(String sql, Object... args) {
        Connection connection = null;

        try {
//            connection = ConnectionContext.getInstance().get();
            connection = JDBCUtils.getConnection();
            return (V)queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.release(connection);
        }

        return null;
    }
}
