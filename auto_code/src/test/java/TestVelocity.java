import com.mic.generator.beforecommon.util.string.StringUtil;
import com.mic.generator.beforecommon.util.velocity.VelocityUtil;
import com.mic.generator.beforedomain.analyzer.mysql.Column;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * velocity模板
 */
public class TestVelocity {

    private  Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * velocity模板生成代码测试
     *
     */
    @Test
    public void testVelocityGeneratorCode1(){

        Velocity.init();
        VelocityContext context = new VelocityContext();
        context.put("packagePath", "com.mic.user");
        context.put("tableNameCH", "用户信息");
        context.put("tableNameEN", "user_info");
        context.put("author", "zhaoming");
        context.put("dateTime", new Date());
        context.put("tableClassNameEN", "UserInfo");
        context.put("tablePropertyNameEN", "userInfo");


        Column pkColumn = new Column();
        pkColumn.setColumnNameCH("主键ID");
        pkColumn.setColumnNameEN("id");
        pkColumn.setColumnPropertyName("id");
        pkColumn.setColumnMethodName("Id");
        pkColumn.setJavaType("String");
        pkColumn.setJdbcType("VARCHAR");
        context.put("pkColumn",pkColumn);

        List<Column> columnList = new ArrayList<Column>();
        Column column1 = new Column();
        column1.setColumnNameCH("用户名称");
        column1.setColumnNameEN("user_name");
        column1.setColumnPropertyName("userName");
        column1.setColumnMethodName("UserName");
        column1.setJavaType("String");
        column1.setJdbcType("VARCHAR");
        columnList.add(column1);
        Column column2 = new Column();
        column2.setColumnNameCH("用户编码");
        column2.setColumnNameEN("user_code");
        column2.setColumnPropertyName("userCode");
        column2.setColumnMethodName("UserCode");
        column2.setJavaType("String");
        column2.setJdbcType("VARCHAR");
        columnList.add(column2);
        context.put("columnList",columnList);

        StringWriter w = new StringWriter();
        Velocity.mergeTemplate("src/main/resources/templet/sqlMapperTemplet.vm", "UTF-8", context, w );

        System.out.println(" template : ");
        System.out.println(" templatePath : "+Velocity.FILE_RESOURCE_LOADER_CACHE);
        System.out.println(w);
    }

    @Test
    public void testVelocityGeneratorCode2(){

        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("packagePath", "com.mic.user");
        hashMap.put("tableNameCH", "用户信息");
        hashMap.put("tableNameEN", "user_info");
        hashMap.put("author", "zhaoming");
        hashMap.put("dateTime", new Date());
        hashMap.put("tableClassNameEN", "UserInfo");
        hashMap.put("tablePropertyNameEN", "userInfo");


        Column pkColumn = new Column();
        pkColumn.setColumnNameCH("主键ID");
        pkColumn.setColumnNameEN("id");
        pkColumn.setColumnPropertyName("id");
        pkColumn.setColumnMethodName("Id");
        pkColumn.setJavaType("String");
        pkColumn.setJdbcType("VARCHAR");
        hashMap.put("pkColumn",pkColumn);

        List<Column> columnList = new ArrayList<Column>();
        Column column1 = new Column();
        column1.setColumnNameCH("用户名称");
        column1.setColumnNameEN("user_name");
        column1.setColumnPropertyName("userName");
        column1.setColumnMethodName("UserName");
        column1.setJavaType("String");
        column1.setJdbcType("VARCHAR");
        columnList.add(column1);
        Column column2 = new Column();
        column2.setColumnNameCH("用户编码");
        column2.setColumnNameEN("user_code");
        column2.setColumnPropertyName("userCode");
        column2.setColumnMethodName("UserCode");
        column2.setJavaType("String");
        column2.setJdbcType("VARCHAR");
        columnList.add(column2);
        hashMap.put("columnList",columnList);

        String templatePath = this.getClass().getResource("/").toString().substring("file:/".length())+"templet/";
        StringWriter stringWriter = VelocityUtil.getGeneratorCode(templatePath, "sqlMapperTemplet.vm", hashMap);
        System.out.println(stringWriter);
    }

    @Test
    public void testVelocityGeneratorCode3(){

        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("packagePath", "com.mic.user");
        hashMap.put("tableNameCH", "用户信息");
        hashMap.put("tableNameEN", "user_info");
        hashMap.put("author", "zhaoming");
        hashMap.put("dateTime", new Date());
        hashMap.put("tableClassNameEN", "UserInfo");
        hashMap.put("tablePropertyNameEN", "userInfo");


        Column pkColumn = new Column();
        pkColumn.setColumnNameCH("主键ID");
        pkColumn.setColumnNameEN("id");
        pkColumn.setColumnPropertyName("id");
        pkColumn.setColumnMethodName("Id");
        pkColumn.setJavaType("String");
        pkColumn.setJdbcType("VARCHAR");
        hashMap.put("pkColumn",pkColumn);

        List<Column> columnList = new ArrayList<Column>();
        Column column1 = new Column();
        column1.setColumnNameCH("用户名称");
        column1.setColumnNameEN("user_name");
        column1.setColumnPropertyName("userName");
        column1.setColumnMethodName("UserName");
        column1.setJavaType("String");
        column1.setJdbcType("VARCHAR");
        columnList.add(column1);
        Column column2 = new Column();
        column2.setColumnNameCH("用户编码");
        column2.setColumnNameEN("user_code");
        column2.setColumnPropertyName("userCode");
        column2.setColumnMethodName("UserCode");
        column2.setJavaType("String");
        column2.setJdbcType("VARCHAR");
        columnList.add(column2);
        hashMap.put("columnList",columnList);

        String templatePath = this.getClass().getResource("/").toString().substring("file:/".length())+"templet/";
        VelocityUtil.generatorCode(templatePath, "sqlMapperTemplet.vm", hashMap, "C://userInfoMapper.xml");
    }

    @Test
    public void stringUtils(){
        String aa = "useR_info";
        System.out.println(StringUtil.humpToLowerCaseFirstOne(aa, "_"));
        System.out.println(StringUtil.humptoUpperCaseFirstOne(aa, "_"));

        String fileName = this.getClass().getResource("/").toString();
        fileName = fileName.substring("file:/".length(), fileName.length());
        System.out.println(fileName);

    }
}