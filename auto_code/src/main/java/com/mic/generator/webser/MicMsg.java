package com.mic.generator.webser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mic.generator.beforecommon.util.velocity.VelocityUtil;
import com.mic.generator.beforedomain.table.TableInfo;
import com.mic.generator.bussiness.autocode.AutoDBDomain;
import com.mic.generator.bussiness.autocode.model.AutoColumn;
import com.mic.generator.bussiness.autocode.model.AutoTable;
import com.mic.generator.bussiness.autocode.model.TemplateFile;
import com.mic.generator.bussiness.autocode.util.FrameAutoUtil;
import com.mic.generator.bussiness.autocode.util.TemplateFileUtil;
import com.mic.generator.common.constant.CommonConstant;
import com.mic.generator.common.util.JsonUtil;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.*;
import java.util.List;

/**
 * Created by caoxue on 2015/12/15.
 */
@Controller
@RequestMapping("/micMsg")
public class MicMsg {

    private static Logger logger = Logger.getLogger(MicMsg.class);

    /**
     * 界面的test按钮——暂时
     * @param request
     * @param value
     * @return
     */
    @RequestMapping(value = "/testWebSer2",method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
    public ResponseEntity testWebSer2(HttpServletRequest request, String value){
        try{
            System.out.println("The Value is "+value);

            //当前项目路径
            String currentProjectPath = this.getClass().getResource("/").toString().substring("file:/".length());  //file:/D:/dev_h/realDev/auto_code/target/classes/
            //框架文件目录：  currentProjectPath + 自动代码总目录 + 框架结构
            String frameBasePath = currentProjectPath + "framebean"+File.separator+"springmvcframe";
            //自动代码生成区的目录：   currentProjectPath + 自动代码生成区 + 自动项目的总文件夹
            String autoProjPath = currentProjectPath + "autoprojproduct" +File.separator +"autoProjWin";

            //业务模板目录
            String templatePath = currentProjectPath + "templet";// 模板目录  file:/D:/dev_h/realDev/auto_code/target/classes/templet\
            //入参的数据信息
            AutoDBDomain autoDBDomain = JsonUtil.fromJsonByGoogle(value, new TypeToken<AutoDBDomain>() {
            });
            //制作框架固定文件--如js等
            FrameAutoUtil.AutoFrameMake(frameBasePath,autoProjPath);


            //制作业务动态文件，--如spring配置文件中的扫描文件。eg：spring-config.xml
            List<String> mapperFileList = new ArrayList<String>();
            //遍历每个表，制作每个表的业务代码；eg：controller，service，dao，mapper等
            List<TemplateFile> bussinessTemplateFileList = TemplateFileUtil.getAutoBussinessframeTemplateFileListFromPath(currentProjectPath);
            for (AutoTable eachAutoTable : autoDBDomain.getTableList()){
                HashMap<String,Object> bussinessTemplateAutoMapValue = _getBussinessTemplateAutoCodeName(autoDBDomain,eachAutoTable);
                for (TemplateFile eachTemplateFile : bussinessTemplateFileList){
                    String autoFileNamePath = autoProjPath+"/src/main/"+eachTemplateFile.getTemplatePath()+File.separator+eachTemplateFile.getFilePath()+File.separator+bussinessTemplateAutoMapValue.get("tableClassNameFirstCap")+eachTemplateFile.getFileName();//D:/dev_h/realDev/auto_code/target/classes/templet/aaa.vm
                    //检测文件是否存在
                    File file = new File(autoFileNamePath);
                    if (!file.exists()) {
                        File filePath = new File(file.getParent());
                        filePath.mkdirs();
                    }
                    VelocityUtil.generatorCode(templatePath, eachTemplateFile.getTemplateName(), bussinessTemplateAutoMapValue, autoFileNamePath);
                    if("sqlMapperTemplet".equals(eachTemplateFile.getCode())){
                        mapperFileList.add("mybatis"+File.separator+eachTemplateFile.getFilePath()+File.separator+bussinessTemplateAutoMapValue.get("tableClassNameFirstCap")+eachTemplateFile.getFileName());
                    }
                }
            }

            //制作基础框架动态文件，--如spring配置文件中的扫描文件。eg：spring-config.xml
            //获取模板Liat
            List<TemplateFile> baseTemplateFileList = TemplateFileUtil.getAutoBaseframeTemplateFileListFromPath(currentProjectPath);
            HashMap<String,Object> autoBaseFrameVal = _getBaseTemplateAutoCodeName(autoDBDomain);
            //根据业务产生的sql文件，对应给mybatis的自动生成
            autoBaseFrameVal.put("sqlMapperFileList",mapperFileList);
            for (TemplateFile eachBaseTemplateFile : baseTemplateFileList){
                String autoFileNamePath = autoProjPath+"/src/main/"+eachBaseTemplateFile.getTemplatePath()+File.separator+eachBaseTemplateFile.getFilePath()+File.separator+eachBaseTemplateFile.getFileName();
                //检测文件是否存在
                File file = new File(autoFileNamePath);
                if (!file.exists()) {
                    File filePath = new File(file.getParent());
                    filePath.mkdirs();
                }
                VelocityUtil.generatorCode(templatePath, eachBaseTemplateFile.getTemplateName(), autoBaseFrameVal, autoFileNamePath);
            }
            VelocityUtil.generatorCode(templatePath,"mybatisConfigTemplate.vm", autoBaseFrameVal, autoProjPath+"/src/main/resources/mybatis"+File.separator+"mybatis-config.xml");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    private HashMap<String, Object> _getBaseTemplateAutoCodeName(AutoDBDomain autoDBDomain) {
        HashMap<String, Object> mapval = new HashMap<String, Object>();

        //基本框架 -- dao，impl，service，impl
        mapval.put("packagePath", autoDBDomain.getPackagePath());//包名基础路径，不带dao、service、manager这类的包名，在他们的上一级；

        return mapval;
    }

    /**
     * 获取业务部分的mapvalue信息
     * @param autoDBDomain
     * @param autoTable
     * @return
     */
    private HashMap<String, Object> _getBussinessTemplateAutoCodeName(AutoDBDomain autoDBDomain ,AutoTable autoTable) {
        HashMap<String, Object> mapval = new HashMap<String, Object>();

        //基本框架 -- dao，impl，service，impl
        mapval.put("packagePath", autoDBDomain.getPackagePath());//包名基础路径，不带dao、service、manager这类的包名，在他们的上一级；
        mapval.put("tableClassNameFirstCap", autoTable.getTableClassNameFirstCap());//domain名字 -- 与表名一致  //domain的类名 -- 首字母大写 波浪式命名；eg:LgdStudent
        mapval.put("tableClassName", autoTable.getTableClassName());//domain用来做属性 -- 首字母小写 用来做domain的属性命名  eg:DomainNameEN domainNameEN
        mapval.put("tableAnnontation", autoTable.getTableAnnontation());//domain名字汉字 --  表名的解释  ///表的注释；eg：理工大的学生表
        mapval.put("authorName", autoDBDomain.getAuthorName());//作者
        mapval.put("projMakeTime",(StringUtils.isEmpty(autoDBDomain.getProjMakeTime()))?new Date().toString():autoDBDomain.getProjMakeTime());//生成时间
        mapval.put("extendsClassList", autoTable.getExtendsClassList());//扩展功能类的信息,根据客户端选择，生成功能性的bean

        //基本框架 -- domain 用到column
        mapval.put("basicColumnList", autoTable.getBasicColumnList());//表中基础属性
        mapval.put("pkColumn", autoTable.getPkcolumn());//主键
        mapval.put("deleteFlagColumn", autoTable.getDeleteFlagColumn());//逻辑删除标识

        //domain用到的随机serlizer
        mapval.put("radomMathInt", autoTable.getRadomInt());//随机

        return mapval;
    }

    /**
     * 获取业务部分的mapvalue信息
     * @param autoDBDomain
     * @param tableIndex
     * @return
     */
    private HashMap<String, Object> _getBussinessTemplateAutoCodeName(AutoDBDomain autoDBDomain ,int tableIndex) {
        AutoTable autoTable = autoDBDomain.getTableList().get(tableIndex);
        return _getBussinessTemplateAutoCodeName(autoDBDomain,autoTable);
    }

}
