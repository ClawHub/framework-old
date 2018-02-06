package com.clawhub.test.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clawhub.common.BaseController;
import com.clawhub.test.TestFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <Description> 测试Controller <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月05日<br>
 */
@RestController
@CrossOrigin
@RequestMapping("testCtr")
@Api(value = "/testCtr", tags = "测试Controller")
public class TestController extends BaseController {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(TestController.class);
    /**
     * The Test facade.
     */
    @Reference(timeout = TIME_OUT, retries = 2)
    private TestFacade testFacade;

    /**
     * Description: Execute <br>
     *
     * @param param param
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    @ApiOperation(notes = "执行", value = "执行", produces = "application/json")
    String execute(@RequestParam String param) {
        logger.info(param);
        return testFacade.execute(param);
    }
}