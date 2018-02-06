package com.clawhub.test.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.clawhub.test.TestFacade;
import com.clawhub.util.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <Description> 测试接口 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月05日<br>
 */
@Service
public class TestFacadeImpl implements TestFacade {
    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(TestFacadeImpl.class);

    /**
     * Description: Execute <br>
     *
     * @param param param
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Override
    public String execute(String param) {
        logger.info("execute====================");
        return JsonUtil.getSucc("10001");
    }
}