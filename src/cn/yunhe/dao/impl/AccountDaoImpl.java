package cn.yunhe.dao.impl;

import cn.yunhe.PageBean;
import cn.yunhe.dao.AccountDao;
import cn.yunhe.entity.Account;
import cn.yunhe.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
    @Override
    public List<Account> findEmpByLimit(int cpage, int size) {
        String sql="select * from account limit ?,?";
        int start=(cpage-1)*size;
        try {
           return qr.query(sql,new BeanListHandler<Account>(Account.class),start,size);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> findAllAccount() {
        String sql="select * from account";
        try {
            return qr.query(sql,new BeanListHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
