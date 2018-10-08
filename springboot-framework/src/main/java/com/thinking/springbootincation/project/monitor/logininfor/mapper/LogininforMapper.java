package com.thinking.springbootincation.project.monitor.logininfor.mapper;

import com.thinking.springbootincation.project.monitor.logininfor.domain.Logininfor;

import java.util.List;

/**
 * @Author：caoj
 * @Description： 系统访问记录 数据层
 * @Date：Created in 2018/7/26
 */
public interface LogininforMapper {
    /**
     * 新增系统登录日志
     *
     * @param logininfor 访问日志对象
     */
    public void insertLogininfor(Logininfor logininfor);

    /**
     * 查询系统登录日志集合
     *
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    public List<Logininfor> selectLogininforList(Logininfor logininfor);

    /**
     * 批量删除系统登录日志
     *
     * @param ids 需要删除的数据
     * @return
     */
    public int deleteLogininforByIds(String[] ids);
}
