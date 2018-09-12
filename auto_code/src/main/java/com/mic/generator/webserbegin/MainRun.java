package com.mic.generator.webserbegin;

import com.mic.generator.bussiness.autocode.AutoDBDomain;
import com.mic.generator.bussiness.autocode.model.AutoColumn;
import com.mic.generator.bussiness.autocode.model.AutoTable;
import com.mic.generator.common.util.JsonUtil;
import com.mic.generator.webser.MicMsg;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dd on 2018/9/11.
 */
public class MainRun {

    public static void main(String args [] ){
        try {
            AutoDBDomain dbDomain = _getAutoDBDomain();
            String val = JsonUtil.toJson(dbDomain);
            System.out.println("解析的报文为："+val);

            //真正执行的方法
            ResponseEntity entity = new MicMsg().testWebSer2(null, val);

            System.out.println(entity);
            System.out.println("————END————");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    private static AutoDBDomain _getAutoDBDomain() {
        AutoDBDomain dbDomain = new AutoDBDomain();
        dbDomain.setAuthorName("大胖子");
        List<AutoTable> tables = new ArrayList<AutoTable>();
        for (int x=0;x<2;x++){
            AutoTable autoTable = new AutoTable();
            List<AutoColumn> basicColumns = new ArrayList<AutoColumn>();
            for (int i=0;i<5;i++){
                AutoColumn nomalAuto = new AutoColumn();
                nomalAuto.setColumnAnnotation("表列名的注释" + i);
                nomalAuto.setColumnClassName("taTestNBA" + i);
                nomalAuto.setColumnClassNameFirstCap("TaTestNBA" + i);
                nomalAuto.setColumnClassDataType("String");
                nomalAuto.setColumnSqlDataTypeAllCap("VARCHAR");
                nomalAuto.setColumnSQLName("ta_Test_NBA"+i);
                nomalAuto.setColumnSqlDataType("varchar");
                basicColumns.add(nomalAuto);
            }
            autoTable.setBasicColumnList(basicColumns);

            AutoColumn delAuto = new AutoColumn();
            delAuto.setColumnAnnotation("逻辑删除标识");
            delAuto.setColumnClassName("yn");
            delAuto.setColumnClassNameFirstCap("Yn");
            delAuto.setColumnClassDataType("Integer");
            delAuto.setColumnSqlDataTypeAllCap("INTEGER");
            delAuto.setColumnSQLName("yn");
            delAuto.setColumnSqlDataType("int");
            autoTable.setDeleteFlagColumn(delAuto);

            autoTable.setTableAnnontation("第三次测试表");
            autoTable.setTableClassNameFirstCap("ThirdTestBy"+x);
            autoTable.setTableClassName("thirdTestBy"+x);

            autoTable.setExtendsClassList(null);
            AutoColumn pkAuto = new AutoColumn();
            pkAuto.setColumnAnnotation("第三次主键注释");
            pkAuto.setColumnClassName("thirdid");
            pkAuto.setColumnClassNameFirstCap("Thirdid");
            pkAuto.setColumnSQLName("sqlthirdid");
            pkAuto.setColumnSqlDataType("int");
            pkAuto.setColumnClassDataType("Integer");
            pkAuto.setColumnSqlDataTypeAllCap("INTEGER");
            autoTable.setPkcolumn(pkAuto);

            autoTable.setRadomInt(9222833);
            tables.add(autoTable);
        }

        dbDomain.setTableList(tables);
        dbDomain.setPackagePath("com.auto");
        dbDomain.setProjMakeTime("2018/9/6 15:28");
        return dbDomain;
    }

}
