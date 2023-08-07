package cn.yunhe.service;

import cn.yunhe.PageBean;
import cn.yunhe.entity.Account;

import java.util.List;

public interface AccountService {
    PageBean findPage(String currentPage, String pageSize);

}
