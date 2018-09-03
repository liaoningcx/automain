package com.mic.generator.beforeaction.analyzer.pdm;

import com.mic.generator.beforeservice.analyzer.pdm.PdmGenerationService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 默认控制器
 *
 * User: NIXIANG
 * DateTime: 12-10-24 下午4:10
 * Version: 1.0
 */
@Controller
@RequestMapping("/pdmGenerator")
public class PdmGeneratorController {

    private static Logger logger = Logger.getLogger(PdmGeneratorController.class);

    @Resource
    private PdmGenerationService pdmGenerationService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(
            @RequestParam(value = "locale", required = false) Locale locale,
            HttpServletRequest request,
            HttpServletResponse response) {
        logger.debug("11111111111111111111111111111111111111111");
        logger.debug("11111111111111111111111111111111111111111");
        logger.debug("11111111111111111111111111111111111111111");
        logger.debug("11111111111111111111111111111111111111111");
        logger.debug("11111111111111111111111111111111111111111");
        logger.debug("11111111111111111111111111111111111111111");
        logger.debug("11111111111111111111111111111111111111111");
        pdmGenerationService.index();
        return "/analyzer/pdm/pdm-generation-index";
    }

    @RequestMapping(value = "/ajaxSubmitTest", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Model ajaxSubmitTest(Model model) {
        logger.debug("11111111111111111111111111111111111111111");
        logger.debug("11111111111111111111111111111111111111111");
        logger.debug("11111111111111111111111111111111111111111");
        logger.debug("11111111111111111111111111111111111111111");
        logger.debug("11111111111111111111111111111111111111111");
        logger.debug("11111111111111111111111111111111111111111");
        logger.debug("11111111111111111111111111111111111111111");

        if(1==1){
            throw new RuntimeException("ajax Exception");
        }

        String aa = pdmGenerationService.ajaxSubmitTest();
        model.addAttribute("flag",aa);
        return model;
    }

    @RequestMapping(value = "/formSubmitTest", method = RequestMethod.POST)
    public String formSubmitTest(Model model){

        String aa = pdmGenerationService.formSubmitTest();
        if(1==1){
            throw new RuntimeException("form Exception");
        }
        model.addAttribute("flag",aa);
        return "/analyzer/pdm/pdm-generation-index";
    }

}
