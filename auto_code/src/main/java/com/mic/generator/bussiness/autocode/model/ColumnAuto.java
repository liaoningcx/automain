package com.mic.generator.bussiness.autocode.model;

/**
 * 由客户端传送的表的列信息
 * Created by caoxue on 2016/5/19.
 */
public class ColumnAuto {

    private String tableSqlName;//表名字。eg：lgd_student
    private String tableComment;//表的注释；eg：理工大的学生表

    private String columnSQLName;//SQL数据库中的列名  eg:stu_name
    private String columnSQLType;//列类型--SQL类型    eg:varchar
    private String columnSQLJDBCTypeAllCap;//JDBC列类型--SQL类型所有字母大写    eg:VARCHAR
    private String columnSQLComment;//列注释           eg:学生名字

    private String columnClassName;//类文件属性名称.      eg:stuName

    private String columnClassNameFirstCap;//类文件属性名称，首字母大写。 用于get、set方法   eg：StuName

    private String columnClassType;//类文件 属性类型     eg：String


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

    public String getColumnSQLName() {
        return columnSQLName;
    }

    public void setColumnSQLName(String columnSQLName) {
        this.columnSQLName = columnSQLName;
    }

    public String getColumnSQLType() {
        return columnSQLType;
    }

    public void setColumnSQLType(String columnSQLType) {
        this.columnSQLType = columnSQLType;
    }

    public String getColumnSQLComment() {
        return columnSQLComment;
    }

    public void setColumnSQLComment(String columnSQLComment) {
        this.columnSQLComment = columnSQLComment;
    }

    public String getColumnClassName() {
        return columnClassName;
    }

    public void setColumnClassName(String columnClassName) {
        this.columnClassName = columnClassName;
    }

    public String getColumnClassNameFirstCap() {
        return columnClassNameFirstCap;
    }

    public void setColumnClassNameFirstCap(String columnClassNameFirstCap) {
        this.columnClassNameFirstCap = columnClassNameFirstCap;
    }

    public String getColumnClassType() {
        return columnClassType;
    }

    public void setColumnClassType(String columnClassType) {
        this.columnClassType = columnClassType;
    }

    public String getColumnSQLJDBCTypeAllCap() {
        return columnSQLJDBCTypeAllCap;
    }

    public void setColumnSQLJDBCTypeAllCap(String columnSQLJDBCTypeAllCap) {
        this.columnSQLJDBCTypeAllCap = columnSQLJDBCTypeAllCap;
    }
}
