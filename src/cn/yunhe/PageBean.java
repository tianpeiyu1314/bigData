package cn.yunhe;

import cn.yunhe.entity.Account;

import java.util.List;

public class PageBean {
    private int currentPage;//当前页
    private int pageSize;//每页显示条数
    private int totalCount;//总条数
    //查询数据库得到的数据    根据  想看的页码+每页显示的条数
    private List<Account> list;

    public PageBean() {
    }

    public PageBean(int currentPage, int pageSize, int totalCount, List<Account> list) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Account> getList() {
        return list;
    }

    public void setList(List<Account> list) {
        this.list = list;
    }
}
