package com.mic.generator.bussiness.autocode.model;

import java.util.List;

/**
 * 数据源的一个Table基础信息，for自动生成代码用
 * Created by caoxue on 2016/5/20.
 */
public class AutoTable {

    private Integer radomInt;//domain的serlize随机数

    private String tableSqlName;//表名字。eg：lgd_student
    private String tableClassNameFirstCap;//domain的类名 -- 首字母大写 波浪式命名；eg:LgdStudent
    private String tableClassName;//domain用来做属性 -- 首字母小写 波浪式命名  eg:lgdStudent
    private String tableAnnontation;//表的注释；eg：理工大的学生表

    private String extendsClassList;//扩展功能类的信息

    //基本框架 -- domain 用到column ;
    private List<AutoColumn> basicColumnList;//表中基础属性
    AutoColumn pkcolumn;//主键
    AutoColumn deleteFlagColumn;//逻辑删除标识

    public String getTableName() {
        return tableSqlName;
    }

    public void setTableName(String tableSqlName) {
        this.tableSqlName = tableSqlName;
    }

    public String getTableSqlName() {
        return tableSqlName;
    }

    public void setTableSqlName(String tableSqlName) {
        this.tableSqlName = tableSqlName;
    }

    public String getTableAnnontation() {
        return tableAnnontation;
    }

    public void setTableAnnontation(String tableAnnontation) {
        this.tableAnnontation = tableAnnontation;
    }


    public String getTableClassNameFirstCap() {
        return tableClassNameFirstCap;
    }

    public void setTableClassNameFirstCap(String tableClassNameFirstCap) {
        this.tableClassNameFirstCap = tableClassNameFirstCap;
    }

    public String getTableClassName() {
        return tableClassName;
    }

    public void setTableClassName(String tableClassName) {
        this.tableClassName = tableClassName;
    }

    public String getExtendsClassList() {
        return extendsClassList;
    }

    public void setExtendsClassList(String extendsClassList) {
        this.extendsClassList = extendsClassList;
    }

    public List<AutoColumn> getBasicColumnList() {
        return basicColumnList;
    }

    public void setBasicColumnList(List<AutoColumn> basicColumnList) {
        this.basicColumnList = basicColumnList;
    }

    public AutoColumn getPkcolumn() {
        return pkcolumn;
    }

    public void setPkcolumn(AutoColumn pkcolumn) {
        this.pkcolumn = pkcolumn;
    }

    public AutoColumn getDeleteFlagColumn() {
        return deleteFlagColumn;
    }

    public void setDeleteFlagColumn(AutoColumn deleteFlagColumn) {
        this.deleteFlagColumn = deleteFlagColumn;
    }

    public Integer getRadomInt() {
        return radomInt;
    }

    public void setRadomInt(Integer radomInt) {
        this.radomInt = radomInt;
    }
}
