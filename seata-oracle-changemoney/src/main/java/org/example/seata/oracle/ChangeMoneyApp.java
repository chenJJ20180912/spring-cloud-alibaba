package org.example.seata.oracle;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author chenjia
 * @date : 2021/2/20 16:46
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableAutoDataSourceProxy
public class ChangeMoneyApp {
    public static void main(String[] args) {
        SpringApplication.run(ChangeMoneyApp.class,args);
    }
}
