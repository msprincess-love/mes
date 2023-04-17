package com.ktg;

import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 启动程序
 *
 * @author wanghuili
 */
@EnableAsync
@ImportResource("classpath:ureport-console-context.xml")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HTApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(HTApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  MES启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

    @Bean
    public ServletRegistrationBean urportServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new UReportServlet());
        bean.addUrlMappings("/ureport/*");
        return bean;
    }
}
