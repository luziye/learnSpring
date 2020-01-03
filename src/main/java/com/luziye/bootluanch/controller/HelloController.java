package com.luziye.bootluanch.controller;

import com.luziye.bootluanch.exception.AjaxResponse;
import com.luziye.bootluanch.model.ArticleVo;
import com.luziye.bootluanch.service.ExceptionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @Resource
    ExceptionService exceptionService;

    @RequestMapping("/ex/system")
    public AjaxResponse hello() {
        exceptionService.userBizError(-1);
        return AjaxResponse.success();
    }

    @RequestMapping("/ex/user")
    public AjaxResponse hellouser(Integer input) {
        return AjaxResponse.success(exceptionService.userBizError( input));
    }

    @RequestMapping("/ex/user2")
    public AjaxResponse hellouser2(String input1,String input2,String input3) {
        return AjaxResponse.success(exceptionService.nullParamError(input1,input2,input3));
    }
}
