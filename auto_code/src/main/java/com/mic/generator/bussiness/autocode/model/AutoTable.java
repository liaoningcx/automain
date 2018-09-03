package com.mic.generator.bussiness.autocode.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据源的一个Table基础信息，for自动生成代码用
 * Created by caoxue on 2016/5/20.
 */
public class AutoTable {

    private Integer radomInt;//domain的serlize随机数

    private String tableSqlName;//表名字。eg：lgd_student
    private String tableComment;//表的注释；eg：理工大的学生表

    private String domainClassNameEN;//domain的类名 -- 首字母大写 波浪式命名；eg:LgdStudent
    private String domainPropertyNameEN;//domain用来做属性 -- 首字母小写 波浪式命名  eg:lgdStudent

    private String authorName;//作者
    private String extendsClassList;//扩展功能类的信息

    //基本框架 -- domain 用到column ;
    private List<ColumnAuto> basicColumnList;//表中基础属性
    ColumnAuto pkcolumn = new ColumnAuto();//主键
    ColumnAuto deleteFlagColumn = new ColumnAuto();//逻辑删除标识

    public String getTableName() {
        return tableSqlName;
    }

    public void setTableName(String tableSqlName) {
        this.tableSqlName = tableSqlName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getDomainClassNameEN() {
        return domainClassNameEN;
    }

    public void setDomainClassNameEN(String domainClassNameEN) {
        this.domainClassNameEN = domainClassNameEN;
    }

    public String getDomainPropertyNameEN() {
        return domainPropertyNameEN;
    }

    public void setDomainPropertyNameEN(String domainPropertyNameEN) {
        this.domainPropertyNameEN = domainPropertyNameEN;
    }

    public String getAuthor() {
        return authorName;
    }

    public void setAuthor(String author) {
        this.authorName = author;
    }

    public String getExtendsClassList() {
        return extendsClassList;
    }

    public void setExtendsClassList(String extendsClassList) {
        this.extendsClassList = extendsClassList;
    }

    public List<ColumnAuto> getBasicColumnList() {
        return basicColumnList;
    }

    public void setBasicColumnList(List<ColumnAuto> basicColumnList) {
        this.basicColumnList = basicColumnList;
    }

    public ColumnAuto getPkcolumn() {
        return pkcolumn;
    }

    public void setPkcolumn(ColumnAuto pkcolumn) {
        this.pkcolumn = pkcolumn;
    }

    public ColumnAuto getDeleteFlagColumn() {
        return deleteFlagColumn;
    }

    public void setDeleteFlagColumn(ColumnAuto deleteFlagColumn) {
        this.deleteFlagColumn = deleteFlagColumn;
    }

    public Integer getRadomInt() {
        return radomInt;
    }

    public void setRadomInt(Integer radomInt) {
        this.radomInt = radomInt;
    }
}
