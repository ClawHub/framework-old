package com.clawhub.test;

import com.clawhub.spring.SpringContextHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * <Description> 服务启动 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月05日<br>
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.clawhub"})
public class GateWayApp {
    /**
     * Description: 启动springboot<br>
     *
     * @param args <br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext confApp = null;
        try {
            confApp = SpringApplication.run(GateWayApp.class, args);

        } finally {
            close(confApp);
        }

    }

    /**
     * Description:  注入springContextHelper <br>
     *
     * @return spring context helper
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Bean
    public SpringContextHelper springHelper() {
        return new SpringContextHelper();
    }


    /**
     * Description: 优雅关闭服务 <br>
     *
     * @param confApp conf app
     * @author LiZhiming <br>
     * @taskId <br>
     */
    private static void close(ConfigurableApplicationContext confApp) {

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                if (confApp != null) {
                    confApp.close();
                }
            }
        });
    }
}