package org.arvin;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("org.arvin.mapper")
@EnableAutoDataSourceProxy    // 开启seata
@EnableFeignClients(basePackages = "org.arvin.service.openfeign")
public class OrderService
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderService.class,args);
    }
}
