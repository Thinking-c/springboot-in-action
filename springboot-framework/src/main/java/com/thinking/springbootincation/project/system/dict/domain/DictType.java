package com.thinking.springbootincation.project.system.dict.domain;


import com.thinking.springbootincation.framework.aspect.annotation.Excel;
import com.thinking.springbootincation.framework.web.domain.BaseEntity;

/**
 * @Author：caoj
 * @Description： 数据字典 sys_dict_type
 * @Date：Created in 2018/7/26
 */
public class DictType extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 字典主键
     */
    @Excel(name = "字典主键")
    private Long dictId;

    /**
     * 字典名称
     */
    @Excel(name = "字典名称")
    private String dictName;

    /**
     * 字典类型
     */
    @Excel(name = "字典类型 ")
    private String dictType;

    /**
     * 状态（0正常 1停用）
     */
    @Excel(name = "状态")
    private String status;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DictType [dictId=" + dictId + ", dictName=" + dictName + ", dictType=" + dictType + ", status=" + status
                + "]";
    }

}
