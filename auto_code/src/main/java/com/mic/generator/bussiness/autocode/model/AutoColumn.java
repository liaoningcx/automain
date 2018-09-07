package com.mic.generator.bussiness.autocode.model;

/**
 * 由客户端传送的表的列信息
 * Created by caoxue on 2016/5/19.
 */
public class AutoColumn {
    private String columnSQLName;//SQL数据库中的列名  eg:stu_name
    private String columnClassName;//类文件属性名称.      eg:stuName
    private String columnClassNameFirstCap;//类文件属性名称，首字母大写。 用于get、set方法   eg：StuName
    private String columnSqlDataType;//列类型--SQL类型    eg:varchar
    private String columnSqlDataTypeAllCap;//JDBC列类型--SQL类型所有字母大写    eg:VARCHAR
    private String columnClassDataType;//类文件 属性类型     eg：String
    private String columnDataTypeLength;//列限制长度   eg：20，50    varchar(20)
    private String columnDataDefaultValue;//列默认值   eg：1，haha    create sql default value
    private boolean isPKColumn;//是否是主键
    private boolean isAllowNullColumn;//是否允许为空
    private boolean isAutoUpColumn;//是否递增
    private String columnAnnotation;//列注释           eg:学生名字



    public String getColumnSQLName() {
        return columnSQLName;
    }

    public void setColumnSQLName(String columnSQLName) {
        this.columnSQLName = columnSQLName;
    }

    public String getColumnSqlDataType() {
        return columnSqlDataType;
    }

    public void setColumnSqlDataType(String columnSqlDataType) {
        this.columnSqlDataType = columnSqlDataType;
    }


    public String getColumnDataTypeLength() {
        return columnDataTypeLength;
    }

    public void setColumnDataTypeLength(String columnDataTypeLength) {
        this.columnDataTypeLength = columnDataTypeLength;
    }

    public String getColumnDataDefaultValue() {
        return columnDataDefaultValue;
    }

    public void setColumnDataDefaultValue(String columnDataDefaultValue) {
        this.columnDataDefaultValue = columnDataDefaultValue;
    }

    public boolean isPKColumn() {
        return isPKColumn;
    }

    public void setPKColumn(boolean PKColumn) {
        isPKColumn = PKColumn;
    }

    public boolean isAllowNullColumn() {
        return isAllowNullColumn;
    }

    public void setAllowNullColumn(boolean allowNullColumn) {
        isAllowNullColumn = allowNullColumn;
    }

    public boolean isAutoUpColumn() {
        return isAutoUpColumn;
    }

    public void setAutoUpColumn(boolean autoUpColumn) {
        isAutoUpColumn = autoUpColumn;
    }

    public String getColumnAnnotation() {
        return columnAnnotation;
    }

    public void setColumnAnnotation(String columnAnnotation) {
        this.columnAnnotation = columnAnnotation;
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

    public String getColumnClassDataType() {
        return columnClassDataType;
    }

    public void setColumnClassDataType(String columnClassDataType) {
        this.columnClassDataType = columnClassDataType;
    }

    public String getColumnSqlDataTypeAllCap() {
        return columnSqlDataTypeAllCap;
    }

    public void setColumnSqlDataTypeAllCap(String columnSqlDataTypeAllCap) {
        this.columnSqlDataTypeAllCap = columnSqlDataTypeAllCap;
    }
}
