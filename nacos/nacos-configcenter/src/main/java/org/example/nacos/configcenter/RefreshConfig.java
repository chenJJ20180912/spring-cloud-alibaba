package org.example.nacos.configcenter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author chenjia
 * @date : 2021/2/3 21:01
 */
@Component
@RefreshScope
public class RefreshConfig {

    @Value("${key}")
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
