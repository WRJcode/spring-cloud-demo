package org.arvin;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("org.arvin.mapper")
@EnableAutoDataSourceProxy    // 开启seata
public class AccountService
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext applicationContext =
        SpringApplication.run(AccountService.class,args);
        String userName = applicationContext.getEnvironment().getProperty("username");
        String userAge = applicationContext.getEnvironment().getProperty("age");
        System.err.println("user name :"+userName+"; age: "+userAge);
    }
}
