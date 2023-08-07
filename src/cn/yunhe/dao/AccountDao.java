package cn.yunhe.dao;

import cn.yunhe.PageBean;
import cn.yunhe.entity.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findEmpByLimit(int cpage, int size);

    List<Account> findAllAccount();
}
