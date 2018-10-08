package com.thinking.springbootincation.framework.web.page;

import com.thinking.springbootincation.common.constant.CommonConsants;
import com.thinking.springbootincation.common.util.ServletUtils;

/**
 * @Author：caoj
 * @Description： 表格数据处理
 * @Date：Created in 2018/7/24
 */
public class TableSupport {

    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain() {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(CommonConsants.PAGENUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(CommonConsants.PAGESIZE));
        pageDomain.setOrderByColumn(ServletUtils.getParameter(CommonConsants.ORDERBYCOLUMN));
        pageDomain.setIsAsc(ServletUtils.getParameter(CommonConsants.ISASC));
        return pageDomain;
    }

    public static PageDomain buildPageRequest() {
        return getPageDomain();
    }

}
