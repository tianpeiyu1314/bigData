package cn.yunhe.service.impl;

import cn.yunhe.PageBean;
import cn.yunhe.dao.AccountDao;
import cn.yunhe.dao.impl.AccountDaoImpl;
import cn.yunhe.entity.Account;
import cn.yunhe.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    AccountDao accountDao=new AccountDaoImpl();
    @Override
    public PageBean findPage(String currentPage, String pageSize) {
        PageBean pb = new PageBean();
        int cpage = Integer.parseInt(currentPage);
        int size = Integer.parseInt(pageSize);
        pb.setCurrentPage(cpage);
        pb.setPageSize(size);
        //获取用户想看的数据 根据 想看的页码和每页显示条数
        List<Account> list = accountDao.findEmpByLimit(cpage,size);
        //封装数据
        pb.setList(list);
        List<Account> allEmployees = accountDao.findAllAccount();
        //封装总条数
        pb.setTotalCount(allEmployees.size());
        return pb;
    }

}
