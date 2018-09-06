package com.mic.generator.bussiness.autocode;

/**
 * Created by dblc on 2018/8/31.
 */

import com.mic.generator.bussiness.autocode.model.AutoTable;

import java.util.List;

/**
 * 客户端传入的初始DB值
 */
public class AutoDBDomain {

    private String dbName;//数据库名称 eg：db_substation2

    private List<AutoTable> tableList;//数据库中的表列表

    private String authorName;  //作者名字 eg：dblc

    private String packagePath;//基础包路径   eg:com.ln.dblc

    private String projMakeTime;//自动项目创建时间  eg：2018-09-06 12:34:17

    public String getProjMakeTime() {
        return projMakeTime;
    }

    public void setProjMakeTime(String projMakeTime) {
        this.projMakeTime = projMakeTime;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public List<AutoTable> getTableList() {
        return tableList;
    }

    public void setTableList(List<AutoTable> tableList) {
        this.tableList = tableList;
    }
}
