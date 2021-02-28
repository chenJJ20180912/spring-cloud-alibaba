package org.example.nacos.theory;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.Iterator;
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenjia
 * @date : 2021/2/5 10:45
 */
public class ConfigExample {

    public static void main(String[] args) throws Exception {
        String dataId= "test-dataId";
        String group = "DEFAULT_GROUP";
        String serverAddr = "127.0.0.1:8848";
        Properties properties = new Properties();

        properties.setProperty("serverAddr",serverAddr);

        // 创建一个配置服务
        ConfigService configService = NacosFactory.createConfigService(properties);

        String config = configService.getConfig(dataId, group, 5000);
        System.out.printf("got content: \n%s\n", config);
        configService.addListener(dataId, group, new Listener() {
            // 监听配置刷新
            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.printf("time: %d, receive:\n%s\n", System.currentTimeMillis(), configInfo);
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        });

        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
