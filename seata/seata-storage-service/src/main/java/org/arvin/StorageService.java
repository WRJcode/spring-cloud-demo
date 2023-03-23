package org.arvin;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("org.arvin.mapper")
@EnableAutoDataSourceProxy    // 开启seata
public class StorageService
{
    public static void main( String[] args )
    {
        SpringApplication.run(StorageService.class,args);
    }
}
