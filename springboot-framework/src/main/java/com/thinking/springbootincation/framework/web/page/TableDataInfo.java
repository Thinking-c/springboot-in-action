package com.thinking.springbootincation.framework.web.page;

import java.io.Serializable;
import java.util.List;

/**
 * @Author：caoj
 * @Description： 表格分页数据对象
 * @Date：Created in 2018/7/24
 */
public class TableDataInfo implements Serializable {

    private static final long serialVersionUID = 6134562983050381321L;

    /**
     * 总记录数
     */
    private long total;
    /**
     * 列表数据
     */
    private List<?> rows;

    /**
     * 表格数据对象
     */
    public TableDataInfo() {
    }

    /**
     * 分页
     *
     * @param list  列表数据
     * @param total 总记录数
     */
    public TableDataInfo(List<?> list, int total) {
        this.rows = list;
        this.total = total;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
