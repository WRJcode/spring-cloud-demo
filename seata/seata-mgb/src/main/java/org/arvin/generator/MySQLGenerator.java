package org.arvin.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;


public class MySQLGenerator extends BaseGenerator{

    /**
     * 配置数据源
     */

    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/seata_storage?useUnicode=true&useSSL=false&characterEncoding=utf8",
            "root", "")
            .schema("arvin")
            .build();

    public static void main(String[] args){
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(strategyConfig().build());
        generator.global(globalConfig().build());
        generator.packageInfo(packageConfig().build());
        generator.injection(injectionConfig().build());
        generator.execute();
    }
}
